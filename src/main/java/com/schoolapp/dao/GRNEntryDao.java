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

import com.schoolapp.entity.GRNEntry;
import com.schoolapp.entity.SalesOrder;
import com.schoolapp.repository.GRNEntryRepo;

@Component
public class GRNEntryDao {
	@Autowired
	GRNEntryRepo GRNEntryRepo;
	
	int existInqMst = 0;

	public List<GRNEntry> saveGRNEntry(List<GRNEntry> GRNEntry) throws ClassNotFoundException, SQLException {

		for (GRNEntry al2 : GRNEntry) {

			int srValide = al2.getGRNEntryMasterId();

			if (srValide == 0) {

				int branchId = al2.getBranchId();
				Date createdDate = al2.getCreatedDate();
				int orgId = al2.getOrgId();
				int purchaseOrder_id = al2.getGrnentryId();
				int updatedBy = al2.getUpdatedBy();
				Date updatedDate = al2.getUpdatedDate();
				int userId = al2.getUserId();
				
				

//	public GRNEntry saveGRNEntry(GRNEntry GRNEntry) throws ClassNotFoundException, SQLException {
//
//		GRNEntry grnIdss = GRNEntryRepo.save(GRNEntry);
//		int grnId = grnIdss.getGRNEntryId();

		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpdb", "root", "root");

//		int srMstValide = GRNEntry.getGRNEntryMasterId();
//
//		if (srMstValide == 0) {
//
//			int branch_id = GRNEntry.getBranchId();
//			Date created_date = GRNEntry.getCreatedDate();
//			int org_id = GRNEntry.getOrgId();
//			int purchase_order_id = GRNEntry.getPurchaseOrderId();
//			int updated_by = GRNEntry.getUpdatedBy();
//			Date updated_date = GRNEntry.getUpdatedDate();
//			int user_id = GRNEntry.getUserId();

			String sql = "insert into  grnentry_master( branch_id, created_date,org_id, purchase_order_id, updated_by, updated_date, user_id) values(?,?,?,?,?,?,?)";

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
			
			
			
			int GRNEntryId = -1;
			if (rs.next()) {
				GRNEntryId = rs.getInt(1);
			}
			for (GRNEntry al3 : GRNEntry) {
				System.out.println("HI");
				al3.setGRNEntryMasterId(GRNEntryId);
				existInqMst = GRNEntryId;
			}
		}

		System.out.println("Data inserted successfully...");
		return GRNEntryRepo.saveAll(GRNEntry);
	}
	return GRNEntry;
}

//			ResultSet rs = ps.getGeneratedKeys();
//			int grnentryMasterId = -1;
//			if (rs.next()) {
//				grnentryMasterId = rs.getInt(1);
//			}
//
//			String sql1 = " update grnentry set grnentry_master_id= " + grnentryMasterId + " where grnentry_id="
//					+ grnId;
//
//			PreparedStatement ps1 = con.prepareStatement(sql1);
//
//			System.out.println(sql + "  " + sql1);
//			ps1.execute();
//		}
//
//		return GRNEntry;
//	}

	public String getAllGRNEntry(GRNEntry GRNEntry) throws Exception {
		JSONArray result = new JSONArray();
		int orgId = GRNEntry.getOrgId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpdb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery("SELECT * FROM  grnentry where org_id=" + orgId);

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

	public GRNEntry updateDeleteGRNEntry(GRNEntry GRNEntry) throws ClassNotFoundException, SQLException {

		return GRNEntryRepo.save(GRNEntry);
	}

	public GRNEntry findGRNEntryById(int GRNEntryId) {
		return (GRNEntry) GRNEntryRepo.findById(GRNEntryId).get();
	}

	public String deleteGRNEntryById(int GRNEntryId) {
		GRNEntryRepo.deleteById(GRNEntryId);
		return "deleted";
	}
}
