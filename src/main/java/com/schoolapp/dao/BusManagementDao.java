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

import com.schoolapp.entity.BusManagement;

@Component
public class BusManagementDao {
	@Autowired
	com.schoolapp.repository.BusManagementRepo BusManagementRepo;

	public BusManagement saveBusManagement(BusManagement BusManagement) {
		return BusManagementRepo.save(BusManagement);
	}

	public String getAllBusManagement(BusManagement BusManagement) throws SQLException, ClassNotFoundException {
		JSONArray result = new JSONArray();
		int orgId = BusManagement.getOrgId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery("SELECT * FROM bus_management where org_id=" + orgId);

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

	public BusManagement findBusManagementById(int BusManagementId) {
		return BusManagementRepo.findById(BusManagementId).get();
	}

	public String deleteBusManagementById(int BusManagementId) {
		BusManagementRepo.deleteById(BusManagementId);
		return "deleted";
	}
}
