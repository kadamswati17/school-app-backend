package com.schoolapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.schoolapp.entity.AccessPermission;
import com.schoolapp.entity.LeadAccounts;
import com.schoolapp.entity.User;
import com.schoolapp.entity.WorkCompletion;
import com.schoolapp.entity.WorkOrder;
import com.schoolapp.entity.WorkOrderMaster;
import com.schoolapp.repository.WorkOrderMasterRepo;

@Component
public class WorkOrderMasterDao {
	@Autowired
	WorkOrderMasterRepo workOrderMasterRepo;

	public WorkOrderMaster saveWorkOrderMaster(WorkOrderMaster workOrderMaster)
			throws ClassNotFoundException, SQLException {
		System.out.println("Data inserted successfully...");
		return workOrderMasterRepo.save(workOrderMaster);
	}

	public String getAllWorkOrderMaster() throws Exception {
		List<Object> dataList = new ArrayList<>();

		Class.forName("com.mysql.jdbc.Driver");
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
				Statement st = con.createStatement();
//				SELECT JSON_ARRAYAGG(JSON_OBJECT('city_id', city_id, 'city_name', city_name)) from City;
				ResultSet rs = st.executeQuery(
						"SELECT wm.work_order_master_id,wm.branch_id,wm.contractor_id,wm.created_date,wm.is_active,wm.order_date,wm.\r\n"
								+ "org_id,wm.product_id,wm.sr_no,wm.updated_by,wm.updated_date,wm.user_id\r\n"
								+ " ,b.branch_name,c.contractor_name,p.name as\"product_name\",u.user_name\r\n"
								+ "FROM crmdb.work_order_master wm\r\n"
								+ "inner join contractor c on wm.contractor_id=c.contractor_id and wm.org_id=c.org_id\r\n"
								+ "inner join branch b on wm.branch_id=b.branch_id \r\n"
								+ "inner join product p on wm.product_id=p.product_id\r\n"
								+ "inner join user u on wm.user_id=u.u_id;\r\n" + "")) {

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

				if (count != 16) {

					jsonBuilder.append(",\n");
				}
			}
			if (count == 16) {
				jsonBuilder.append("\n},");
				count++;
				if (count >= 17) {
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

	public String updateWorkOrderMaster(WorkOrderMaster workOrderMaster) throws SQLException, ClassNotFoundException {
		Integer workOrderMasterId = workOrderMaster.getWorkOrderMasterId();

		int branchId = workOrderMaster.getBranchId();
		int contractorId = workOrderMaster.getContractorId();
		Date createdDate = workOrderMaster.getCreatedDate();
		int isActive = workOrderMaster.getIsActive();
		Date orderDate = workOrderMaster.getOrderDate();
		int orgId = workOrderMaster.getOrgId();
		int productId = workOrderMaster.getProductId();
		int srNo = workOrderMaster.getSrNo();
		int updatedBy = workOrderMaster.getUserId();
		Date updatedDate = workOrderMaster.getUpdatedDate();
		int userId = workOrderMaster.getUserId();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
		String query = "update work_order_master set branch_id = ?, contractor_id = ?, created_date = ?, \r\n"
				+ "is_active = ?, order_date = ?, product_id = ?, sr_no = ?, updated_by = ?, updated_date = ?, user_id=? "
				+ "where work_order_master_id = ? and org_id = ?";

		PreparedStatement ps = con.prepareStatement(query);

		ps.setInt(1, branchId);
		ps.setInt(2, contractorId);
		ps.setDate(3, createdDate);
		ps.setInt(4, isActive);
		ps.setDate(5, orderDate);
		ps.setInt(6, productId);
		ps.setInt(7, srNo);
		ps.setInt(8, updatedBy);
		ps.setDate(9, updatedDate);
		ps.setInt(10, userId);
		ps.setInt(11, workOrderMasterId);
		ps.setInt(12, orgId);

		ps.executeUpdate();

		System.out.println("Record updated successfully..!");
		return "Record updated..!";

	}

	public WorkOrderMaster updateDeleteWorkOrderMaster(WorkOrderMaster workOrderMaster)
			throws ClassNotFoundException, SQLException {
		Integer workOrderMasterId = workOrderMaster.getWorkOrderMasterId();
//		Contractor accounts = contractorDao.findContractorById(contractor.getContractorId());

		int userId = workOrderMaster.getUserId();
		int updatedBy = workOrderMaster.getUpdatedBy();
		Date updatedDate = workOrderMaster.getUpdatedDate();
		int branchId = workOrderMaster.getBranchId();
		int orgId = workOrderMaster.getOrgId();
		int isActive = workOrderMaster.getIsActive();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
		String query = "update work_order_master set is_active=?, updated_by=?,updated_date=? "
				+ "where work_order_master_id=? and org_id=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, isActive);
		ps.setInt(2, updatedBy);
		ps.setDate(3, (java.sql.Date) updatedDate);
		ps.setInt(4, workOrderMasterId);
		ps.setInt(5, orgId);
		ps.executeUpdate();
		System.out.println("Record updated");
		return workOrderMasterRepo.save(workOrderMaster);
	}

	public WorkOrderMaster findWorkOrderMasterById(int WorkOrderMasterId) {
		return (WorkOrderMaster) workOrderMasterRepo.findById(WorkOrderMasterId).get();
	}

	public String deleteWorkOrderMasterById(int WorkOrderMasterId) {
		workOrderMasterRepo.deleteById(WorkOrderMasterId);
		return "deleted";
	}
}
