package com.schoolapp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.schoolapp.entity.AccessPermission;
import com.schoolapp.entity.Contractor;
import com.schoolapp.entity.User;
import com.schoolapp.repository.ContractorRepo;

@Component
public class ContractorDao {
	@Autowired
	ContractorRepo contractorRepo;
	ContractorDao contractorDao;

	public Contractor saveContractor(Contractor contractor) throws ClassNotFoundException, SQLException {
		System.out.println("Data inserted successfully...");
		return contractorRepo.save(contractor);
	}

	public List<Contractor> getAllContractor() {
		return contractorRepo.findAll();
	}

	public Contractor findContractorById(int ContractorId) {
		
		return contractorRepo.findById(ContractorId).get();
	}

	public String updateContractor(Contractor contractor) throws SQLException, ClassNotFoundException {
		Integer contractorId = contractor.getContractorId();
//		Contractor accounts = contractorDao.findContractorById(contractor.getContractorId());

		int userId = contractor.getUserId();
		Date date = contractor.getDate();
		String ownerName = contractor.getOwnerName();
		String contractorName = contractor.getContractorName();
		int ownerContact = contractor.getOwnerContact();
		String panNo = contractor.getPanNo();
		String gstNo = contractor.getGstNo();
		String email = contractor.getEmail();
		String website = contractor.getWebsite();
		int phone = contractor.getPhone();
		int fax = contractor.getFax();
		String invoiceAddress = contractor.getInvoiceAddress();
		int income = contractor.getIncome();
		String incomeSource = contractor.getIncomeSource();
		int otherIncome = contractor.getOtherIncome();
		String otherIncomeSource = contractor.getOtherIncomeSource();
		int budget1 = contractor.getBudget1();
		int budget2 = contractor.getBudget2();
		String notes = contractor.getNotes();
		int isActive = contractor.getIsActive();
		int stateId = contractor.getStateId();
		int distId = contractor.getDistId();
		int cityId = contractor.getCityId();
		int orgId = contractor.getOrgId();
		int branchId = contractor.getBranchId();
		int updatedBy = contractor.getUpdatedBy();
		Date updatedDate = contractor.getUpdatedDate();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
		String query = "update contractor set contractor_id=?, budget1=?, budget2=?,  contractor_name=?, created_date=?, date=?, "
				+ " email=?, fax=?, gst_no=?, income=?,   invoice_address=?, is_active=?, notes=?, other_income=?,"
				+ "   owner_contact=?, owner_name=?, pan_no=?, phone=?,  updated_by=?, updated_date=?, user_id=?,"
				+ " website=?, branch_id=? where contractor_id=? and org_id=?";
		PreparedStatement ps = con.prepareStatement(query);

		ps.setInt(1, contractorId);
		ps.setInt(2, budget1);
		ps.setInt(3, budget2);
		ps.setString(4, contractorName);
		ps.setDate(5, date);
		ps.setDate(6, date);
		ps.setString(7, email);
		ps.setInt(8, fax);
		ps.setString(9, gstNo);
		ps.setInt(10, income);
		ps.setString(11, invoiceAddress);
		ps.setInt(12, isActive);
		ps.setString(13, notes);
		ps.setInt(14, otherIncome);
		ps.setInt(15, ownerContact);
		ps.setString(16, ownerName);
		ps.setString(17, panNo);
		ps.setInt(18, phone);
		ps.setInt(19, updatedBy);
		ps.setDate(20, updatedDate);
		ps.setInt(21, userId);
		ps.setString(22, website);
		ps.setInt(23, branchId);
		ps.setInt(24, contractorId);
		ps.setInt(25, orgId);

//		ps.setInt(4, cityId);
//		ps.setInt(8, distId);
//		ps.setString(13, incomeSource);
//		ps.setString(18, otherIncomeSource);
//		ps.setInt(23, stateId);

		ps.executeUpdate();

		System.out.println("Record updated successfully..!");
		return "Record updated..!";

	}

	public Contractor updateDeleteContractor(Contractor contractor) throws ClassNotFoundException, SQLException {
		Integer contractorId = contractor.getContractorId();
//		Contractor accounts = contractorDao.findContractorById(contractor.getContractorId());

		int userId = contractor.getUserId();
		int updatedBy = contractor.getUpdatedBy();
		Date updatedDate = contractor.getUpdatedDate();
		int branchId = contractor.getBranchId();
		int orgId = contractor.getOrgId();
		int isActive = contractor.getIsActive();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
		String query = "update contractor set is_active=?, updated_by=?,updated_date=? "
				+ "where contractor_id=? and org_id=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, isActive);
		ps.setInt(2, updatedBy);
		ps.setDate(3, updatedDate);
		ps.setInt(4, contractorId);
		ps.setInt(5, orgId);
		ps.executeUpdate();
		System.out.println("Record updated");
		return contractorRepo.save(contractor);
	}

	public String deleteContractorById(int ContractorId) {
		contractorRepo.deleteById(ContractorId);
		return "deleted";
	}

}
