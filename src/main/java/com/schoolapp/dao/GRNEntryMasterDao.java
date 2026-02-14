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

import com.schoolapp.entity.GRNEntryMaster;
import com.schoolapp.repository.GRNEntryMasterRepo;

@Component
public class GRNEntryMasterDao {

	@Autowired
	GRNEntryMasterRepo GRNEntryMasterRepo;

	public GRNEntryMaster saveGRNEntryMaster(GRNEntryMaster GRNEntryMaster)
			throws ClassNotFoundException, SQLException {
		System.out.println("Data inserted successfully...");
		return GRNEntryMasterRepo.save(GRNEntryMaster);
	}

	public String getAllGRNEntryMaster(GRNEntryMaster GRNEntryMaster) throws Exception {
		JSONArray result = new JSONArray();
		int orgId = GRNEntryMaster.getOrgId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpdb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery("SELECT c.cust_name,m.grnentry_master_id, m.created_date,  m.purchase_order_id\r\n"
				+ "FROM  grnentry_master m left join grnentry g on m.grnentry_master_id = g.grnentry_id\r\n"
				+ "Inner join customer  c on g.customer_id = c.cust_id where m.org_id=" + orgId);

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

	public GRNEntryMaster updateDeleteGRNEntryMaster(GRNEntryMaster GRNEntryMaster)
			throws ClassNotFoundException, SQLException {

		return GRNEntryMasterRepo.save(GRNEntryMaster);
	}

	public GRNEntryMaster findGRNEntryMasterById(int GRNEntryMasterId) {
		return (GRNEntryMaster) GRNEntryMasterRepo.findById(GRNEntryMasterId).get();
	}

	public String deleteGRNEntryMasterById(int GRNEntryMasterId) {
		GRNEntryMasterRepo.deleteById(GRNEntryMasterId);
		return "deleted";
	}

}
