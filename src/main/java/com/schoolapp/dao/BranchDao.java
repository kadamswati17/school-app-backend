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
import com.schoolapp.entity.Branch;
import com.schoolapp.entity.User;
import com.schoolapp.repository.BranchRepo;

@Component
public class BranchDao {
	@Autowired
	BranchRepo branchRepo;

	public Branch saveBranch(Branch branch) throws ClassNotFoundException, SQLException {
		System.out.println("Data inserted successfully...");
		return branchRepo.save(branch);
	}

	public Branch updateDeleteBranch(Branch branch) throws ClassNotFoundException, SQLException {

		Integer branchId = branch.getBranchId();

		int userId = branch.getUserId();
		int updatedBy = branch.getUpdatedBy();
		Date updatedDate = (Date) branch.getUpdatedDate();
		int branchDbId = branch.getBranchId();
		int orgId = branch.getOrgId();
		int isActive = branch.getIsActive();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
		String query = "update branch set is_active=?, updated_by=?,updated_date=? " + "where branch_id=? and org_id=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, isActive);
		ps.setInt(2, updatedBy);
		ps.setDate(3, updatedDate);
		ps.setInt(4, branchId);
		ps.setInt(5, orgId);
		ps.executeUpdate();
		System.out.println("Record updated");
		return branchRepo.save(branch);
	}

	public List<Branch> getAllBranch() {
		return branchRepo.findAll();
	}

	public Branch findBranchById(int branchId) {
		return branchRepo.findById(branchId).get();
	}

	public String deleteBranchById(int branchId) {
		branchRepo.deleteById(branchId);
		return "deleted";
	}

}
