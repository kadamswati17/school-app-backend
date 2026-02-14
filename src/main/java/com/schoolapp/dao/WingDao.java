package com.schoolapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.schoolapp.entity.AccessPermission;
import com.schoolapp.entity.LeadAccounts;
import com.schoolapp.entity.Site;
import com.schoolapp.entity.User;
import com.schoolapp.entity.Wing;
import com.schoolapp.repository.WingRepo;

@Component
public class WingDao {
	@Autowired
	WingRepo wingRepo;

	public Wing saveWing(Wing wing) throws ClassNotFoundException, SQLException {
		System.out.println("Data inserted successfully...");
		return wingRepo.save(wing);
	}

	public String updateWing(Wing wing) throws SQLException, ClassNotFoundException {
		Integer wingId = wing.getWingId();

		String wingName = wing.getWingName();
		int projectId = wing.getProjectId();
		int siteId = wing.getSiteId();
		int srNO = wing.getSrNO();
		int noOfFlower = wing.getNoOfFlower();
		int userId = wing.getUserId();
		int orgId = wing.getOrgId();
		int branchId = wing.getBranchId();
		Date createdDate = wing.getCreatedDate();
		int updatedBy = wing.getUserId();
		Date updatedDate = wing.getUpdatedDate();
		int isActive = wing.getIsActive();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
		String query = "update wing set wing_id = ? , branch_id = ? , created_date = ? , is_active = ? , no_of_flower = ? ,"
				+ "project_id = ? , srno = ? , updated_by = ? , updated_date = ? , user_id = ? , wing_name = ? , site_id = ?"
				+ " where wing_id= ? and org_id = ?";

		PreparedStatement ps = con.prepareStatement(query);

		ps.setInt(1, wingId);
		ps.setInt(2, branchId);
		ps.setDate(3, createdDate);
		ps.setInt(4, isActive);
		ps.setInt(5, noOfFlower);
		ps.setInt(6, projectId);
		ps.setInt(7, srNO);
		ps.setInt(8, updatedBy);
		ps.setDate(9, updatedDate);
		ps.setInt(10, userId);
		ps.setString(11, wingName);
		ps.setInt(12, siteId);
		ps.setInt(13, wingId);
		ps.setInt(14, orgId);
		ps.executeUpdate();

		System.out.println("Record updated successfully..!");
		return "Record updated..!";

	}

	public Wing updateDeleteWing(Wing wing) throws ClassNotFoundException, SQLException {
		Integer wingId = wing.getWingId();
//		Contractor accounts = contractorDao.findContractorById(contractor.getContractorId());

		int userId = wing.getUserId();
		int updatedBy = wing.getUpdatedBy();
		Date updatedDate = wing.getUpdatedDate();
		int branchId = wing.getBranchId();
		int orgId = wing.getOrgId();
		int isActive = wing.getIsActive();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
		String query = "update wing set is_active=?, updated_by=?,updated_date=? " + "where wing_id=? and org_id=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, isActive);
		ps.setInt(2, updatedBy);
		ps.setDate(3, (java.sql.Date) updatedDate);
		ps.setInt(4, wingId);
		ps.setInt(5, orgId);
		ps.executeUpdate();
		System.out.println("Record updated");
		return wingRepo.save(wing);
	}

	public List<Wing> getAllWing() {
		return wingRepo.findAll();
	}

	public Wing findWingById(int wing) {
		return wingRepo.findById(wing).get();
	}

	public String deleteWingById(int wing) {
		wingRepo.deleteById(wing);
		return "deleted";
	}

}
