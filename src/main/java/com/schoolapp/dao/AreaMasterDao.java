package com.schoolapp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.schoolapp.entity.AccessPermission;
import com.schoolapp.entity.AreaMaster;
import com.schoolapp.entity.User;
import com.schoolapp.repository.AreaMasterRepo;

@Component
public class AreaMasterDao {
	@Autowired
	AreaMasterRepo areaMasterRepo;

	public AreaMaster saveAreaMaster(AreaMaster areaMaster) throws ClassNotFoundException, SQLException {
		System.out.println("Data inserted successfully...");
		return areaMasterRepo.save(areaMaster);
	}

	public List<AreaMaster> getAllAreaMaster() throws Exception {
		return areaMasterRepo.findAll();
	}

	public AreaMaster updateDeleteAreaMaster(AreaMaster areaMaster) throws ClassNotFoundException, SQLException {

		Integer areaMasterId = areaMaster.getAreaMasterId();
//		AreaMaster accounts = areaMasterDao.findAreaMasterById(areaMaster.getAreaMasterId());

		int userId = areaMaster.getUserId();
		int updatedBy = areaMaster.getUpdatedBy();
		Date updatedDate = (Date) areaMaster.getUpdatedDate();
		int branchId = areaMaster.getBranchId();
		int orgId = areaMaster.getOrgId();
		int isActive = areaMaster.getIsActive();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
		String query = "update area_master set is_active=?, updated_by=?,updated_date=? "
				+ "where area_master_id=? and org_id=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, isActive);
		ps.setInt(2, updatedBy);
		ps.setDate(3, updatedDate);
		ps.setInt(4, areaMasterId);
		ps.setInt(5, orgId);
		ps.executeUpdate();
		System.out.println("Record updated");
		return areaMasterRepo.save(areaMaster);
	}

	public AreaMaster findAreaMasterById(int AreaMasterId) {
		return (AreaMaster) areaMasterRepo.findById(AreaMasterId).get();
	}

	public String deleteAreaMasterById(int AreaMasterId) {
		areaMasterRepo.deleteById(AreaMasterId);
		return "deleted";
	}
}
