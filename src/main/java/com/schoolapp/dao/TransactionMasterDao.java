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

import com.schoolapp.entity.TransactionMaster;
import com.schoolapp.repository.TransactionMasterRepo;

@Component
public class TransactionMasterDao {

	@Autowired
	TransactionMasterRepo TransactionMasterRepo;

	public TransactionMaster saveTransactionMaster(TransactionMaster TransactionMaster) {
		return TransactionMasterRepo.save(TransactionMaster);
	}

	public String getAllTransactionMaster(TransactionMaster TransactionMaster)
			throws SQLException, ClassNotFoundException {
		JSONArray result = new JSONArray();
		int trMstId = TransactionMaster.getTransactionMasterId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery(
				"SELECT  usr.user_name,org.org_name,org.invoice_address,rm.reasource_name,std.recived_amt, cm.class_name,concat(ad.first_name,\" \",ad.middle_name,\" \",ad.last_name) as name,tm.transaction_master_id, \r\n"
						+ "tm.branch_id, tm.created_date, tm.description, tm.finance_year, tm.is_active, tm.org_id, tm.recived_amt, tm.s_id,tm.sr_no, tm.tr_date, tm.updated_by,\r\n"
						+ "tm.updated_date, tm.user_id\r\n" + "FROM transaction_master  tm\r\n"
						+ "inner join admission ad on tm.s_id=ad.admission_id\r\n"
						+ "inner join class_master cm on ad.class_id=cm.class_id\r\n"
						+ "inner join std_annual_fees sf on ad.admission_id=sf.s_id\r\n"
						+ "left join std_transaction_detailes std on sf.std_annual_fees_id=std.std_annual_fees_id and tm.transaction_master_id=std.payment_rcv_id\r\n"
						+ "inner join reasource_master rm on sf.reasource_id=rm.reasource_id\r\n"
						+ "inner join organization org on tm.org_id=org.org_id\r\n"
						+ "inner join user usr on tm.user_id=usr.u_id\r\n" + "where tm.transaction_master_id="
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

	public TransactionMaster findTransactionMasterById(int TransactionMasterId) {
		return TransactionMasterRepo.findById(TransactionMasterId).get();
	}

	public String deleteTransactionMasterById(int TransactionMasterId) {
		TransactionMasterRepo.deleteById(TransactionMasterId);
		return "deleted";
	}

}
