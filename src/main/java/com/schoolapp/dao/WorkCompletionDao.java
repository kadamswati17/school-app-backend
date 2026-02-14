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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.schoolapp.entity.AccessPermission;
import com.schoolapp.entity.LeadAccounts;
import com.schoolapp.entity.User;
import com.schoolapp.entity.Wing;
import com.schoolapp.entity.WorkCompletion;
import com.schoolapp.entity.WorkOrder;
import com.schoolapp.repository.WorkCompletionRepo;
import com.schoolapp.repository.WorkOrderRepo;

@Component
public class WorkCompletionDao {
	@Autowired
	WorkCompletionRepo workCompletionRepo;

	public WorkCompletion saveWorkCompletion(WorkCompletion workCompletion)
			throws ClassNotFoundException, SQLException {
		System.out.println("Data inserted successfully...");
		return workCompletionRepo.save(workCompletion);

	}

	public String getAllWorkCompletion() throws Exception {
		List<Object> dataList = new ArrayList<>();

		Class.forName("com.mysql.jdbc.Driver");
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
				Statement st = con.createStatement();
//				SELECT JSON_ARRAYAGG(JSON_OBJECT('city_id', city_id, 'city_name', city_name)) from City;
				ResultSet rs = st.executeQuery(
						"SELECT wc.contractor_id,wc.area_id,wc.work_master_id,wo.work_order_id,c.contractor_name,p.name,wo.area_sqr_ft,sum(wc.complete_sqr_ft) as \"total_complete_sq_ft\",\r\n"
								+ "wo.area_sqr_ft-sum(wc.complete_sqr_ft)  as \"pending_sq_ft\", am.area_master_name\r\n"
								+ "FROM crmdb.work_completion wc\r\n"
								+ "inner join work_order wo on wc.work_master_id=wo.sr_no and wc.product_id=wo.product_id  and wc.work_order_id=wo.work_order_id\r\n"
								+ "inner join product p on wo.product_id=p.product_id\r\n"
								+ "inner join area_master am on wc.area_id=am.area_master_id\r\n"
								+ "inner join contractor c on wo.contractor_id=c.contractor_id and wo.org_id=c.org_id\r\n"
								+ "group by wc.contractor_id,wc.area_id,wc.work_master_id,p.name,c.contractor_name,wo.work_order_id,wo.area_sqr_ft")) {

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

				if (count != 10) {

					jsonBuilder.append(",\n");
				}
			}
			if (count == 10) {
				jsonBuilder.append("\n},");
				count++;
				if (count >= 11) {
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

	public WorkCompletion updateDeleteWorkCompletion(WorkCompletion workCompletion)
			throws ClassNotFoundException, SQLException {
		Integer workCompletionId = workCompletion.getWorkCompletionId();
//		Contractor accounts = contractorDao.findContractorById(contractor.getContractorId());

		int userId = workCompletion.getUserId();
		int updatedBy = workCompletion.getUpdatedBy();
		Date updatedDate = workCompletion.getUpdatedDate();
		int branchId = workCompletion.getBranchId();
		int orgId = workCompletion.getOrgId();
		int isActive = workCompletion.getIsActive();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
		String query = "update work_completion set is_active=?, updated_by=?,updated_date=? "
				+ "where work_completion_id=? and org_id=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, isActive);
		ps.setInt(2, updatedBy);
		ps.setDate(3, (java.sql.Date) updatedDate);
		ps.setInt(4, workCompletionId);
		ps.setInt(5, orgId);
		ps.executeUpdate();
		System.out.println("Record updated");
		return workCompletionRepo.save(workCompletion);
	}

	public WorkCompletion findWorkCompletionById(int WorkCompletionId) {
		return (WorkCompletion) workCompletionRepo.findById(WorkCompletionId).get();
	}

	public String deleteWorkCompletionById(int WorkCompletionId) {
		workCompletionRepo.deleteById(WorkCompletionId);
		return "deleted";
	}
}
