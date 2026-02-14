package com.schoolapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolapp.entity.AccessPermission;
import com.schoolapp.entity.LeadAccounts;
import com.schoolapp.entity.Product;
import com.schoolapp.entity.Project;
import com.schoolapp.entity.User;
import com.schoolapp.repository.ProjectRepo;

@Service
public class ProjectDao {
	@Autowired

	ProjectRepo projectRepo;

	public Project saveProject(Project project) throws ClassNotFoundException, SQLException {
		System.out.println("Data inserted successfully...");
		return projectRepo.save(project);

	}

	public String updateProject(Project project) throws SQLException, ClassNotFoundException {
		Integer projectId = project.getProjectId();

		int srNo = project.getSrNo();
		String projectName = project.getProjectName();
//		Date sanctionDate = project.getSanctionDate();
//		Date startDate = project.getStartDate();
//		Date endDate = project.getEndDate();
		String srvGutNo = project.getSrvGutNo();
		String previousLandOwner = project.getPreviousLandOwner();
		String landOwner = project.getLandOwner();
		String builderName = project.getBuilderName();
		int reraNo = project.getReraNo();
		int budgetAmt = project.getBudgetAmt();
		int orgId = project.getOrgId();
		int branchId = project.getBranchId();
		int userId = project.getUserId();
//		Date createdDate = project.getCreatedDate();
		int updatedBy = project.getUserId();
//		Date updatedDate = project.getUpdatedDate();
		int isActive = project.getIsActive();
		String address = project.getAddress();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
		String query = "update project set project_id = ? , address = ? , branch_id = ? , budget_amt = ? , builder_name = ? , created_date = ? ,"
				+ " end_date = ? , is_active = ? , land_owner = ?  , previous_land_owner = ? , project_name = ? , rera_no = ? ,"
				+ " sanction_date = ? , sr_no = ? , srv_gut_no = ? , start_date = ? , updated_by = ? , updated_date = ? , user_id = ?"
				+ " where project_id= ? and org_id = ?";

		PreparedStatement ps = con.prepareStatement(query);

		ps.setInt(1, projectId);
		ps.setString(2, address);
		ps.setInt(3, branchId);
		ps.setInt(4, budgetAmt);
		ps.setString(5, builderName);
//		ps.setDate(6, createdDate);
//		ps.setDate(7, endDate);
		ps.setInt(8, isActive);
		ps.setString(9, landOwner);
		ps.setString(10, previousLandOwner);
		ps.setString(11, projectName);
		ps.setInt(12, reraNo);
//		ps.setDate(13, sanctionDate);
		ps.setInt(14, srNo);
		ps.setString(15, srvGutNo);
//		ps.setDate(16, startDate);
		ps.setInt(17, updatedBy);
//		ps.setDate(18, updatedDate);
		ps.setInt(19, userId);
		ps.setInt(20, projectId);
		ps.setInt(21, orgId);

		ps.executeUpdate();

		System.out.println("Record updated successfully..!");
		return "Record updated..!";

	}

	public Project updateDeleteProject(Project project) throws ClassNotFoundException, SQLException {
		Integer projectId = project.getProjectId();
//		Contractor accounts = contractorDao.findContractorById(contractor.getContractorId());

		int userId = project.getUserId();
		int updatedBy = project.getUpdatedBy();
//		Date updatedDate = project.getUpdatedDate();
		int branchId = project.getBranchId();
		int orgId = project.getOrgId();
		int isActive = project.getIsActive();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
		String query = "update project set is_active=?, updated_by=?,updated_date=? "
				+ "where project_id=? and org_id=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, isActive);
		ps.setInt(2, updatedBy);
//		ps.setDate(3, (java.sql.Date) updatedDate);
		ps.setInt(4, projectId);
		ps.setInt(5, orgId);
		ps.executeUpdate();
		System.out.println("Record updated");
		return projectRepo.save(project);
	}

	public List<Project> getAllProject() {
		return projectRepo.findAll();
	}

	public Project findProjectById(int project) {
		return projectRepo.findById(project).get();
	}

	public String deleteUserById(int project) {
		projectRepo.deleteById(project);
		return "deleted";
	}
}
