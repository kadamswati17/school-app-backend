package com.schoolapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.sql.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.schoolapp.entity.Contractor;
import com.schoolapp.entity.Wing;
import com.schoolapp.entity.WorkCompletion;
import com.schoolapp.entity.WorkOrder;
import com.schoolapp.repository.WorkOrderRepo;

@Component
public class WorkOrderDao {
	@Autowired
	WorkOrderRepo workOrderRepo;

	public List<WorkOrder> saveWorkOrder(List<WorkOrder> workOrder) throws ClassNotFoundException, SQLException {

		int areaSqrFt = 0;
		int areaId = 0;
		int rate = 0;
		Date orderDate = null;
		int contractorId = 0;
		int productId = 0;
		int userId = 0;
		int orgId = 0;
		int branchId = 0;
		Date createdDate = null;
		int updatedBy = 0;
		Date updatedDate = null;
		int isActive = 0;
		int srNo = 0;
		int cnt = 0;
		int workOrderId = 0;
		for (WorkOrder al : workOrder) {

			areaId = al.getAreaId();
			areaSqrFt = al.getAreaSqrFt();
			branchId = al.getBranchId();
			contractorId = al.getContractorId();
			productId = al.getProductId();
			userId = al.getUserId();
			orgId = al.getOrgId();
			orderDate = al.getOrderDate();
			rate = al.getRate();
			createdDate = al.getCreatedDate();
			updatedBy = al.getUpdatedBy();
			updatedDate = al.getUpdatedDate();
			isActive = al.getIsActive();
			srNo = al.getSrNo();

			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");

			String sql = "INSERT INTO work_order_master(branch_id, contractor_id, created_date, is_active, order_date, org_id, product_id, updated_by, updated_date, user_id,sr_no) "
					+ "VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			if (cnt == 0) {
				cnt = 1;
				pst.setInt(1, branchId);
				pst.setInt(2, contractorId);
				pst.setDate(3, new java.sql.Date(createdDate.getTime()));
				pst.setInt(4, isActive);
				pst.setDate(5, new java.sql.Date(orderDate.getTime()));
				pst.setInt(6, orgId);
				pst.setInt(7, productId);
				pst.setInt(8, updatedBy);
				pst.setDate(9, new java.sql.Date(updatedDate.getTime()));
				pst.setInt(10, userId);
				pst.setInt(11, srNo);
				pst.executeUpdate();

				ResultSet rs = pst.getGeneratedKeys();
				if (rs.next()) {
					workOrderId = rs.getInt(1);
				}

				rs.close();
				pst.close();
				con.close();
			}
			al.setSrNo(workOrderId);
		}

