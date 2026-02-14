package com.schoolapp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

import com.schoolapp.entity.Admission;
import com.schoolapp.entity.Organization;
import com.schoolapp.entity.TcMaster;
import com.schoolapp.repository.TcMasterRepo;

@Component
public class TcMasterDao {
	@Autowired
	TcMasterRepo TcMasterRepo;

	public TcMaster saveTcMaster(TcMaster TcMaster) throws ClassNotFoundException, SQLException {

		TcMasterRepo.save(TcMaster);

		TcMaster path = null;
		int orgId = TcMaster.getOrgId();
		int tcMasterId = TcMaster.getTcMasterId();

		Connection con = null;
		PreparedStatement ps = null;
		String query = null;

		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");
		query = "UPDATE tc_master AS t1\r\n" + "JOIN (\r\n"
				+ "SELECT IFNULL(COUNT(tc_master_id), 0) + 1 AS total_count FROM tc_master\r\n"
				+ "WHERE org_id = " + orgId + " AND tc_master_id < 1 ) AS t2\r\n"
				+ "SET t1.lcissue_no = t2.total_count WHERE t1.tc_master_id = " + tcMasterId + "\r\n" + "";
		ps = con.prepareStatement(query);
		ps.executeUpdate();

		return path;

	}

	public String getAllTcMaster(TcMaster TcMaster) throws ClassNotFoundException, SQLException {

		JSONArray result = new JSONArray();
		int orgId = TcMaster.getOrgId(); 
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery(
				"SELECT concat(ad.first_name,' ',ad.middle_name,' ',ad.last_name)as name ,tm.tc_master_id, tm.branch_id, tm.conduct, tm.created_date, tm.date_of_leaving, tm.is_active, tm.org_id, tm.reason_of_leaving, tm.remark, tm.tc_std_name, tm.updated_by, tm.updated_date, tm.user_id, tm.taluka_name,\r\n"
						+ "tm.dist_name, tm.lcissue_no FROM  tc_master tm\r\n"
						+ "left join admission ad on  tm.tc_std_name=ad.admission_id \r\n" + "where  tm.org_id="
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

	public TcMaster updateTcMaster(TcMaster TcMaster) throws SQLException, ClassNotFoundException {

		return TcMasterRepo.save(TcMaster);
	}

	public TcMaster findTcMasterById(int TcMasterId) {
		return TcMasterRepo.findById(TcMasterId).get();
	}

	public String deleteTcMasterById(int TcMasterId) {
		TcMasterRepo.deleteById(TcMasterId);
		return "deleted";
	}
}
