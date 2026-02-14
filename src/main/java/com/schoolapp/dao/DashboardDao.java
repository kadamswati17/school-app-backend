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

import com.schoolapp.entity.Dashboard;
import com.schoolapp.entity.StdAnnualFees;
import com.schoolapp.repository.DashboardRepo;

@Component
public class DashboardDao {
	@Autowired
	DashboardRepo dashboardRepo;

	public Dashboard saveDashboard(Dashboard dashboard) {
		return dashboardRepo.save(dashboard);
	}

	public List<Dashboard> getAllDashboard() {

		return dashboardRepo.findAll();
	}

	public Dashboard findDashboardById(int dashId) {
		return dashboardRepo.findById(dashId).get();
	}

	public String deleteDashboardById(int dashId) {
		dashboardRepo.deleteById(dashId);
		return "deleted";
	}

//	----------   All Important apis ---------------------------

	public String AllStudentYearWise(StdAnnualFees stdAnnualFees) throws ClassNotFoundException, SQLException {

		JSONArray result = new JSONArray();

		int financeYear = stdAnnualFees.getFinanceYear();
		int orgId = stdAnnualFees.getOrgId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = ((java.sql.Statement) stmt).executeQuery(
				"SELECT   finance_year, count(distinct s_id) as total" + " FROM std_annual_fees  where org_id=" + orgId
						+ " and  finance_year = " + financeYear + " group by   finance_year;");

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

	public String AllStudentClassWise(StdAnnualFees stdAnnualFees) throws ClassNotFoundException, SQLException {

		JSONArray result = new JSONArray();
		int financeYear = stdAnnualFees.getFinanceYear();
		int orgId = stdAnnualFees.getOrgId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = ((java.sql.Statement) stmt).executeQuery(
				"SELECT sf.class_id, cm.class_name,ifnull(count(distinct sf.s_id),0) as total_student, round(ifnull(sum(sf.charges),0))  Total_Annual_Fees \r\n"
						+ ",ifnull(sum(st.recived_amt),0)  As Total_Recieved_Fees ,\r\n"
						+ "ifnull(sum(sf.charges),0) - ifnull(sum(st.recived_amt),0) as Recieved\r\n"
						+ "from std_annual_fees sf \r\n" + "left join std_transaction_detailes st on\r\n"
						+ "sf.std_annual_fees_id = st.std_annual_fees_id \r\n"
						+ "left join class_master cm on sf.class_id=cm.class_id\r\n" + "where sf.org_id=" + orgId
						+ " and  sf.finance_year=" + financeYear + "\r\n" + "group by sf.class_id, cm.class_name\r\n"
						+ "");

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

	public String TotalFeesClassWise(StdAnnualFees stdAnnualFees) throws ClassNotFoundException, SQLException {

		JSONArray result = new JSONArray();
		int financeYear = stdAnnualFees.getFinanceYear();
		int orgId = stdAnnualFees.getOrgId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = ((java.sql.Statement) stmt).executeQuery(
				"SELECT   finance_year, class_id, sum( charges) as sum FROM std_annual_fees  " + "where org_id=" + orgId
						+ " and  finance_year =" + financeYear + " group by finance_year,class_id;");

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

	public String StdResourceWisePendingAmt(StdAnnualFees stdAnnualFees) throws ClassNotFoundException, SQLException {

		JSONArray result = new JSONArray();
		int financeYear = stdAnnualFees.getFinanceYear();
		int orgId = stdAnnualFees.getOrgId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = ((java.sql.Statement) stmt).executeQuery(
				"SELECT sf.s_id, ad.first_name, sf.std_annual_fees_id, sum(sf.charges) Total_Annual_Fees  \r\n"
						+ ",sum(st.recived_amt)  As Total_Recieved_Fees , \r\n"
						+ "sum(sf.charges) - sum(st.recived_amt) as pending  	from std_annual_fees sf  \r\n"
						+ "inner join std_transaction_detailes st on \r\n"
						+ "sf.std_annual_fees_id = st.std_annual_fees_id  \r\n"
						+ "inner join admission ad on sf.s_id=ad.admission_id 	where sf.org_id=" + orgId + "\r\n"
						+ "and sf.finance_year=" + financeYear + "\r\n"
						+ "group by sf.s_id, ad.first_name, sf.std_annual_fees_id,sf.charges,st.recived_amt ");

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

	public String AnnualFeesStatus(StdAnnualFees stdAnnualFees) throws ClassNotFoundException, SQLException {

		JSONArray result = new JSONArray();
		int financeYear = stdAnnualFees.getFinanceYear();
		int orgId = stdAnnualFees.getOrgId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = ((java.sql.Statement) stmt).executeQuery(
				"SELECT  sum(sf.charges) Total_Annual_Fees ,sum(st.recived_amt)  As Total_Recieved_Fees ,\r\n"
						+ "	sum(sf.charges) - sum(st.recived_amt) as Pending\r\n" + " from std_annual_fees sf \r\n"
						+ "	inner join std_transaction_detailes st on\r\n"
						+ "	sf.std_annual_fees_id = st.std_annual_fees_id\r\n" + "	where sf.org_id=" + orgId
						+ " and  sf.finance_year=" + financeYear + "");

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

	public String AnnualResourceTrStatus(StdAnnualFees stdAnnualFees) throws ClassNotFoundException, SQLException {

		JSONArray result = new JSONArray();
		int financeYear = stdAnnualFees.getFinanceYear();
		int orgId = stdAnnualFees.getOrgId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = ((java.sql.Statement) stmt)
				.executeQuery("SELECT rm.reasource_id, rm.reasource_name, sum(sf.charges) Total_Annual_Fees \r\n"
						+ "	,sum(st.recived_amt)  As Total_Recieved_Fees ,\r\n"
						+ "	sum(sf.charges) - sum(st.recived_amt) as pending\r\n" + "	from std_annual_fees sf \r\n"
						+ "	inner join std_transaction_detailes st on\r\n"
						+ "	sf.std_annual_fees_id = st.std_annual_fees_id \r\n"
						+ "	inner join reasource_master rm on sf.reasource_id=rm.reasource_id\r\n"
						+ "	where sf.org_id=" + orgId + " and  sf.finance_year=" + financeYear + ""
						+ "	group by rm.reasource_id, rm.reasource_name");

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

	public String AnnualClassReasourceWiseStatus(StdAnnualFees stdAnnualFees)
			throws ClassNotFoundException, SQLException {

		JSONArray result = new JSONArray();
		int financeYear = stdAnnualFees.getFinanceYear();
		int orgId = stdAnnualFees.getOrgId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = ((java.sql.Statement) stmt)
				.executeQuery("SELECT fs.class_id,cm.class_name, sf.reasource_id,rm.reasource_name,\r\n"
						+ "ifnull(sum(sf.charges),0) Total_Annual_Fees \r\n"
						+ ", ifnull(sum(st.recived_amt),0)  As Total_Recieved_Fees ,\r\n"
						+ "ifnull( sum(sf.charges),0) - ifnull(sum(st.recived_amt),0) as pending\r\n"
						+ "FROM fees_structure fs\r\n" + "inner join class_master cm on fs.class_id=cm.class_id\r\n"
						+ "inner join reasource_master rm on fs.reasource_id=rm.reasource_id\r\n"
						+ "inner join std_annual_fees sf on cm.class_id=sf.class_id and rm.reasource_id=sf.reasource_id\r\n"
						+ "left join std_transaction_detailes st on  sf.std_annual_fees_id = st.std_annual_fees_id \r\n"
						+ "	where sf.org_id=" + orgId + " and  sf.finance_year=" + financeYear + "\r\n"
						+ "group by fs.class_id,cm.class_name, sf.reasource_id,rm.reasource_name");

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

	public String datewiseFeesCollRpt(StdAnnualFees stdAnnualFees) throws ClassNotFoundException, SQLException {

		JSONArray result = new JSONArray();
		Date fromDate = stdAnnualFees.getCreatedDate();
		Date toDate = stdAnnualFees.getUpdatedDate();
		int orgId = stdAnnualFees.getOrgId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");
		Statement stmt = con.createStatement();

		ResultSet resultSet = ((java.sql.Statement) stmt).executeQuery(
				"SELECT  ifnull(concat(ad.first_name,' ',ad.middle_name,' ',ad.last_name),\"\") as name,usr.user_name, tm.transaction_master_id,  \r\n"
						+ "\r\n"
						+ "DATE_FORMAT( tm.created_date,'%d/%m/%Y') AS  created_date, tm.description, tm.finance_year,  tm.org_id, tm.recived_amt, tm.s_id,  tm.tr_date, tm.updated_by, \r\n"
						+ "tm.updated_date, tm.user_id \r\n" + "FROM  transaction_master tm\r\n"
						+ "left join user usr on tm.org_id=usr.org_id and tm.user_id=usr.u_id \r\n" + "\r\n"
						+ "left join admission ad on  tm.org_id=ad.org_id and tm.s_id=ad.admission_id  \r\n" + "\r\n"
						+ "where tm.org_id=" + orgId + " and tm.created_date between " + " ' " + fromDate + " ' "
						+ " and " + " ' " + toDate + " ' " + "\r\n" + "group by ad.middle_name, ad.last_name, \r\n"
						+ "ad.first_name,usr.user_name, tm.transaction_master_id,  tm.created_date, tm.description, \r\n"
						+ "tm.finance_year, tm.org_id, \r\n"
						+ "tm.recived_amt, tm.s_id,  tm.tr_date, tm.updated_by, tm.updated_date, tm.user_id order by tm.transaction_master_id");

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

}
