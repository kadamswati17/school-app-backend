package com.schoolapp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.schoolapp.entity.AccessPermission;
import com.schoolapp.entity.Contractor;
import com.schoolapp.entity.Floor;
import com.schoolapp.entity.InqueryDetailes;
import com.schoolapp.entity.User;
import com.schoolapp.entity.WorkOrder;
import com.schoolapp.repository.InqueryDetailesRepo;
import com.schoolapp.repository.WorkOrderRepo;

@Component
public class InqueryDetailesDao {
	@Autowired
	InqueryDetailesRepo inqueryDetailesRepo;

	int existInqMst = 0;

	public InqueryDetailes saveInqueryDetailes(InqueryDetailes inqueryDetailes)
			throws ClassNotFoundException, SQLException {
		int srValide = inqueryDetailes.getInqueryMstNo();

		if (srValide > 0) {

			Date inqueryDate = inqueryDetailes.getInqueryDate();
			int leadAccountId = inqueryDetailes.getLeadAccountId();
			int userId = inqueryDetailes.getUserId();
			int orgId = inqueryDetailes.getOrgId();
			int branchId = inqueryDetailes.getBranchId();
			Date createdDate = inqueryDetailes.getCreatedDate();
			int updatedBy = inqueryDetailes.getUpdatedBy();
			Date updatedDate = inqueryDetailes.getUpdatedDate();
			int isActive = inqueryDetailes.getIsActive();
			int srNo = 0;
			int total = 0;
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpdb", "root", "root");

			// Prepare the SQL statement with placeholders
			String sql = "INSERT INTO inquery_master( date, lead_account, branch_id, created_date, is_active, org_id,   updated_by, updated_date, user_id,srno,total) "
					+ "VALUES (?,?, ?, ?, ?, ?, ?, ?, ?,?,?)";

			System.out.println(sql  +" ============");
			// Create a PreparedStatement with RETURN_GENERATED_KEYS option
			PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			pst.setDate(1, inqueryDate);
			pst.setInt(2, leadAccountId);
			pst.setInt(3, branchId);
			pst.setDate(4, createdDate);
			pst.setInt(5, isActive);
			pst.setInt(6, orgId);
			pst.setInt(7, updatedBy);
			pst.setDate(8, updatedDate);
			pst.setInt(9, userId);
			pst.setInt(10, srNo);
			pst.setInt(11, total);
			// Execute the insert statement
			pst.executeUpdate();
			
			System.out.println("done msttt");

			// Retrieve the generated keys (inqueryDetailesId)
			ResultSet rs = pst.getGeneratedKeys();
			int inqueryDetailesId = -1; // Default value
			if (rs.next()) {
				inqueryDetailesId = rs.getInt(1);
			}

			// Close ResultSet, PreparedStatement, and Connection
			rs.close();
			pst.close();
			con.close();
			System.out.println("Inserted inqueryDetailesId: " + inqueryDetailesId);
			inqueryDetailes.setInqueryMstNo(inqueryDetailesId);

			existInqMst = inqueryDetailesId;
		}
		System.out.println("Data inserted successfully...");
		return inqueryDetailesRepo.save(inqueryDetailes);
	}

	public InqueryDetailes updateDeleteInqueryDetailes(InqueryDetailes inqueryDetailes)
			throws ClassNotFoundException, SQLException {
		Integer inqueryDetailesId = inqueryDetailes.getInqueryDetailesId();
//		Contractor accounts = contractorDao.findContractorById(contractor.getContractorId());

		int userId = inqueryDetailes.getUserId();
		int updatedBy = inqueryDetailes.getUpdatedBy();
		Date updatedDate = inqueryDetailes.getUpdatedDate();
		int branchId = inqueryDetailes.getBranchId();
		int orgId = inqueryDetailes.getOrgId();
		int isActive = inqueryDetailes.getIsActive();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
		String query = "update inquery_detailes set is_active=?, updated_by=?,updated_date=? "
				+ "where inquery_detailes_id=? and org_id=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, isActive);
		ps.setInt(2, updatedBy);
		ps.setDate(3, updatedDate);
		ps.setInt(4, inqueryDetailesId);
		ps.setInt(5, orgId);
		ps.executeUpdate();
		System.out.println("Record updated");
		return inqueryDetailesRepo.save(inqueryDetailes);
	}

	public List<InqueryDetailes> getAllInqueryDetailes() throws Exception {

		return inqueryDetailesRepo.findAll();
	}

	public InqueryDetailes findInqueryDetailesById(int InqueryDetailesId) {
		return (InqueryDetailes) inqueryDetailesRepo.findById(InqueryDetailesId).get();
	}

	public String deleteInqueryDetailesById(int InqueryDetailesId) {
		inqueryDetailesRepo.deleteById(InqueryDetailesId);
		return "deleted";
	}
}
