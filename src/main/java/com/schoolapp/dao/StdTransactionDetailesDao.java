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

import com.schoolapp.entity.StdAnnualFees;
import com.schoolapp.entity.StdTransactionDetailes;
import com.schoolapp.entity.TransactionMaster;
import com.schoolapp.repository.StdTransactionDetailesRepo;

@Component
public class StdTransactionDetailesDao {
	@Autowired
	StdTransactionDetailesRepo stdTransactionDetailesRepo;

	public List<StdTransactionDetailes> saveStdTransactionDetailes(List<StdTransactionDetailes> stdTransactionDetailes)
			throws SQLException, ClassNotFoundException {

		int transactionMasterId = 0;
		String description = null;
		int recivedAmt = 0;
		int srNo = 0;
		Date trDate = null;
		int userId = 0;
		int orgId = 0;
		int branchId = 0;
		Date createdDate = null;
		int updatedBy = 0;
		Date updatedDate = null;
		int cnt = 0;
		int sumRcvAmt = 0;
		int stdAnlFessId = 0;
		int sId = 0;
		int financeYear = 0;

		for (StdTransactionDetailes al2 : stdTransactionDetailes) {
			stdAnlFessId = al2.getStdAnnualFeesId();
		}
		System.out.println("anuall id : " + stdAnlFessId);

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");

		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery(
				"SELECT finance_year,s_id FROM  std_annual_fees where std_annual_fees_id=" + stdAnlFessId);

		while (resultSet.next()) {
			financeYear = resultSet.getInt(1);
			sId = resultSet.getInt(2);
		}
		for (StdTransactionDetailes al1 : stdTransactionDetailes) {
			recivedAmt = al1.getRecivedAmt();
			sumRcvAmt += recivedAmt;
		}

		for (StdTransactionDetailes al : stdTransactionDetailes) {

			description = al.getDescription();
			branchId = al.getBranchId();
			userId = al.getUserId();
			orgId = al.getOrgId();
			createdDate = al.getCreatedDate();
			trDate = al.getCreatedDate();
			updatedBy = al.getUpdatedBy();
			updatedDate = al.getUpdatedDate();

			String sql = "INSERT INTO transaction_master (branch_id, created_date, description, finance_year,is_active, org_id, recived_amt, s_id, sr_no, \r\n"
					+ "tr_date, updated_by, updated_date, user_id )  VALUES (?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?,?,?)";

			PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			if (cnt == 0) {
				cnt = 1;
				pst.setInt(1, branchId);
				pst.setDate(2, createdDate);
				pst.setString(3, description);
				pst.setInt(4, financeYear);
				pst.setInt(5, 1);
				pst.setInt(6, orgId);
				pst.setInt(7, sumRcvAmt);
				pst.setInt(8, sId);
				pst.setInt(9, srNo);
				pst.setDate(10, trDate);
				pst.setInt(11, updatedBy);
				pst.setDate(12, updatedDate);
				pst.setInt(13, userId);
				pst.executeUpdate();

				ResultSet rs = pst.getGeneratedKeys();
				if (rs.next()) {
					transactionMasterId = rs.getInt(1);
				}
			}
			al.setPaymentRcvId(transactionMasterId);

		}

		return stdTransactionDetailesRepo.saveAll(stdTransactionDetailes);

	}

