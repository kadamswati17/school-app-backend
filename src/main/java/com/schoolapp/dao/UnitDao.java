package com.schoolapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.schoolapp.entity.AccessPermission;
import com.schoolapp.entity.Floor;
import com.schoolapp.entity.LeadAccounts;
import com.schoolapp.entity.Project;
import com.schoolapp.entity.Site;
import com.schoolapp.entity.Unit;
import com.schoolapp.entity.User;
import com.schoolapp.repository.UnitRepo;

@Component
public class UnitDao {

	@Autowired
	UnitRepo unitRepo;

	public Unit saveUnit(Unit unit) throws ClassNotFoundException, SQLException {
		System.out.println("Data inserted successfully...");
		return unitRepo.save(unit);
	}

	public String updateUnit(Unit unit) throws SQLException, ClassNotFoundException {
		Integer unitId = unit.getUnitId();

		String unitName = unit.getUnitName();
		int floorId = unit.getFloorId();
		int wingId = unit.getWingId();
		int projectId = unit.getProjectId();
		int srNo = unit.getSrNo();
		float totoalSqrft = unit.getTotoalSqrft();
		int price = unit.getPrice();
		int userId = unit.getUserId();
		int orgId = unit.getOrgId();
		int branchId = unit.getBranchId();
		Date createdDate = unit.getCreatedDate();
		int updatedBy = unit.getUserId();
		Date updatedDate = unit.getUpdatedDate();
		int isActive = unit.getIsActive();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
		String query = "update unit set unit_id = ? , floor_id = ? , price = ? , project_id = ? , sr_no = ? , totoal_sqrft = ? , unit_name = ? ,"
				+ " wing_id = ? , branch_id = ? , created_date = ? , is_active = ? ,  updated_by = ? , updated_date = ? , user_id=?"
				+ " where unit_id= ? and org_id = ?";

		PreparedStatement ps = con.prepareStatement(query);

		ps.setInt(1, unitId);
		ps.setInt(2, floorId);
		ps.setInt(3, price);
		ps.setInt(4, projectId);
		ps.setInt(5, srNo);
		ps.setFloat(6, totoalSqrft);
		ps.setString(7, unitName);
		ps.setInt(8, wingId);
		ps.setInt(9, branchId);
		ps.setDate(10, createdDate);
		ps.setInt(11, isActive);
		ps.setInt(12, updatedBy);
		ps.setDate(13, updatedDate);
		ps.setInt(14, userId);
		ps.setInt(15, unitId);
		ps.setInt(16, orgId);
		ps.executeUpdate();

		System.out.println("Record updated successfully..!");
		return "Record updated..!";

	}

	public Unit updateDeleteUnit(Unit unit) throws ClassNotFoundException, SQLException {
		Integer unitId = unit.getUnitId();
//		Contractor accounts = contractorDao.findContractorById(contractor.getContractorId());

		int userId = unit.getUserId();
		int updatedBy = unit.getUpdatedBy();
		Date updatedDate = unit.getUpdatedDate();
		int branchId = unit.getBranchId();
		int orgId = unit.getOrgId();
		int isActive = unit.getIsActive();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
		String query = "update unit set is_active=?, updated_by=?,updated_date=? " + "where unit_id=? and org_id=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, isActive);
		ps.setInt(2, updatedBy);
		ps.setDate(3, (java.sql.Date) updatedDate);
		ps.setInt(4, unitId);
		ps.setInt(5, orgId);
		ps.executeUpdate();
		System.out.println("Record updated");
		return unitRepo.save(unit);
	}

	public List<Unit> getAllUnit() {
		return unitRepo.findAll();
	}

	public String getUnitSite(Unit unit) throws ClassNotFoundException, SQLException {
		List<Object> dataList = new ArrayList<>();
		int orgId = unit.getOrgId();
		int projectId = unit.getProjectId();
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

	public String getUnitWing(Unit unit) throws ClassNotFoundException, SQLException {

		List<Object> dataList = new ArrayList<>();
		int orgId = unit.getOrgId();
		int projectId = unit.getProjectId();
		int siteId = unit.getSiteId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
		String query = "SELECT   w.wing_id,w.wing_name FROM wing w					\r\n"
				+ "				inner join site s on w.project_id=s.project_id   \r\n"
				+ "	 			INNER JOIN project pj  ON pj.org_id = s.org_id  and s.project_id=pj.project_id\r\n"
				+ "				where pj.org_id = ? and w.project_id=? and s.site_id=?\r\n"
				+ "				group by  w.wing_id,w.wing_name ";

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

	public String getUnitFloor(Unit unit) throws ClassNotFoundException, SQLException {

		List<Object> dataList = new ArrayList<>();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
		String query = "SELECT  u.unit_id,u.branch_id,u.created_date,u.floor_id,u.is_active,u.org_id,u.price,u.project_id,u.sr_no,\r\n"
				+ "				u.totoal_sqrft,u.unit_name,u.updated_by,u.updated_date,u.user_id,u.wing_id,u.site_id, \r\n"
				+ "				pj.project_name,w.wing_name,s.site_name,f.floor_name  FROM unit u\r\n"
				+ "				inner join floor f on u.floor_id=f.floor_id and u.wing_id=f.wing_id and u.site_id=f.site_id and u.org_id=f.org_id and u.project_id=f.project_id\r\n"
				+ "				inner join wing w on   u.wing_id=w.wing_id and u.site_id=w.site_id and u.org_id=w.org_id and u.project_id=w.project_id\r\n"
				+ "				inner join site s on u.project_id=s.project_id  and u.org_id=s.org_id\r\n"
				+ "				INNER JOIN project pj  ON pj.org_id = u.org_id  and u.project_id=pj.project_id\r\n"
				+ "			 group by  u.unit_id,u.branch_id,u.created_date,u.floor_id,u.is_active,u.org_id,u.price,u.project_id,u.sr_no,\r\n"
				+ "				u.totoal_sqrft,u.unit_name,u.updated_by,u.updated_date,u.user_id,u.wing_id,u.site_id, \r\n"
				+ "				pj.project_name,w.wing_name,s.site_name,f.floor_name order by u.unit_id desc";

		PreparedStatement ps = con.prepareStatement(query);

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

				if (count != 20) {

					jsonBuilder.append(",\n");
				}
			}
			if (count == 20) {
				jsonBuilder.append("\n},");
				count++;
				if (count >= 21) {
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

	public Unit findUnitById(int Unit) {
		return unitRepo.findById(Unit).get();
	}

	public String deleteUnitByID(int Unit) {
		unitRepo.deleteById(Unit);
		return "deleted";
	}

}
