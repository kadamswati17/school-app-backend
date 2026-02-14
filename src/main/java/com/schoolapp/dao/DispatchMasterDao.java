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

import com.schoolapp.entity.DispatchMaster;
import com.schoolapp.repository.DispatchMasterRepo;


@Component
public class DispatchMasterDao {

	@Autowired
	DispatchMasterRepo DispatchMasterRepo;

	public DispatchMaster saveDispatchMaster(DispatchMaster DispatchMaster)
			throws ClassNotFoundException, SQLException {
		System.out.println("Data inserted successfully...");
		return DispatchMasterRepo.save(DispatchMaster);
	}

	public String getAllDispatchMaster(DispatchMaster DispatchMaster) throws Exception {
		JSONArray result = new JSONArray();
		int orgId = DispatchMaster.getOrgId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpdb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery("SELECT * FROM  dispatch_master where org_id=" + orgId);

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

	public DispatchMaster updateDeleteDispatchMaster(DispatchMaster DispatchMaster)
			throws ClassNotFoundException, SQLException {

		return DispatchMasterRepo.save(DispatchMaster);
	}

	public DispatchMaster findDispatchMasterById(int DispatchMasterId) {
		return (DispatchMaster) DispatchMasterRepo.findById(DispatchMasterId).get();
	}

	public String deleteDispatchMasterById(int DispatchMasterId) {
		DispatchMasterRepo.deleteById(DispatchMasterId);
		return "deleted";
	}

}