	public String getAllStdTransactionDetailes(StdTransactionDetailes StdTransactionDetailes)
			throws ClassNotFoundException, SQLException {

		JSONArray result = new JSONArray();
		int orgId = StdTransactionDetailes.getOrgId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery(
				"SELECT std_transaction_detailes_id, branch_id, cheque_date, cheque_no, created_date, description, org_id, payment_rcv_id, "
						+ "pre_balance, recived_amt, std_annual_fees_id, tr_date, updated_by, updated_date, user_id "
						+ "FROM schooldb.std_transaction_detailes   where org_id=" + orgId);

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

	public String stdYearwiseFeesTrnDetailes(StdAnnualFees StdAnnualFees) throws ClassNotFoundException, SQLException {
		int financialYear = StdAnnualFees.getFinanceYear();
		int sId = StdAnnualFees.getsId(); 
		JSONArray result = new JSONArray();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = ((java.sql.Statement) stmt).executeQuery(
				"SELECT  sf.std_annual_fees_id,ad.admission_id, rm.reasource_name,sf.charges,ifnull(sum(tr.recived_amt),0) as rcv_amount,count(1)\r\n"
						+ "FROM  std_annual_fees sf\r\n" + "inner join admission ad on sf.s_id=ad.admission_id   \r\n"
						+ "inner join reasource_master rm on sf.reasource_id=rm.reasource_id\r\n"
						+ "left join  std_transaction_detailes  tr on sf.std_annual_fees_id=tr.std_annual_fees_id\r\n"
						+ "where sf.finance_year = " + financialYear + " and sf.s_id=" + sId + "\r\n"
						+ "group by  sf.std_annual_fees_id,ad.admission_id, rm.reasource_name,sf.charges ");

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

	public String getAllTranMst(StdTransactionDetailes StdTransactionDetailes)
			throws ClassNotFoundException, SQLException {

		JSONArray result = new JSONArray();
		Class.forName("com.mysql.jdbc.Driver");
		int orgId = StdTransactionDetailes.getOrgId();
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = ((java.sql.Statement) stmt).executeQuery(
				"SELECT  cm.class_name,concat(ad.first_name,\" \",ad.middle_name,\" \",ad.last_name) as name,tm.transaction_master_id, tm.branch_id, tm.created_date, tm.description, tm.finance_year, tm.is_active, tm.org_id, tm.recived_amt, tm.s_id, \r\n"
						+ "tm.sr_no, tm.tr_date, tm.updated_by, tm.updated_date, tm.user_id  \r\n"
						+ "FROM transaction_master  tm\r\n" + "inner join admission ad on tm.s_id=ad.admission_id\r\n"
						+ "inner join class_master cm on ad.class_id=cm.class_id\r\n" + "where tm.org_id=" + orgId);

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

	public String getPdfRcp(StdTransactionDetailes StdTransactionDetailes) throws SQLException, ClassNotFoundException {
		JSONArray result = new JSONArray();
		int trMstId = StdTransactionDetailes.getPaymentRcvId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery(
				"SELECT  usr.user_name,org.org_name,org.invoice_address,rm.reasource_name,std.recived_amt, cm.class_name,concat(ad.first_name,\" \",ad.middle_name,\" \",ad.last_name) as name,tm.transaction_master_id, \r\n"
						+ "tm.branch_id, tm.created_date, tm.description, tm.finance_year, tm.is_active, tm.org_id, tm.recived_amt, tm.s_id,tm.sr_no,DATE_FORMAT(tm.tr_date,'%d/%m/%Y') as tr_date , tm.updated_by,\r\n"
						+ "tm.updated_date, tm.user_id\r\n" + "FROM transaction_master  tm\r\n"
						+ "inner join admission ad on tm.s_id=ad.admission_id\r\n"
						+ "inner join class_master cm on ad.class_id=cm.class_id\r\n"
						+ "inner join std_annual_fees sf on ad.admission_id=sf.s_id\r\n"
						+ "left join std_transaction_detailes std on sf.std_annual_fees_id=std.std_annual_fees_id and tm.transaction_master_id=std.payment_rcv_id\r\n"
						+ "inner join reasource_master rm on sf.reasource_id=rm.reasource_id\r\n"
						+ "inner join organization org on tm.org_id=org.org_id\r\n"
						+ "inner join user usr on tm.user_id=usr.u_id\r\n" + "where std.recived_amt>0 and tm.transaction_master_id="
						+ trMstId);

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

	public StdTransactionDetailes findStdTransactionDetailesById(int stdTransactionDetailesId) {
		return stdTransactionDetailesRepo.findById(stdTransactionDetailesId).get();
	}

//	public String updateStdTransactionDetailes(StdTransactionDetailes stdTransactionDetailes) throws SQLException, ClassNotFoundException {
//		Integer admissionId = admission.getAdmissionId();
//		int age = admission.getAge();
//		String birth_place = admission.getBirthPlace();
//		String bus = admission.getBus();
//		String cast = admission.getCast();
//		String category = admission.getCategory();
//		int class_name = admission.getClassName();
//		Date dob = admission.getDob();
//		String first_name = admission.getFirstName();
//		String gender = admission.getGender();
//		String last_name = admission.getLastName();
//		String middle_name = admission.getMiddleName();
//		String mother_tongue = admission.getMotherTongue();
//		String nationality = admission.getNationality();
//		String religion = admission.getReligion();
//		String section = admission.getSection();
//		String sub_cast = admission.getSubCast();
//		String teacher_relativeint = admission.getTeacherRelative();
//
//		Class.forName("com.mysql.jdbc.Driver");
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");
//		String query = "update admission set  age=?, birth_place=?,  bus=?, cast=?, category=?, "
//				+ " class_name=?, dob=?, first_name=?, gender=?,   last_name=?, middle_name=?, mother_tongue=?, nationality=?,"
//				+ "   religion=?, section=?, sub_cast=?, teacher_relativeint=? where admission_id=?";
//		PreparedStatement ps = con.prepareStatement(query);
//
//		ps.setInt(1, age);
//		ps.setString(2, birth_place);
//		ps.setString(3, bus);
//		ps.setString(4, cast);
//		ps.setString(5, category);
//		ps.setInt(6, class_name);
//		ps.setDate(7, dob);
//		ps.setString(8, first_name);
//		ps.setString(9, gender);
//		ps.setString(10, last_name);
//		ps.setString(11, middle_name);
//		ps.setString(12, mother_tongue);
//		ps.setString(13, nationality);
//		ps.setString(14, religion);
//		ps.setString(15, section);
//		ps.setString(16, sub_cast);
//		ps.setString(17, teacher_relativeint);
//		ps.setInt(18, admissionId);
//		ps.executeUpdate();
//
//		System.out.println("Record updated successfully..!");
//		return "Record updated..!";
//
//	}

	public String deleteStdTransactionDetailesById(int stdTransactionDetailesId) {
		stdTransactionDetailesRepo.deleteById(stdTransactionDetailesId);
		return "deleted";
	}
}
