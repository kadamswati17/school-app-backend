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

import com.schoolapp.entity.PurchaseOrderMaster;

import com.schoolapp.repository.PurchaseOrderMasterRepo;



@Component
public class PurchaseOrderMasterDao {

	@Autowired
	PurchaseOrderMasterRepo PurchaseOrderMasterRepo;

	public PurchaseOrderMaster savePurchaseOrderMaster(PurchaseOrderMaster PurchaseOrderMaster)
			throws ClassNotFoundException, SQLException {
		System.out.println("Data inserted successfully...");
		System.out.println(PurchaseOrderMaster);
		return PurchaseOrderMasterRepo.save(PurchaseOrderMaster);
	}

	public PurchaseOrderMaster updateDeletePurchaseOrderMaster(PurchaseOrderMaster PurchaseOrderMaster)
			throws ClassNotFoundException, SQLException {
		Integer PurchaseOrderMasterId = PurchaseOrderMaster.getPurchaseOrderMstId();
//		Contractor accounts = contractorDao.findContractorById(contractor.getContractorId());

		int userId = PurchaseOrderMaster.getUserId();
		int updatedBy = PurchaseOrderMaster.getUpdatedBy();
		Date updatedDate = PurchaseOrderMaster.getUpdatedDate();
		int branchId = PurchaseOrderMaster.getBranchId();
		int orgId = PurchaseOrderMaster.getOrgId();
		int isActive = PurchaseOrderMaster.getIsActive();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpdb", "root", "root");
		String query = "update Purchase_master set is_active=?, updated_by=?,updated_date=? "
				+ "where Purchase_id=? and org_id=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, isActive);
		ps.setInt(2, updatedBy);
		ps.setDate(3, updatedDate);
		ps.setInt(4, PurchaseOrderMasterId);
		ps.setInt(5, orgId);
		ps.executeUpdate();
		System.out.println("Record updated");
		return PurchaseOrderMasterRepo.save(PurchaseOrderMaster);
	}

	public String getAllPurchase(PurchaseOrderMaster PurchaseOrderMaster) throws SQLException, ClassNotFoundException {
		JSONArray result = new JSONArray();
		int orgId = PurchaseOrderMaster.getOrgId();
		int custId = PurchaseOrderMaster.getCustomerId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpdb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery(
				"SELECT cu.cust_name, pom.purchase_id, pom.date, pom.branch_id, pom.created_date,pom.customer_id, pom.is_active,\r\n"
				+ "pom.org_id, pom.srno, pom.total, pom.updated_by, pom.updated_date, pom.user_id \r\n"
				+ "FROM Purchase_order_master pom \r\n"
				+ "INNER JOIN customer cu ON pom.customer_id = cu.cust_id  \r\n"
				+ "WHERE  case when " + custId +" >0 then pom.customer_id = " + custId + " else pom.customer_id >0 end AND pom.org_id =" + orgId);
		
		System.out.println( resultSet);

//		"SELECT cu.cust_name, pom.purchase_id, pom.date, pom.branch_id, pom.created_date, pom.customer_id, pom.is_active, pom.org_id, pom.srno, pom.total, pom.updated_by,\r\n"
//				+ "pom.updated_date, pom.user_id FROM  Purchase_order_master pom \r\n"
//				+ "inner join  customer cu on pom.customer_id=cu.cust_id  where ( pom.customer_id=" + custId  
//				+ " or pom.customer_id > 0) and pom.org_id=" + orgId);
		
		
		
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

	public PurchaseOrderMaster findPurchaseById(int InqId) {
		return PurchaseOrderMasterRepo.findById(InqId).get();
	}

	public String deletePurchaseByID(int InqId) {
		PurchaseOrderMasterRepo.deleteById(InqId);
		return "deleted";
	}

}
