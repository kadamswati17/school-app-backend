package com.schoolapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.schoolapp.entity.Organization;
import com.schoolapp.repository.OrganizationRepo;

@Component
public class OrganizationDao {

	@Autowired
	OrganizationRepo organizationRepo;

	public Organization saveOrganization(Organization organization) throws ClassNotFoundException, SQLException {

		Organization path = null;
		String emailId = organization.getEmail();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		String query = null;
		int user_id = 0;
		int generatedUserId = -1;
		int cnt = 0;

		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");
		query = "SELECT count(1) as cnt FROM  user  where email=?";
		ps = con.prepareStatement(query);
		ps.setString(1, emailId);
		rs = ps.executeQuery();
		if (rs.next()) {
			cnt = rs.getInt("cnt");
			if (cnt >= 0) {
				path = organizationRepo.save(organization);

				System.out.println("Save orgnisation records...");

				int orgId = path.getOrgId();

				int city_id = organization.getCityId();
				Date created_date = organization.getCreatedDate();
				Date date = organization.getDate();
				int dist_id = organization.getDistId();
				String gst_no = organization.getGstNo();
				int income = organization.getIncome();
				String income_source = organization.getIncomeSource();
				String notes = organization.getNotes();
				int other_income = organization.getOtherIncome();
				String other_income_source = organization.getOtherIncomeSource();
				String pan_no = organization.getPanNo();
				String phone = organization.getPhone();
				int state_id = organization.getStateId();
				String u_address = organization.getInvoiceAddress();
				int updated_by = organization.getUpdatedBy();
				Date updated_date = organization.getUpdatedDate();
				String user_contact = organization.getPhone();
				String user_name = organization.getOrgName();

				int branch_id = organization.getOrgId();
				user_id = organization.getOrgId();

				String sql1 = "INSERT INTO user(city_id, created_date, date, dist_id, email, gst_no, income, income_source, "
						+ "is_active, notes, org_id,other_income,other_income_source, pan_no, password, phone, state_id, u_address, "
						+ "updated_by, updated_date, user_contact, user_id, user_name,user_sr_no,branch_id) "
						+ "values (?, ?, ?, ?,?,?, ?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?,?)";

				PreparedStatement ps1 = con.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);

				ps1.setInt(1, city_id);
				ps1.setDate(2, created_date);
				ps1.setDate(3, date);
				ps1.setInt(4, dist_id);
				ps1.setString(5, emailId);
				ps1.setString(6, gst_no);
				ps1.setInt(7, income);
				ps1.setString(8, income_source);
				ps1.setInt(9, 1);
				ps1.setString(10, notes);
				ps1.setInt(11, orgId);
				ps1.setInt(12, other_income);
				ps1.setString(13, other_income_source);
				ps1.setString(14, pan_no);
				ps1.setString(15, "111");
				ps1.setString(16, phone);
				ps1.setInt(17, state_id);
				ps1.setString(18, u_address);
				ps1.setInt(19, updated_by);
				ps1.setDate(20, updated_date);
				ps1.setString(21, user_contact);
				ps1.setInt(22, user_id);
				ps1.setString(23, user_name);
				ps1.setInt(24, 0);
				ps1.setInt(25, branch_id);

				ps1.execute();

				rs1 = ps1.getGeneratedKeys();

				if (rs1.next()) {
					generatedUserId = rs1.getInt(1);
				}
				String sql3 = "UPDATE user SET user_id = ? WHERE org_id = ?";
				PreparedStatement ps3 = con.prepareStatement(sql3);
				ps3.setInt(1, generatedUserId);
				ps3.setInt(2, orgId);
				ps3.executeUpdate();
				ps3.close();

				String sql2 = "INSERT INTO access_permission(access_create, access_delete, access_read, access_update, access_user_id, branch_id, \r\n"
						+ "							created_date, is_active, model_id, org_id, updated_by, updated_date, user_id) \r\n"
						+ "						values (?, ?, ?, ?,?,?, ?, ?, ?, ?,?,?,?)";

				PreparedStatement ps2 = con.prepareStatement(sql2);

				ps2.setInt(1, 1);
				ps2.setInt(2, 1);
				ps2.setInt(3, 1);
				ps2.setInt(4, 1);
				ps2.setInt(5, generatedUserId);
				ps2.setInt(6, branch_id);
				ps2.setDate(7, created_date);
				ps2.setInt(8, 1);
				ps2.setInt(9, 1);
				ps2.setInt(10, orgId);
				ps2.setInt(11, updated_by);
				ps2.setDate(12, updated_date);
				ps2.setInt(13, generatedUserId);

				ps2.execute();
				ps2.close();

				System.out.println("DOneeee");
			} else {
				System.out.println("already present");
			}

		}
		return path;
	}

	public Organization updateDeleteOrganization(Organization organization)
			throws ClassNotFoundException, SQLException {
		Integer orgId = organization.getOrgId();
		int userId = organization.getUserId();
		int updatedBy = organization.getUpdatedBy();
		Date updatedDate = organization.getUpdatedDate();
		int isActive = organization.getIsActive();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");
		String query = "update organization set is_active=?, updated_by=?,updated_date=? " + "where org_id=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, isActive);
		ps.setInt(2, updatedBy);
		ps.setDate(3, (java.sql.Date) updatedDate);
		ps.setInt(4, orgId);
		ps.executeUpdate();
		System.out.println("Record updated");
		return organizationRepo.save(organization);
	}

	public List<Organization> getAllOrganizations() {
		return organizationRepo.findAll();
	}

	public Organization findOrganizationById(int organizationId) {
		return organizationRepo.findById(organizationId).get();
	}

	public String deleteOrgnizationById(int OrgId) {
		organizationRepo.deleteById(OrgId);
		return "deleted";
	}

}
