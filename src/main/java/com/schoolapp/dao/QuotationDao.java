package com.schoolapp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.schoolapp.entity.Quotation;
import com.schoolapp.repository.QuotationRepo;
@Component
public class QuotationDao {

	@Autowired
	QuotationRepo quotationRepo;

	int existInqMst = 0;

	public List<Quotation> saveQuotation(List<Quotation> quotation) throws ClassNotFoundException, SQLException {

		for (Quotation al2 : quotation) {

			int srValide = al2.getQuotationMstId();

			if (srValide == 0) {

				Date quotationDate = al2.getQuotationDate();
				int customerId = al2.getCustomerId();
				int userId = al2.getUserId();
				int orgId = al2.getOrgId();
				int branchId = al2.getBranchId();
				Date createdDate = al2.getCreatedDate();
				int updatedBy = al2.getUpdatedBy();
				Date updatedDate = al2.getUpdatedDate();
				int isActive = al2.getIsActive();
				int srNo = 0;
				int total = 0;
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpdb", "root", "root");

				String sql = "INSERT INTO quotation_master( date, customer_id, branch_id, created_date, is_active, org_id,   updated_by, updated_date, user_id,srno,total) "
						+ "VALUES (?,?, ?, ?, ?, ?, ?, ?, ?,?,?)";

				PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

				pst.setDate(1, quotationDate);
				pst.setInt(2, customerId);
				pst.setInt(3, branchId);
				pst.setDate(4, createdDate);
				pst.setInt(5, isActive);
				pst.setInt(6, orgId);
				pst.setInt(7, updatedBy);
				pst.setDate(8, updatedDate);
				pst.setInt(9, userId);
				pst.setInt(10, srNo);
				pst.setInt(11, total);
				pst.executeUpdate();

				ResultSet rs = pst.getGeneratedKeys();
				int quotationId = -1;
				if (rs.next()) {
					quotationId = rs.getInt(1);
				}
				for (Quotation al3 : quotation) {
					al3.setQuotationMstId(quotationId);
					existInqMst = quotationId;
				}
			}

			System.out.println("Data inserted successfully...");
			return quotationRepo.saveAll(quotation);
		}
		return quotation;
	}

	public Quotation updateDeleteQuotation(Quotation quotation) throws ClassNotFoundException, SQLException {
		Integer quotationId = quotation.getQuotationId();
		int userId = quotation.getUserId();
		int updatedBy = quotation.getUpdatedBy();
		Date updatedDate = quotation.getUpdatedDate();
		int branchId = quotation.getBranchId();
		int orgId = quotation.getOrgId();
		int isActive = quotation.getIsActive();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpdb", "root", "root");
		String query = "update quotation_detailes set is_active=?, updated_by=?,updated_date=? "
				+ "where quotation_detailes_id=? and org_id=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, isActive);
		ps.setInt(2, updatedBy);
		ps.setDate(3, updatedDate);
		ps.setInt(4, quotationId);
		ps.setInt(5, orgId);
		ps.executeUpdate();
		System.out.println("Record updated");
		return quotationRepo.save(quotation);
	}

	public List<Quotation> getAllQuotation() throws Exception {

		return quotationRepo.findAll();
	}

	public Quotation findQuotationById(int QuotationId) {
		return (Quotation) quotationRepo.findById(QuotationId).get();
	}

	public String deleteQuotationById(int QuotationId) {
		quotationRepo.deleteById(QuotationId);
		return "deleted";
	}
}
