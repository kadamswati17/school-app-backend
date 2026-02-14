package com.schoolapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.engine.jdbc.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.schoolapp.entity.AccessPermission;
import com.schoolapp.entity.Contractor;
import com.schoolapp.entity.InqueryMaster;
import com.schoolapp.entity.LeadAccounts;
import com.schoolapp.entity.User;
import com.schoolapp.repository.LeadAccountsRepo;

@Component
public class LeadAccountsDao {

	@Autowired
	LeadAccountsRepo leadAccountsRepo;

	public LeadAccounts saveLeadAccounts(LeadAccounts leadAccounts) throws ClassNotFoundException, SQLException {
		System.out.println("Data inserted successfully...");
		return leadAccountsRepo.save(leadAccounts);
	}

	public String getAllLeadAccounts() throws Exception {
		List<Object> dataList = new ArrayList<>();

		Class.forName("com.mysql.jdbc.Driver");
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
				Statement st = con.createStatement();
//				SELECT JSON_ARRAYAGG(JSON_OBJECT('city_id', city_id, 'city_name', city_name)) from City;
				ResultSet rs = st.executeQuery("SELECT  "
						+ "l.lead_id, l.area, l.assign_id, l.branch_id, l.budget, l.budget1, l.budget2, l.c_name, l.city_id, l.created_date, l.date, l.dist_id, l.email, l.fax,"
						+ "l.gst_no, l.income, l.income_source, l.invoice_address, l.is_active, l.notes, l.org_id, l.other_income, l.other_income_source, l.owner_contact,"
						+ "l.owner_name, l.pan_no, l.phone, l.resource_id, l.state_id, l.status_id, l.updated_by, l.updated_date, l.user_id, l.website,"
						+ "b.branch_name AS branch_name," + "u.user_name AS user_name," + "s.state_name AS state_name,"
						+ "d.dist_name AS dist_name," + "c.city_name AS city_name," + "r.resource_name AS source,"
						+ "ro.resource_name AS other_incomes," + "ri.resource_name AS rs_income "
						+ "FROM lead_accounts l " + "INNER JOIN organization o ON l.org_id = o.org_id "
						+ "INNER JOIN branch b ON l.branch_id = b.branch_id "
						+ "INNER JOIN user u ON l.user_id = u.u_id " + "INNER JOIN state s ON l.state_id = s.state_id "
						+ "INNER JOIN district d ON l.dist_id = d.dist_id "
						+ "INNER JOIN city c ON l.city_id = c.city_id "
						+ "INNER JOIN resource r ON l.resource_id = r.resource_id "
						+ "INNER JOIN resource ro ON l.other_income_source = ro.resource_id "
						+ "INNER JOIN resource ri ON l.income_source = ri.resource_id")) {

			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();

			while (rs.next()) {
				for (int i = 1; i <= columnCount; i++) {

//					String fieldName = metaData.getColumnLabel(i);
					String[] words = metaData.getColumnLabel(i).split("[ _]");
					StringBuilder camelCaseFieldName = new StringBuilder(words[0]);
					for (int j = 1; j < words.length; j++) {
						camelCaseFieldName.append(words[j].substring(0, 1).toUpperCase()).append(words[j].substring(1));
					}
					String fieldName = camelCaseFieldName.toString();

					Object value = rs.getObject(i);
//					dataList.add(fieldName + ": " + value);
					if (value instanceof String || value instanceof Date) {
						dataList.add("\"" + fieldName + "\"" + ": \"" + value + "\"");

					} else {
						dataList.add("\"" + fieldName + "\" " + ": " + value);
					}
				}
			}
		}
		int count = 0;
		StringBuilder jsonBuilder = new StringBuilder("[{\n");
		for (int i = 0; i < dataList.size(); i++) {
			jsonBuilder.append("\t").append(dataList.get(i));

			count++;
			if (i < dataList.size() - 1) {

				if (count != 42) {

					jsonBuilder.append(",\n");
				}
			}
			if (count == 42) {
				jsonBuilder.append("\n},");
				count++;
				if (count >= 43) {
					jsonBuilder.append("\n{");
				}
				count = 0;
			}

		}
		jsonBuilder.append("\n}]");
		int cnt = jsonBuilder.length() - 1;
		jsonBuilder.delete(cnt - 5, cnt);
		return jsonBuilder.toString();
	}

	public LeadAccounts updateDeleteLeadAccounts(LeadAccounts leadAccounts)
			throws ClassNotFoundException, SQLException {
		Integer leadAccountsId = leadAccounts.getLeadId();
//		Contractor accounts = contractorDao.findContractorById(contractor.getContractorId());

		int userId = leadAccounts.getUserId();
		int updatedBy = leadAccounts.getUpdatedBy();
		Date updatedDate = leadAccounts.getUpdatedDate();
		int branchId = leadAccounts.getBranchId();
		int orgId = leadAccounts.getOrgId();
		int isActive = leadAccounts.getIsActive();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
		String query = "update lead_accounts set is_active=?, updated_by=?,updated_date=? "
				+ "where lead_id=? and org_id=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, isActive);
		ps.setInt(2, updatedBy);
		ps.setDate(3, (java.sql.Date) updatedDate);
		ps.setInt(4, leadAccountsId);
		ps.setInt(5, orgId);
		ps.executeUpdate();
		System.out.println("Record updated");
		return leadAccountsRepo.save(leadAccounts);
	}

	public LeadAccounts findLeadAccountsById(int leadAccountId) {
		return leadAccountsRepo.findById(leadAccountId).get();
	}

	public String deleteLeadAccountById(int leadAccountId) {
		leadAccountsRepo.deleteById(leadAccountId);
		return "deleted";
	}
}
