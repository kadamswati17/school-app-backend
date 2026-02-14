package com.schoolapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.schoolapp.entity.ClassMaster;
import com.schoolapp.entity.ClassMaster;
import com.schoolapp.repository.ClassMasterRepo;
import com.schoolapp.repository.ClassMasterRepo;

@Component
public class ClassMasterDao {

	@Autowired
	ClassMasterRepo classMasterRepo;

	public ClassMaster saveClassMaster(ClassMaster classMaster) {
		return classMasterRepo.save(classMaster);
	}

	public String getAllClassMaster(ClassMaster classMaster) throws ClassNotFoundException, SQLException {

		JSONArray result = new JSONArray();

		int orgId = classMaster.getOrgId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery(
				"SELECT class_id, branch_id, class_name, created_date, is_active, org_id, updated_by, updated_date, user_id FROM  class_master  where org_id="
						+ orgId);

		ResultSetMetaData md = resultSet.getMetaData();
		int numCols = md.getColumnCount();
		List<String> colNames = IntStream.range(0, numCols).mapToObj(i -> {
			try {
				return md.getColumnName(i + 1);
			} catch (SQLException e) {
				e.printStackTrace();
				return "?";
			}
		}).collect(Collectors.toList());

		while (resultSet.next()) {
			JSONObject row = new JSONObject();
			colNames.forEach(cn -> {
				try {
					row.put(cn, resultSet.getObject(cn));
				} catch (JSONException | SQLException e) {
					e.printStackTrace();
				}
			});
			result.put(row);
		}
		return "" + result;
	}

	public ClassMaster findClassMasterById(int classMasterId) {
		return classMasterRepo.findById(classMasterId).get();
	}

	public String deleteClassMasterById(int classMasterId) {
		classMasterRepo.deleteById(classMasterId);
		return "deleted";
	}
}