		return (List<WorkOrder>) workOrderRepo.saveAll(workOrder);
	}

	public String getAllWorkOrder() throws Exception {
		List<Object> dataList = new ArrayList<>();

		Class.forName("com.mysql.jdbc.Driver");
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
				Statement st = con.createStatement();
//				SELECT JSON_ARRAYAGG(JSON_OBJECT('city_id', city_id, 'city_name', city_name)) from City;
				ResultSet rs = st.executeQuery(
						"SELECT wo.work_order_id,wo.area_id,wo.area_sqr_ft,wo.branch_id,wo.contractor_id,wo.created_date,wo.is_active,\r\n"
								+ "								wo.order_date,wo.org_id,wo.product_id,wo.rate,wo.sr_no,wo.updated_by,wo.updated_date,wo.user_id,\r\n"
								+ "								c.contractor_name,o.org_name,p.name,am.area_master_name,b.branch_name,u.user_name\r\n"
								+ "								 FROM work_order wo\r\n"
								+ "								 inner join work_order_master wm on wo.sr_no=wm.work_order_master_id\r\n"
								+ "								 inner join contractor c on wm.contractor_id=c.contractor_id\r\n"
								+ "								INNER JOIN organization o ON wo.org_id = o.org_id \r\n"
								+ "								 inner join product p on wo.product_id=p.product_id \r\n"
								+ "								 inner join area_master am on wo.area_id=am.area_master_id\r\n"
								+ "								 INNER JOIN branch b ON wo.branch_id = b.branch_id \r\n"
								+ "								INNER JOIN user u ON wo.user_id = u.u_id ")) {

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

				if (count != 21) {

					jsonBuilder.append(",\n");
				}
			}
			if (count == 21) {
				jsonBuilder.append("\n},");
				count++;
				if (count >= 22) {
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

//	----------------------------------------------------

	public String getAllWorkOrderByOrderId(int id) throws Exception {
		List<Object> dataList = new ArrayList<>();

		Class.forName("com.mysql.jdbc.Driver");
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
				Statement st = con.createStatement();
//				SELECT JSON_ARRAYAGG(JSON_OBJECT('city_id', city_id, 'city_name', city_name)) from City;
				ResultSet rs = st.executeQuery(
						"SELECT wo.work_order_id,wo.area_id,wo.area_sqr_ft,wo.branch_id,wo.contractor_id,wo.created_date,wo.is_active,\r\n"
								+ "								wo.order_date,wo.org_id,wo.product_id,wo.rate,wo.sr_no,wo.updated_by,wo.updated_date,wo.user_id,\r\n"
								+ "								c.contractor_name,o.org_name,p.name,am.area_master_name,b.branch_name,u.user_name\r\n"
								+ "								 FROM work_order wo\r\n"
								+ "								 inner join work_order_master wm on wo.sr_no=wm.work_order_master_id\r\n"
								+ "								 inner join contractor c on wm.contractor_id=c.contractor_id\r\n"
								+ "								INNER JOIN organization o ON wo.org_id = o.org_id \r\n"
								+ "								 inner join product p on wo.product_id=p.product_id \r\n"
								+ "								 inner join area_master am on wo.area_id=am.area_master_id\r\n"
								+ "								 INNER JOIN branch b ON wo.branch_id = b.branch_id \r\n"
								+ "								INNER JOIN user u ON wo.user_id = u.u_id where wo.sr_no="
								+ id)) {

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

				if (count != 21) {

					jsonBuilder.append(",\n");
				}
			}
			if (count == 21) {
				jsonBuilder.append("\n},");
				count++;
				if (count >= 22) {
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

	public String getWorkOrderContractor() throws ClassNotFoundException, SQLException {
		List<Object> dataList = new ArrayList<>();

		Class.forName("com.mysql.jdbc.Driver");
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
				Statement st = con.createStatement();
//				SELECT JSON_ARRAYAGG(JSON_OBJECT('city_id', city_id, 'city_name', city_name)) from City;
				ResultSet rs = st.executeQuery("SELECT   wo.contractor_id,c.contractor_name FROM contractor c\r\n"
						+ "						inner join  work_order_master wm  on wm.contractor_id=c.contractor_id\r\n"
						+ "						INNER JOIN work_order wo  ON wo.org_id = wm.org_id  and wm.contractor_id=wo.contractor_id\r\n"
						+ "						where wo.org_id=wm.org_id and wo.contractor_id=c.contractor_id\r\n"
						+ "                        group by  wo.contractor_id,c.contractor_name\r\n")) {

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

				if (count != 2) {

					jsonBuilder.append(",\n");
				}
			}
			if (count == 2) {
				jsonBuilder.append("\n},");
				count++;
				if (count >= 3) {
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

	public String getWorkOrderProduct(WorkOrder workOrder) throws ClassNotFoundException, SQLException {

		List<Object> dataList = new ArrayList<>();
		int contractorId = workOrder.getContractorId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
		String query = "SELECT   p.product_id,concat( p.name,\" woNo => \",wo.work_order_id,\" - \",am.area_master_name) as \"name\",\r\n"
				+ "				wo.area_id,wo.work_order_id,wo.sr_no   FROM product p  \r\n"
				+ "				 	 				inner join  work_order_master wm  on wm.product_id=p.product_id  \r\n"
				+ "				 		 				INNER JOIN work_order wo  ON wo.org_id = wm.org_id  and wm.product_id=wo.product_id  \r\n"
				+ "                                        inner join area_master am on wo.area_id=am.area_master_id\r\n"
				+ "			  				where wo.org_id=wm.org_id and wo.product_id=p.product_id and wm.contractor_id=?\r\n"
				+ "				 	                      group by  p.product_id,p.name,wo.work_order_id,am.area_master_name,wo.area_id,wo.sr_no\r\n"
				+ "                                          order by wo.sr_no  desc";

		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, contractorId);
		ResultSet rs = ps.executeQuery();
		ResultSetMetaData metaData = rs.getMetaData();
		int columnCount = metaData.getColumnCount();
		while (rs.next()) {
			for (int i = 1; i <= columnCount; i++) {

				String[] words = metaData.getColumnLabel(i).split("[ _]");
				StringBuilder camelCaseFieldName = new StringBuilder(words[0]);
				for (int j = 1; j < words.length; j++) {
					camelCaseFieldName.append(words[j].substring(0, 1).toUpperCase()).append(words[j].substring(1));
				}
				String fieldName = camelCaseFieldName.toString();

				Object value = rs.getObject(i);
				if (value instanceof String || value instanceof Date) {
					dataList.add("\"" + fieldName + "\"" + ": \"" + value + "\"");

				} else {
					dataList.add("\"" + fieldName + "\" " + ": " + value);
				}
			}
		}

		int count = 0;
		StringBuilder jsonBuilder = new StringBuilder("[{\n");
		for (int i = 0; i < dataList.size(); i++) {
			jsonBuilder.append("\t").append(dataList.get(i));

			count++;
			if (i < dataList.size() - 1) {

				if (count != 5) {

					jsonBuilder.append(",\n");
				}
			}
			if (count == 5) {
				jsonBuilder.append("\n},");
				count++;
				if (count >= 6) {
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

	public String getWorkOrderArea(WorkOrder workOrder) throws ClassNotFoundException, SQLException {

		List<Object> dataList = new ArrayList<>();
		int contractorId = workOrder.getContractorId();
		int productId = workOrder.getProductId();
		int workOrderId = workOrder.getWorkOrderId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
		String query = "SELECT wo.area_id,am.area_master_name,wo.sr_no,wo.work_order_id FROM area_master am  \r\n"
				+ "			 				INNER JOIN work_order wo  ON wo.org_id = am.org_id  and am.area_master_id=wo.area_id  \r\n"
				+ "				                        inner join product p on wo.product_id=p.product_id  \r\n"
				+ "				                         where p.product_id=? and wo.contractor_id=? and wo.work_order_id=?\r\n"
				+ "			                      group by am.area_master_id,am.area_master_name,wo.sr_no,wo.work_order_id";

		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, productId);
		ps.setInt(2, contractorId);
		ps.setInt(3, workOrderId);
		ResultSet rs = ps.executeQuery();
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

		int count = 0;
		StringBuilder jsonBuilder = new StringBuilder("[{\n");
		for (int i = 0; i < dataList.size(); i++) {
			jsonBuilder.append("\t").append(dataList.get(i));

			count++;
			if (i < dataList.size() - 1) {

				if (count != 4) {

					jsonBuilder.append(",\n");
				}
			}
			if (count == 4) {
				jsonBuilder.append("\n},");
				count++;
				if (count >= 5) {
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

	public String updateWorkOrder(WorkOrder workOrder) throws SQLException, ClassNotFoundException {
		Integer workOrderId = workOrder.getWorkOrderId();

		int areaId = workOrder.getAreaId();
		int areaSqrFt = workOrder.getAreaSqrFt();
		int branchId = workOrder.getBranchId();
		int contractorId = workOrder.getContractorId();
		Date createdDate = workOrder.getCreatedDate();
		int isActive = workOrder.getIsActive();
		Date orderDate = workOrder.getOrderDate();
		int orgId = workOrder.getOrgId();
		int productId = workOrder.getProductId();
		int rate = workOrder.getRate();
		int srNo = workOrder.getSrNo();
		int updatedBy = workOrder.getUserId();
		Date updatedDate = workOrder.getUpdatedDate();
		int userId = workOrder.getUserId();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
		String query = "update work_order set   area_sqr_ft = ? , rate = ? , created_date = ? , is_active = ? ,  updated_by = ?  "
				+ "where work_order_id= ? and org_id = ?";

		PreparedStatement ps = con.prepareStatement(query);

		ps.setInt(1, areaSqrFt);
		ps.setInt(2, rate);
		ps.setDate(3, createdDate);
		ps.setInt(4, isActive);
		ps.setInt(5, updatedBy);
		ps.setInt(6, workOrderId);
		ps.setInt(7, orgId);

//		ps.setInt(2, areaId);
//		ps.setInt(4, branchId);
//		ps.setInt(5, contractorId);
//		ps.setDate(8, orderDate);
//		ps.setInt(9, productId);
//		ps.setInt(11, srNo);
//		ps.setDate(13, updatedDate);
//		ps.setInt(15, workOrderId);

		ps.executeUpdate();

		System.out.println("Record updated successfully..!");
		return "Record updated..!";

	}

	public WorkOrder updateDeleteWorkOrder(WorkOrder workOrder) throws ClassNotFoundException, SQLException {
		Integer workOrderId = workOrder.getWorkOrderId();
//	Contractor accounts = contractorDao.findContractorById(contractor.getContractorId());

		int userId = workOrder.getUserId();
		int updatedBy = workOrder.getUpdatedBy();
		Date updatedDate = workOrder.getUpdatedDate();
		int branchId = workOrder.getBranchId();
		int orgId = workOrder.getOrgId();
		int isActive = workOrder.getIsActive();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
		String query = "update work_order set is_active=?, updated_by=?,updated_date=? "
				+ "where work_order_id=? and org_id=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, isActive);
		ps.setInt(2, updatedBy);
		ps.setDate(3, (java.sql.Date) updatedDate);
		ps.setInt(4, workOrderId);
		ps.setInt(5, orgId);
		ps.executeUpdate();
		System.out.println("Record updated");
		return workOrderRepo.save(workOrder);
	}

	public WorkOrder findWorkOrderById(int WorkOrderId) {
		return (WorkOrder) workOrderRepo.findById(WorkOrderId).get();
	}

	public String deleteWorkOrderById(int WorkOrderId) {
		workOrderRepo.deleteById(WorkOrderId);
		return "deleted";
	}
}
