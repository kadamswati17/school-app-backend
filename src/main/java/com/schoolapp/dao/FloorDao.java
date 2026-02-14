package com.schoolapp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.schoolapp.entity.AccessPermission;
import com.schoolapp.entity.Contractor;
import com.schoolapp.entity.Customer;
import com.schoolapp.entity.Floor;
import com.schoolapp.entity.User;
import com.schoolapp.entity.WorkOrder;
import com.schoolapp.repository.FloorRepo;

@Component
public class FloorDao {
	@Autowired
	FloorRepo floorRepo;

	public Floor saveFloor(Floor floor) throws ClassNotFoundException, SQLException {
		int cnt = 0;
		Floor path = null;
		int projectId = floor.getProjectId();
		int siteId = floor.getSiteId();
		int wingId = floor.getWingId();
		int orgId = floor.getOrgId();
		String floorName = floor.getFloorName();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = null;

		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
		query = "select count(1) from floor where project_id=? and site_id=? and wing_id=? and org_id=? and floor_name=?";
		ps = con.prepareStatement(query);

		ps.setInt(1, projectId);
		ps.setInt(2, siteId);
		ps.setInt(3, wingId);
		ps.setInt(4, orgId);
		ps.setString(5, floorName);

		rs = ps.executeQuery();

		if (rs.next()) {

			cnt = rs.getInt(1);
		}
		rs.close();
		ps.close();
		con.close();

		if (cnt == 0) {
			path = floorRepo.save(floor);

			// ------------ preapred for product ----------

			int uniqVal = path.getFloorId();

			con = null;
			ps = null;
			query = null;

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
			query = "insert into product (name, br_id, brand_id, category, categoryid, cgst, created_date, cust_id, d1, d2, hsncode, \r\n"
					+ "					 igst, is_active, itm_type, org_id,productdiscription, purchase_rate, quantity, rate, sgst,\r\n"
					+ "                     shrtnm, unit, updated_by, updated_date, user_id, wrates)\r\n"
					+ "SELECT concat(pj.project_name,\" - \",s.site_name,\" - \",w.wing_name,\" - \",f.floor_name) as \"product_name\",\r\n"
					+ "1 br_id,0 brand_id, 0 category,0 categoryid,0 cgst,'2024-02-23' created_date,1 cust_id,0 d1,0 d2,0 hsncode,0 igst,1 is_active,0 itm_type,1 org_id, \r\n"
					+ "'' productdiscription,0 purchase_rate,0 quantity,0 rate,0 sgst,0 shrtnm,0 unit,0 updated_by,'2024-02-23'  updated_date,1 user_id,0 wrates\r\n"
					+ "FROM  project pj \r\n"
					+ "inner join site s on pj.org_id=s.org_id and pj.project_id=s.site_id\r\n"
					+ "inner join wing w on s.org_id=w.org_id and s.site_id=w.site_id and s.project_id=w.project_id\r\n"
					+ "inner join floor f on w.org_id=f.org_id and f.project_id=w.project_id and w.wing_id=f.wing_id   \r\n"
					+ "where  pj.project_id=? and s.site_id=? and w.wing_id=? and f.org_id=? and f.floor_id=?";

			ps = con.prepareStatement(query);

			ps.setInt(1, projectId);
			ps.setInt(2, siteId);
			ps.setInt(3, wingId);
			ps.setInt(4, orgId);
			ps.setInt(5, uniqVal);

			ps.execute();

			ps.close();
			con.close();
			System.out.println("product save successfully..!");

		} else {
			System.out.println("floor already exist");
			path = null;
		}

		System.out.println("Data inserted successfully...");
		return path;
	}

