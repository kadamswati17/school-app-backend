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

import com.schoolapp.entity.RecieptPaymentTransaction;

@Component
public class RecieptPaymentTransactionDao {
	@Autowired
	com.schoolapp.repository.RecieptPaymentTransactionRepo RecieptPaymentTransactionRepo;

	public RecieptPaymentTransaction saveRecieptPaymentTransaction(
			RecieptPaymentTransaction recieptPaymentTransaction) {
		return RecieptPaymentTransactionRepo.save(recieptPaymentTransaction);
	}

	public String getAllRecieptPaymentTransaction(RecieptPaymentTransaction RecieptPaymentTransaction)
			throws SQLException, ClassNotFoundException {
		JSONArray result = new JSONArray();
		int orgId = RecieptPaymentTransaction.getOrgId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt
				.executeQuery("SELECT p.org_id, p.cust_id, p.cust_name, p.phone, SUM(p.receipt) AS Balance \r\n"
						+ "FROM   ( select org_id, cust_id, cust_name, phone, 0  AS receipt \r\n"
						+ "from customer  where org_id="+orgId+" union  \r\n"
						+ "SELECT cs.org_id, cs.cust_id, cs.cust_name, cs.phone, IFNULL(SUM(CASE WHEN rp.trn_type_id = 2 THEN rp.trn_amount * -1 ELSE 0 END), 0) AS receipt\r\n"
						+ "FROM reciept_payment_transaction rp     \r\n"
						+ "INNER JOIN organization org ON rp.org_id = org.org_id\r\n"
						+ "INNER JOIN user usr ON rp.user_id = usr.u_id \r\n"
						+ "INNER JOIN customer cs ON rp.customer_id = cs.cust_id WHERE cs.org_id = " + orgId + "\r\n"
						+ "GROUP BY cs.org_id, cs.cust_id, cs.cust_name, cs.phone UNION \r\n"
						+ "SELECT cs.org_id, cs.cust_id, cs.cust_name, cs.phone, IFNULL(SUM(CASE WHEN rp.trn_type_id = 1 THEN rp.trn_amount ELSE 0 END), 0) AS receipt\r\n"
						+ "FROM reciept_payment_transaction rp     \r\n"
						+ "INNER JOIN organization org ON rp.org_id = org.org_id\r\n"
						+ "INNER JOIN user usr ON rp.user_id = usr.u_id \r\n"
						+ "INNER JOIN customer cs ON rp.customer_id = cs.cust_id WHERE cs.org_id = " + orgId + "\r\n"
						+ "GROUP BY cs.org_id, cs.cust_id, cs.cust_name, cs.phone) p\r\n"
						+ "GROUP BY p.org_id, p.cust_id, p.cust_name, p.phone");

		System.out.println("---- " + orgId);
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

	public String getAcStsmt(RecieptPaymentTransaction RecieptPaymentTransaction)
			throws SQLException, ClassNotFoundException {
		JSONArray result = new JSONArray();
		int orgId = RecieptPaymentTransaction.getOrgId();
		int custId = RecieptPaymentTransaction.getCustomerId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery("SELECT subquery.created_date,\r\n"
				+ "subquery.trn_type_id, subquery.description, subquery.cheque_no,\r\n"
				+ "subquery.cheque_date, subquery.user_name, subquery.org_id,\r\n"
				+ "subquery.cust_id, subquery.cust_name, subquery.phone, subquery.Receipt,\r\n"
				+ "subquery.Payment, subquery.Receipt - subquery.Payment AS total FROM (\r\n"
				+ "SELECT rp.created_date, rp.trn_type_id, rp.description,\r\n"
				+ "rp.cheque_no, rp.cheque_date, usr.user_name, cs.org_id,\r\n"
				+ "cs.cust_id, cs.cust_name, cs.phone,\r\n"
				+ "SUM(CASE WHEN rp.trn_type_id = 1 THEN rp.trn_amount ELSE 0 END) AS Receipt,\r\n"
				+ "SUM(CASE WHEN rp.trn_type_id = 2 THEN rp.trn_amount ELSE 0 END) AS Payment FROM \r\n"
				+ "reciept_payment_transaction rp INNER JOIN  organization org ON rp.org_id = org.org_id\r\n"
				+ "INNER JOIN  user usr ON rp.user_id = usr.u_id  INNER JOIN \r\n"
				+ "customer cs ON rp.customer_id = cs.cust_id  WHERE cs.cust_id=" + custId + " and  cs.org_id = "
				+ orgId + "\r\n" + "GROUP BY  rp.created_date, rp.trn_type_id, rp.description,\r\n"
				+ "rp.cheque_no, rp.cheque_date, usr.user_name, cs.org_id,\r\n"
				+ "cs.cust_id, cs.cust_name, cs.phone ) AS subquery;\r\n");

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

	public RecieptPaymentTransaction findRecieptPaymentTransactionById(int RecieptPaymentTransactionId) {
		return RecieptPaymentTransactionRepo.findById(RecieptPaymentTransactionId).get();
	}

	public String deleteRecieptPaymentTransactionById(int RecieptPaymentTransactionId) {
		RecieptPaymentTransactionRepo.deleteById(RecieptPaymentTransactionId);
		return "deleted";
	}
}
