package com.schoolapp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.schoolapp.entity.SalesOrderMaster;
import com.schoolapp.repository.SalesOrderMasterRepo;

@Component
public class SalesOrderMasterDao {

	@Autowired
	SalesOrderMasterRepo salesOrderMasterRepo;

	public SalesOrderMaster saveSalesOrderMaster(SalesOrderMaster salesOrderMaster)
			throws ClassNotFoundException, SQLException {
		System.out.println("Data inserted successfully...");
		System.out.println(salesOrderMaster);
		return salesOrderMasterRepo.save(salesOrderMaster);
	}

	public SalesOrderMaster updateDeleteSalesOrderMaster(SalesOrderMaster salesOrderMaster)
			throws ClassNotFoundException, SQLException {
		Integer salesOrderMasterId = salesOrderMaster.getSalesOrderMstId();
//		Contractor accounts = contractorDao.findContractorById(contractor.getContractorId());

		int userId = salesOrderMaster.getUserId();
		int updatedBy = salesOrderMaster.getUpdatedBy();
		Date updatedDate = salesOrderMaster.getUpdatedDate();
		int branchId = salesOrderMaster.getBranchId();
		int orgId = salesOrderMaster.getOrgId();
		int isActive = salesOrderMaster.getIsActive();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpdb", "root", "root");
		String query = "update sales_master set is_active=?, updated_by=?,updated_date=? "
				+ "where sales_id=? and org_id=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, isActive);
		ps.setInt(2, updatedBy);
		ps.setDate(3, updatedDate);
		ps.setInt(4, salesOrderMasterId);
		ps.setInt(5, orgId);
		ps.executeUpdate();
		System.out.println("Record updated");
		return salesOrderMasterRepo.save(salesOrderMaster);
	}

	public String getAllSales(SalesOrderMaster salesOrderMaster) throws SQLException, ClassNotFoundException {
		JSONArray result = new JSONArray();
		int orgId = salesOrderMaster.getOrgId();
		int custId = salesOrderMaster.getCustomerId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpdb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery(
				"SELECT cu.cust_name, som.sales_order_mst_id, som.date, som.branch_id, som.created_date, som.customer_id, som.is_active, som.org_id, som.srno, som.total, som.updated_by,\r\n"
						+ "som.updated_date, som.user_id FROM  sales_order_master som \r\n"
						+ "inner join  customer cu on som.customer_id=cu.cust_id  " 
						+ "WHERE  case when " + custId +" >0 then som.customer_id = " + custId + " else som.customer_id >0 end "
						+ "AND som.org_id =" + orgId);
		ResultSetMetaData md = resultSet.getMetaData();
		int numCols = md.getColumnCount();
		List<String> colNames = IntStream.range(0, numCols).mapToObj(i -> {
			try {
				return md.getColumnName(i + 1);
			} catch (SQLException e) {
				e.printStackTrace();
				return "?";
			}
		}).collect(Collectors.toList());

		while (resultSet.next()) {
			JSONObject row = new JSONObject();
			colNames.forEach(cn -> {
				try {
					row.put(cn, resultSet.getObject(cn));
				} catch (JSONException | SQLException e) {
					e.printStackTrace();
				}
			});
			result.put(row);
		}
		return "" + result;
	}

	public SalesOrderMaster findSalesById(int InqId) {
		return salesOrderMasterRepo.findById(InqId).get();
	}

	public String deleteSalesByID(int InqId) {
		salesOrderMasterRepo.deleteById(InqId);
		return "deleted";
	}

}
