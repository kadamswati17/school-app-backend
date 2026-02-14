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

import com.schoolapp.entity.OutWorkMaterialMaster;
import com.schoolapp.repository.OutWorkMaterialMasterrRepo;

@Component
public class OutWorkMaterialMasterDao {


	@Autowired
	OutWorkMaterialMasterrRepo OutWorkMaterialMasterRepo;

	public OutWorkMaterialMaster saveOutWorkMaterialMaster(OutWorkMaterialMaster OutWorkMaterialMaster)
			throws ClassNotFoundException, SQLException {
		System.out.println("Data inserted successfully...");
		return OutWorkMaterialMasterRepo.save(OutWorkMaterialMaster);
	}

	public String getAllOutWorkMaterialMaster(OutWorkMaterialMaster OutWorkMaterialMaster) throws Exception {
		JSONArray result = new JSONArray();
		int orgId = OutWorkMaterialMaster.getOrgId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpdb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery("SELECT * FROM  grnentry_master where org_id=" + orgId);

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

	public OutWorkMaterialMaster updateDeleteOutWorkMaterialMaster(OutWorkMaterialMaster OutWorkMaterialMaster)
			throws ClassNotFoundException, SQLException {

		return OutWorkMaterialMasterRepo.save(OutWorkMaterialMaster);
	}

	public OutWorkMaterialMaster findOutWorkMaterialMasterById(int OutWorkMaterialMasterId) {
		return (OutWorkMaterialMaster) OutWorkMaterialMasterRepo.findById(OutWorkMaterialMasterId).get();
	}

	public String deleteOutWorkMaterialMasterById(int OutWorkMaterialMasterId) {
		OutWorkMaterialMasterRepo.deleteById(OutWorkMaterialMasterId);
		return "deleted";
	}

}
