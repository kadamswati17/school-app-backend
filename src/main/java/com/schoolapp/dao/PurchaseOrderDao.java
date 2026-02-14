package com.schoolapp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.schoolapp.entity.PurchaseOrder;

import com.schoolapp.repository.PurchaseOrderRepo;


@Component
public class PurchaseOrderDao {
	@Autowired
	PurchaseOrderRepo purchaseOrderRepo;

	int existInqMst = 0;

	public List<PurchaseOrder> savePurchaseOrder(List<PurchaseOrder> purchaseOrder) throws ClassNotFoundException, SQLException {

		for (PurchaseOrder al2 : purchaseOrder) {

			int srValide = al2.getPurchaseOrderMstId();

			if (srValide == 0) {

				Date purchaseDate = al2.getPurchaseDate();
				int customerId = al2.getCustomerId();
				int userId = al2.getUserId();
				int orgId = al2.getOrgId();
				int branchId = al2.getBranchId();
				Date createdDate = al2.getCreatedDate();
				int updatedBy = al2.getUpdatedBy();
				Date updatedDate = al2.getUpdatedDate();
				int isActive = al2.getIsActive();
				int srNo = 0;
				int total = 0;
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpdb", "root", "root");

				String sql = "INSERT INTO purchase_order_master( date, customer_id, branch_id, created_date, is_active, org_id,   updated_by, updated_date, user_id,srno,total) "
						+ "VALUES (?,?, ?, ?, ?, ?, ?, ?, ?,?,?)";

				PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

				pst.setDate(1, purchaseDate);
				pst.setInt(2, customerId);
				pst.setInt(3, branchId);
				pst.setDate(4, createdDate);
				pst.setInt(5, isActive);
				pst.setInt(6, orgId);
				pst.setInt(7, updatedBy);
				pst.setDate(8, updatedDate);
				pst.setInt(9, userId);
				pst.setInt(10, srNo);
				pst.setInt(11, total);
				pst.executeUpdate();

				ResultSet rs = pst.getGeneratedKeys();
				int purchaseOrderId = -1;
				if (rs.next()) {
					purchaseOrderId = rs.getInt(1);
				}
				for (PurchaseOrder al3 : purchaseOrder) {
					al3.setPurchaseOrderMstId(purchaseOrderId);
					existInqMst = purchaseOrderId;
				}
			}

			System.out.println("Data inserted successfully...");
			return purchaseOrderRepo.saveAll(purchaseOrder);
		}
		return purchaseOrder;
	}

	public PurchaseOrder updateDeletePurchaseOrder(PurchaseOrder purchaseOrder) throws ClassNotFoundException, SQLException {
		Integer purchaseOrderId = purchaseOrder.getPurchaseOrderId();
		int userId = purchaseOrder.getUserId();
		int updatedBy = purchaseOrder.getUpdatedBy();
		Date updatedDate = purchaseOrder.getUpdatedDate();
		int branchId = purchaseOrder.getBranchId();
		int orgId = purchaseOrder.getOrgId();
		int isActive = purchaseOrder.getIsActive();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpdb", "root", "root");
		String query = "update purchase_detailes set is_active=?, updated_by=?,updated_date=? "
				+ "where purchase_detailes_id=? and org_id=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, isActive);
		ps.setInt(2, updatedBy);
		ps.setDate(3, updatedDate);
		ps.setInt(4, purchaseOrderId);
		ps.setInt(5, orgId);
		ps.executeUpdate();
		System.out.println("Record updated");
		return purchaseOrderRepo.save(purchaseOrder);
	}

	public List<PurchaseOrder> getAllPurchaseOrder() throws Exception {

		return purchaseOrderRepo.findAll();
	}

	public PurchaseOrder findPurchaseOrderById(int PurchaseOrderId) {
		return (PurchaseOrder) purchaseOrderRepo.findById(PurchaseOrderId).get();
	}

	public String deletePurchaseOrderById(int PurchaseOrderId) {
		purchaseOrderRepo.deleteById(PurchaseOrderId);
		return "deleted";
	}
}
