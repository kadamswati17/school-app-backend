package com.schoolapp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.schoolapp.entity.AccessPermission;
import com.schoolapp.entity.Contractor;
import com.schoolapp.entity.Customer;

import com.schoolapp.entity.User;
import com.schoolapp.repository.CustomerRepo;

@Component
public class CustomerDao {

	@Autowired
	CustomerRepo customerRepo;

	public Customer saveCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		
		System.out.println("Data inserted successfully...");
		
		return customerRepo.save(customer);
	}
	
//	public String updateCustomer(Customer customer) throws SQLException, ClassNotFoundException {
//		Integer customerId = customer.getCustId();
//
//		int custId = customer.getCustId();
//		Date date = customer.getDate();
//		String custName = customer.getCustName();
//		String ownerName = customer.getOwnerName();
//		String ownerContact = customer.getOwnerContact();
//		String panNo = customer.getPanNo();
//		String gstNo = customer.getGstNo();
//		String email = customer.getEmail();
//		String website = customer.getWebsite();
//		String phone = customer.getPhone();
//		int fax = customer.getFax();
//		String invoiceAddress = customer.getInvoiceAddress();
//		int income = customer.getIncome();
//		String incomeSource = customer.getIncomeSource();
//		int otherIncome = customer.getOtherIncome();
//		String otherIncomeSource = customer.getOtherIncomeSource();
//		int budget1 = customer.getBudget1();
//		int budget2 = customer.getBudget2();
//		String notes = customer.getNotes();
//		int isActive = customer.getIsActive();
//		int stateId = customer.getStateId();
//		int orgId = customer.getOrgId();
//		int distId = customer.getDistId();
//		int cityId = customer.getCityId();
//		int userId = customer.getUserId();
//		Date createdDate = customer.getCreatedDate();
//		int updatedBy = customer.getUpdatedBy();
//		Date updatedDate = customer.getUpdatedDate();
//
//		Class.forName("com.mysql.jdbc.Driver");
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpdb", "root", "root");
//		String query = "update customer set"
//				+ "cust_id= ? , "
//				+ "date= ? , "
//				+ "cust_name= ? , "
//				+ "owner_name= ? , "
//				+ "owner_contact= ? , "
//				+ "pan_no= ? , "
//				+ "gst_no= ? ,"
//				+ "email= ? , "
//				+ "website= ? , "
//				+ "phone= ? , "
//				+ "fax= ? , "
//				+ "invoice_address= ? , "
//				+ "income= ? ,"
//				+ " income_source= ? ,"
//				+ " other_income= ? , "
//				+ "other_income_source= ? ,"
//				+ " budget1= ? , "
//				+ "budget2= ? ,"
//				+ " notes= ? , "
//				+ "createdDate= ?,"
//				+ "state_id=? ,"
//				+ " org_id= ? , "
//				+ "dist_id= ? , "
//				+ "city_id= ? , "
//				+ "user_id= ? , "
//				+ "updatedBy= ?, "
//				+ "updatedDate=?"
//				+ "is_active=? where ";
//
//		PreparedStatement ps = con.prepareStatement(query);
//
//		ps.setInt(1, custId);
//		ps.setDate(2, date);
//		ps.setString(3, custName);
//		ps.setString(4, ownerName);
//		ps.setString(5, ownerContact);
//		ps.setString(6, panNo);
//		ps.setString(7, gstNo);
//		ps.setString(8, email);
//		ps.setString(9, website);
//		ps.setString(10, phone);
//		ps.setInt(11, fax);
//		ps.setString(12, invoiceAddress);
//		ps.setInt(13, income);
//		ps.setString(14, incomeSource);
//		ps.setInt(15, otherIncome);
//		ps.setString(16, otherIncomeSource);
//		ps.setInt(17, budget1);
//		ps.setInt(18, budget2);
//		ps.setString(19, notes);
//		ps.setInt(20, isActive);
//		ps.setInt(21, stateId);
//		ps.setInt(22, orgId);
//		ps.setInt(23, distId);
//		ps.setInt(24, cityId);
//		ps.setInt(25, userId);
//		ps.setDate(26, createdDate);
//		ps.setInt(27, updatedBy);
//		ps.setDate(28, updatedDate);
//
//		ps.executeUpdate();
//
//		System.out.println("Record updated successfully..!");
//		return "Record updated..!";
//
//	}

	public Customer updateDeleteCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		System.out.print(customer+" updated");
		Integer customerId = customer.getCustId();
//		Contractor accounts = contractorDao.findContractorById(contractor.getContractorId());

		int userId = customer.getUserId();
		int updatedBy = customer.getUpdatedBy();
		Date updatedDate = customer.getUpdatedDate();
		int isActive = customer.getIsActive();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpdb", "root", "root");
		String query = "update customer set is_active=?, updated_by=?,updated_date=? " + "where cust_id=? ";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, isActive);
		ps.setInt(2, updatedBy);
		ps.setDate(3, updatedDate);
		ps.setInt(4, customerId);
		ps.executeUpdate();
//		System.out.println(userId+isActive+" updated");
		System.out.println("Record updated");
		return customerRepo.save(customer);
		
		

	}

	public String getAllCustomer(Customer customer) throws ClassNotFoundException, SQLException {

		JSONArray result = new JSONArray();
		int orgId = customer.getOrgId();
		System.out.println(orgId+"----");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpdb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery("SELECT * FROM  customer where org_id=" + orgId);

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

	public Customer findCustomerById(int CustomerId) {
		return customerRepo.findById(CustomerId).get();
	}

	public String deleteCustomerById(int CustomerId) {
		customerRepo.deleteById(CustomerId);
		return "deleted";
	}
}
