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

import com.schoolapp.entity.Dispatch;
import com.schoolapp.repository.DispatchRepo;


@Component
public class DispatchDao {

	@Autowired
	DispatchRepo DispatchRepo;
	
	int existInqMst = 0;

	public List<Dispatch> saveDispatch(List<Dispatch> Dispatch) throws ClassNotFoundException, SQLException {

		for (Dispatch al2 : Dispatch) {

			int srValide = al2.getDispatchMasterId();

			if (srValide == 0) {

				int branchId = al2.getBranchId();
				Date createdDate = al2.getCreatedDate();
				int orgId = al2.getOrgId();
				int purchaseOrder_id = al2.getPurchaseOrderId();
				int updatedBy = al2.getUpdatedBy();
				Date updatedDate = al2.getUpdatedDate();
				int userId = al2.getUserId();

//	public Dispatch saveDispatch(Dispatch Dispatch) throws ClassNotFoundException, SQLException {
//
//		Dispatch dispatchIdss = DispatchRepo.save(Dispatch);
//		int dispatchId = dispatchIdss.getDispatchId();

		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpdb", "root", "root");

//		int srMstValide = Dispatch.getDispatchMasterId();
//
//		if (srMstValide == 0) {
//
//			int branch_id = Dispatch.getBranchId();
//			Date created_date = Dispatch.getCreatedDate();
//			int org_id = Dispatch.getOrgId();
//			int purchase_order_id = Dispatch.getPurchaseOrderId();
//			int updated_by = Dispatch.getUpdatedBy();
//			Date updated_date = Dispatch.getUpdatedDate();
//			int user_id = Dispatch.getUserId();

			String sql = "insert into  dispatch_master( branch_id, created_date,org_id, purchase_order_id, updated_by, updated_date, user_id) values(?,?,?,?,?,?,?)";

			PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, branchId);
			pst.setDate(2, createdDate);
			pst.setInt(3, orgId);
			pst.setInt(4, purchaseOrder_id);
			pst.setInt(5, updatedBy);
			pst.setDate(6, updatedDate);
			pst.setInt(7, userId);
			pst.executeUpdate();
			
			
			ResultSet rs = pst.getGeneratedKeys();
			int DispatchId = -1;
			if (rs.next()) {
				DispatchId = rs.getInt(1);
			}
			for (Dispatch al3 : Dispatch) {
				al3.setDispatchMasterId(DispatchId);
				existInqMst = DispatchId;
			}
		}

		System.out.println("Data inserted successfully...");
		return DispatchRepo.saveAll(Dispatch);
	}
	return Dispatch;
	}

//			ResultSet rs = ps.getGeneratedKeys();
//			int dispatchMasterId = -1;
//			if (rs.next()) {
//				dispatchMasterId = rs.getInt(1);
//			}
//
//			String sql1 = " update dispatch set dispatch_master_id= " + dispatchMasterId + " where dispatch_id="
//					+ dispatchId;
//
//			PreparedStatement ps1 = con.prepareStatement(sql1);
//
//			System.out.println(sql + "  " + sql1);
//			ps1.execute();
//		}
//
//		return Dispatch;
//	}

	public String getAllDispatch(Dispatch Dispatch) throws Exception {
		JSONArray result = new JSONArray();
		int orgId = Dispatch.getOrgId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpdb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery("SELECT * FROM  dispatch where org_id=" + orgId);

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

	public Dispatch updateDeleteDispatch(Dispatch Dispatch) throws ClassNotFoundException, SQLException {

		return DispatchRepo.save(Dispatch);
	}

	public Dispatch findDispatchById(int DispatchId) {
		return (Dispatch) DispatchRepo.findById(DispatchId).get();
	}

	public String deleteDispatchById(int DispatchId) {
		DispatchRepo.deleteById(DispatchId);
		return "deleted";
	}
}