	public String updateFloor(Floor floor) throws SQLException, ClassNotFoundException {
		Integer floorId = floor.getFloorId();

		String floorName = floor.getFloorName();
		int projectId = floor.getProjectId();
		int srNo = floor.getSrno();
		int wingId = floor.getWingId();
		int orgId = floor.getOrgId();
		int branchId = floor.getBranchId();
		Date createdDate = floor.getCreatedDate();
		int updatedBy = floor.getUserId();
		Date updatedDate = floor.getUpdatedDate();
		int isActive = floor.getIsActive();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
		String query = "update floor set " + "branch_id=?," + "created_date=?," + "floor_name=?," + "is_active=?,"
				+ "project_id=?," + "srno=?," + "updated_by=?," + "updated_date=?," + "wing_id=? "
				+ "where floor_id=? and org_id=?";

		PreparedStatement ps = con.prepareStatement(query);

		ps.setInt(1, branchId);
		ps.setDate(2, createdDate);
		ps.setString(3, floorName);
		ps.setInt(4, isActive);
		ps.setInt(5, projectId);
		ps.setInt(6, srNo);
		ps.setInt(7, updatedBy);
		ps.setDate(8, updatedDate);
		ps.setInt(9, wingId);
		ps.setInt(10, floorId);
		ps.setInt(11, orgId);
		ps.executeUpdate();

		System.out.println("Record updated successfully..!");
		return "Record updated..!";

	}

	public Floor updateDeleteFloor(Floor floor) throws ClassNotFoundException, SQLException {
		Integer floorId = floor.getFloorId();
		int userId = floor.getUserId();
		int updatedBy = floor.getUpdatedBy();
		Date updatedDate = floor.getUpdatedDate();
		int branchId = floor.getBranchId();
		int orgId = floor.getOrgId();
		int isActive = floor.getIsActive();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
		String query = "update floor set is_active=?, updated_by=?,updated_date=?  where floor_id=? and org_id=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, isActive);
		ps.setInt(2, updatedBy);
		ps.setDate(3, updatedDate);
		ps.setInt(4, floorId);
		ps.setInt(5, orgId);
		ps.executeUpdate();

		System.out.println("Record updated");
		return floorRepo.save(floor);
	}

	public String getAllFloor() throws ClassNotFoundException, SQLException {

		List<Object> dataList = new ArrayList<>();

		Class.forName("com.mysql.jdbc.Driver");
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
				Statement st = con.createStatement();
//				SELECT JSON_ARRAYAGG(JSON_OBJECT('city_id', city_id, 'city_name', city_name)) from City;
				ResultSet rs = st.executeQuery(
						"SELECT f.floor_id,f.branch_id,f.created_date,f.floor_name,f.is_active,f.org_id,f.project_id,f.srno,f.updated_by,f.updated_date,f.user_id,f.\r\n"
								+ "wing_id,f.site_id ,p.project_name,w.wing_name,s.site_name\r\n" + "FROM floor f \r\n"
								+ "inner join wing w on f.wing_id=w.wing_id and f.project_id=w.project_id and f.org_id=w.org_id\r\n"
								+ "inner join site s on f.site_id=s.site_id and f.org_id=s.org_id\r\n"
								+ "inner join project p on  f.project_id=p.project_id and f.org_id=p.org_id")) {

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

				if (count !=16) {

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

//p!!D2J$Jk3%w
	public String getFloorSite(Floor floor) throws ClassNotFoundException, SQLException {
		List<Object> dataList = new ArrayList<>();
		int orgId = floor.getOrgId();
		int projectId = floor.getProjectId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
		String query = "SELECT   s.site_id,s.site_name FROM site s \r\n"
				+ "			 					INNER JOIN project pj  ON pj.org_id = s.org_id  and pj.project_id=s.project_id\r\n"
				+ "			 					where pj.org_id = ? and   s.project_id=? \r\n"
				+ "								group by  s.site_id,s.site_id";

		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, orgId);
		ps.setInt(2, projectId);
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

	public String getFloorWing(Floor floor) throws ClassNotFoundException, SQLException {

		List<Object> dataList = new ArrayList<>();
		int orgId = floor.getOrgId();
		int projectId = floor.getProjectId();
		int siteId = floor.getSiteId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
		String query = "SELECT   w.wing_id,w.wing_name FROM wing w					\r\n"
				+ "				inner join site s on w.project_id=s.project_id   \r\n"
				+ "	 			INNER JOIN project pj  ON pj.org_id = s.org_id  and s.project_id=pj.project_id\r\n"
				+ "				where pj.org_id = ? and w.project_id=? and s.site_id=?\r\n"
				+ "				group by  w.wing_id,w.wing_name";

		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, orgId);
		ps.setInt(2, projectId);
		ps.setInt(3, siteId);
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

	public Floor findFloorById(int floor) {
		return floorRepo.findById(floor).get();
	}

	public String deleteFloorByID(int floor) {
		floorRepo.deleteById(floor);
		return "deleted";
	}

}
