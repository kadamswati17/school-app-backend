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
import com.schoolapp.entity.Contractor;
import com.schoolapp.entity.InqueryDetailes;
import com.schoolapp.entity.InqueryMaster;
import com.schoolapp.entity.State;
import com.schoolapp.entity.User;
import com.schoolapp.repository.InqueryMasterRepo;

@Component
public class InqueryMasterDao {

	@Autowired
	InqueryMasterRepo inqueryMasterRepo;

	public InqueryMaster saveInqueryMaster(InqueryMaster inqueryMaster) throws ClassNotFoundException, SQLException {
		System.out.println("Data inserted successfully...");
		return inqueryMasterRepo.save(inqueryMaster);
	}

	public InqueryMaster updateDeleteInqueryMaster(InqueryMaster inqueryMaster)
			throws ClassNotFoundException, SQLException {
		Integer inqueryMasterId = inqueryMaster.getInqueryId();
//		Contractor accounts = contractorDao.findContractorById(contractor.getContractorId());

		int userId = inqueryMaster.getUserId();
		int updatedBy = inqueryMaster.getUpdatedBy();
		Date updatedDate = inqueryMaster.getUpdatedDate();
		int branchId = inqueryMaster.getBranchId();
		int orgId = inqueryMaster.getOrgId();
		int isActive = inqueryMaster.getIsActive();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
		String query = "update inquery_master set is_active=?, updated_by=?,updated_date=? "
				+ "where inquery_id=? and org_id=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, isActive);
		ps.setInt(2, updatedBy);
		ps.setDate(3, updatedDate);
		ps.setInt(4, inqueryMasterId);
		ps.setInt(5, orgId);
		ps.executeUpdate();
		System.out.println("Record updated");
		return inqueryMasterRepo.save(inqueryMaster);
	}

	public List<InqueryMaster> getAllInquery() {
		return inqueryMasterRepo.findAll();
	}

	public InqueryMaster findInqueryById(int InqId) {
		return inqueryMasterRepo.findById(InqId).get();
	}

	public String deleteInqueryByID(int InqId) {
		inqueryMasterRepo.deleteById(InqId);
		return "deleted";
	}

}
