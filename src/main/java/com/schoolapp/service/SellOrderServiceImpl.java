package com.schoolapp.service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.schoolapp.dao.SellOrderDto;
import com.schoolapp.entity.SellOrder;
import com.schoolapp.enums.OrderStatus;
import com.schoolapp.repository.SellOrderRepository;

//import com.Crmemp.dto.request.SellOrderDto;
//import com.Crmemp.entity.SellOrder;
//import com.Crmemp.enums.OrderStatus;
//import com.Crmemp.repository.SellOrderRepository;

@Service
public class SellOrderServiceImpl implements SellOrderService {

    private final SellOrderRepository repository;

    public SellOrderServiceImpl(SellOrderRepository repository) {
        this.repository = repository;
    }

    // ================= GET ALL SELL ORDERS =================
    @Override
    public List<SellOrderDto> getAllSellOrders() {
        return repository.findAll()
                .stream()
                .map(SellOrder::getSellOrderDto)
                .collect(Collectors.toList());
    }

    // ================= CHANGE SELL ORDER STATUS =================
    @Override
    public SellOrderDto changeSellOrderStatus(Long orderId, String status) {

        SellOrder order = repository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Sell Order not found"));

        order.setOrderStatus(OrderStatus.valueOf(status.toUpperCase()));
        return repository.save(order).getSellOrderDto();
    }

    // ================= COMBINED SELL ORDER DETAILS =================
    @Override
    public String getCombinedSellOrderData(Long orderId)
            throws ClassNotFoundException, SQLException, JSONException, IOException {

        JSONArray dataArray = new JSONArray();

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ecom_project",
                "root",
                "root"
        );

        String query =
                "SELECT o.id AS order_id, o.user_id, u.email, o.order_status, o.amount, o.date AS order_date, " +
                "ci.product_id, p.name AS product_name, p.price AS product_price, p.img AS product_img, ci.quantity " +
                "FROM sell_orders o " +
                "JOIN users u ON o.user_id = u.id " +
                "JOIN sell_cart_items ci ON o.id = ci.order_id " +
                "JOIN product p ON ci.product_id = p.id " +
                "WHERE o.id = ?";

        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setLong(1, orderId);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            JSONObject row = new JSONObject();
            row.put("orderId", rs.getLong("order_id"));
            row.put("userId", rs.getLong("user_id"));
            row.put("email", rs.getString("email"));
            row.put("orderStatus", rs.getString("order_status"));
            row.put("amount", rs.getLong("amount"));
            row.put("orderDate", rs.getString("order_date"));
            row.put("productId", rs.getLong("product_id"));
            row.put("productName", rs.getString("product_name"));
            row.put("productPrice", rs.getDouble("product_price"));
            row.put("quantity", rs.getInt("quantity"));

            // ===== IMAGE BLOB → BASE64 =====
            Blob blob = rs.getBlob("product_img");
            if (blob != null) {
                InputStream is = blob.getBinaryStream();
                ByteArrayOutputStream os = new ByteArrayOutputStream();

                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = is.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }

                String base64 = Base64.getEncoder().encodeToString(os.toByteArray());
                row.put("productImg", base64);

                is.close();
                os.close();
            } else {
                row.put("productImg", JSONObject.NULL);
            }

            dataArray.put(row);
        }

        rs.close();
        stmt.close();
        con.close();

        return dataArray.toString();
    }
}
