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

import com.schoolapp.entity.QuotationMaster;
import com.schoolapp.repository.QuotationMasterRepo;


@Component
public class QuotationMasterDao {

	
	@Autowired
	QuotationMasterRepo quotationMasterRepo;

	public QuotationMaster saveQuotationMaster(QuotationMaster quotationMaster)
			throws ClassNotFoundException, SQLException {
		System.out.println("Data inserted successfully...");
		System.out.println(quotationMaster);
		return quotationMasterRepo.save(quotationMaster);
	}

	public QuotationMaster updateDeleteQuotationMaster(QuotationMaster quotationMaster)
			throws ClassNotFoundException, SQLException {
		Integer quotationMasterId = quotationMaster.getQuotationMstId();
//		Contractor accounts = contractorDao.findContractorById(contractor.getContractorId());

		int userId = quotationMaster.getUserId();
		int updatedBy = quotationMaster.getUpdatedBy();
		Date updatedDate = quotationMaster.getUpdatedDate();
		int branchId = quotationMaster.getBranchId();
		int orgId = quotationMaster.getOrgId();
		int isActive = quotationMaster.getIsActive();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpdb", "root", "root");
		String query = "update quotation_master set is_active=?, updated_by=?,updated_date=? "
				+ "where quotation_id=? and org_id=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, isActive);
		ps.setInt(2, updatedBy);
		ps.setDate(3, updatedDate);
		ps.setInt(4, quotationMasterId);
		ps.setInt(5, orgId);
		ps.executeUpdate();
		System.out.println("Record updated");
		return quotationMasterRepo.save(quotationMaster);
	}

	public String getAllQuotation(QuotationMaster quotationMaster) throws SQLException, ClassNotFoundException {
		JSONArray result = new JSONArray();
		int orgId = quotationMaster.getOrgId();
		int custId = quotationMaster.getCustomerId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpdb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery(
				"SELECT cu.cust_name, qm.quotation_mst_id, qm.date, qm.branch_id, qm.created_date, qm.customer_id, qm.is_active,\r\n"
						+ "qm.org_id, qm.srno, qm.total, qm.updated_by, qm.updated_date, qm.user_id FROM  quotation_master qm\r\n"
						+ "inner join  customer cu on qm.customer_id=cu.cust_id  "
						+ "WHERE  case when " + custId +" >0 then qm.customer_id = " + custId + " else qm.customer_id >0 end "
						+ "AND qm.org_id =" + orgId);
		

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

	public QuotationMaster findQuotationById(int InqId) {
		return quotationMasterRepo.findById(InqId).get();
	}

	public String deleteQuotationByID(int InqId) {
		quotationMasterRepo.deleteById(InqId);
		return "deleted";
	}

}

