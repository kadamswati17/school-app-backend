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

import com.schoolapp.entity.StdAnnualFees;
import com.schoolapp.repository.StdAnnualFeesRepo;

@Component
public class StdAnnualFeesDao {
	@Autowired
	StdAnnualFeesRepo StdAnnualFeesRepo;

	public StdAnnualFees saveStdAnnualFees(StdAnnualFees StdAnnualFees) {
		return StdAnnualFeesRepo.save(StdAnnualFees);
	}

	public String getAllStdAnnualFees(StdAnnualFees StdAnnualFees) throws ClassNotFoundException, SQLException {

		JSONArray result = new JSONArray();
		Class.forName("com.mysql.jdbc.Driver");
		int orgId = StdAnnualFees.getOrgId();
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = ((java.sql.Statement) stmt).executeQuery(
				"SELECT concat(ad.first_name,\" \",ad.middle_name,\" \",ad.last_name) as student_name,cm.class_name ,sf.std_annual_fees_id,sf.branch_id,sf.charges,sf.class_id,sf.created_date,sf.fees_structure_id,sf.finance_year,\r\n"
						+ "sf.is_active,sf.org_id,sf.reasource_id,sf.s_id,sf.tr_date,sf.updated_by,sf.updated_date,sf.user_id\r\n"
						+ "FROM  std_annual_fees sf\r\n" + "inner join admission ad on sf.s_id=ad.admission_id  \r\n"
						+ "inner join class_master cm on ad.class_id=cm.class_id where sf.org_id=" + orgId);

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

	public String getYearWiseStdOutstanding(StdAnnualFees StdAnnualFees) throws ClassNotFoundException, SQLException {
		int financialYear = StdAnnualFees.getFinanceYear();
		int sId = StdAnnualFees.getsId();
		int orgID = StdAnnualFees.getOrgId();
		JSONArray result = new JSONArray();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = ((java.sql.Statement) stmt)
				.executeQuery("select a.charges-b.rcv_charges as charges  from(( \r\n"
						+ "SELECT  ad.admission_id ,  ifnull(sum(sf.charges),0)  as charges \r\n"
						+ "FROM  std_annual_fees sf   \r\n"
						+ "left join admission ad on sf.s_id=ad.admission_id    \r\n" + "where sf.finance_year ="
						+ financialYear + "  and ad.org_id=" + orgID + "  and ad.admission_id=" + sId + "\r\n"
						+ "group by  ad.admission_id) as a,\r\n"
						+ "(SELECT    ifnull(sum(std.recived_amt),0)  as rcv_charges \r\n"
						+ "FROM  std_annual_fees sf   \r\n"
						+ "left join std_transaction_detailes std on sf.std_annual_fees_id=std.std_annual_fees_id\r\n"
						+ "where sf.finance_year =" + financialYear + "  and sf.org_id=" + orgID + "  and sf.s_id="
						+ sId + ") as b)");

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

	public StdAnnualFees findStdAnnualFeesById(int StdAnnualFeesId) {
		return StdAnnualFeesRepo.findById(StdAnnualFeesId).get();
	}

	public String deleteStdAnnualFeesById(int StdAnnualFeesId) {
		StdAnnualFeesRepo.deleteById(StdAnnualFeesId);
		return "deleted";
	}
}
