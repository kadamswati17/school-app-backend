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
import com.schoolapp.entity.Project;
import com.schoolapp.entity.Site;
import com.schoolapp.entity.User;
import com.schoolapp.repository.SiteRepo;

@Component
public class SiteDao {
	@Autowired
	SiteRepo siteRepo;

	public Site saveSite(Site site) throws ClassNotFoundException, SQLException {
		System.out.println("Data inserted successfully...");
		return siteRepo.save(site);
	}

	public String updateSite(Site site) throws SQLException, ClassNotFoundException {
		Integer siteId = site.getSiteId();
		int srNo = site.getSrNo();
		String siteName = site.getSiteName();
		String siteAddress = site.getSiteAddress();
		int projectId = site.getProjectId();
		int orgId = site.getOrgId();
		int branchId = site.getBranchId();
		int userId = site.getUserId();
		Date createdDate = site.getCreatedDate();
		int updatedBy = site.getUpdatedBy();
		Date updatedDate = site.getUpdatedDate();
		int isActive = site.getIsActive();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
		String query = "update site set site_id = ?, branch_id = ?, created_date = ?, is_active = ? , project_id = ?, "
				+ "site_address = ?, site_name = ?, sr_no = ?, updated_by = ?, updated_date = ?, user_id = ?"
				+ " where site_id= ? and org_id = ?";

		PreparedStatement ps = con.prepareStatement(query);

		ps.setInt(1, siteId);
		ps.setInt(2, branchId);
		ps.setDate(3, createdDate);
		ps.setInt(4, isActive);
		ps.setInt(5, projectId);
		ps.setString(6, siteAddress);
		ps.setString(7, siteName);
		ps.setInt(8, srNo);
		ps.setInt(9, updatedBy);
		ps.setDate(10, updatedDate);
		ps.setInt(11, userId);
		ps.setInt(12, siteId);
		ps.setInt(13, orgId);

		ps.executeUpdate();

		System.out.println("Record updated successfully..!");
		return "Record updated..!";

	}

	public Site updateDeleteSite(Site site) throws ClassNotFoundException, SQLException {
		Integer siteId = site.getSiteId();
//		Contractor accounts = contractorDao.findContractorById(contractor.getContractorId());

		int userId = site.getUserId();
		int updatedBy = site.getUpdatedBy();
		Date updatedDate = site.getUpdatedDate();
		int branchId = site.getBranchId();
		int orgId = site.getOrgId();
		int isActive = site.getIsActive();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
		String query = "update site set is_active=?, updated_by=?,updated_date=? " + "where site_id=? and org_id=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, isActive);
		ps.setInt(2, updatedBy);
		ps.setDate(3, (java.sql.Date) updatedDate);
		ps.setInt(4, siteId);
		ps.setInt(5, orgId);
		ps.executeUpdate();
		System.out.println("Record updated");
		return siteRepo.save(site);
	}

	public List<Site> getAllSite() {
		return siteRepo.findAll();
	}

	public Site findSiteById(int siteId) {
		return siteRepo.findById(siteId).get();
	}

	public String deleteSiteById(int siteId) {
		siteRepo.deleteById(siteId);
		return "deleted";
	}
}
