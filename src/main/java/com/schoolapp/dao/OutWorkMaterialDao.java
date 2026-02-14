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


import com.schoolapp.entity.OutWorkMaterial;
import com.schoolapp.repository.OutWorkMaterialRepo;

@Component
public class OutWorkMaterialDao {

	@Autowired
	OutWorkMaterialRepo OutWorkMaterialRepo;
	
	int existInqMst = 0;

	public List<OutWorkMaterial> saveOutWork(List<OutWorkMaterial> OutWork) throws ClassNotFoundException, SQLException {

		for (OutWorkMaterial al2 : OutWork) {

			int srValide = al2.getOutWorkMaterialId();

			if (srValide == 0) {

				int branchId = al2.getBranchId();
				Date createdDate = al2.getCreatedDate();
				int orgId = al2.getOrgId();
				int purchaseOrder_id = al2.getPurchaseOrderId();
				int updatedBy = al2.getUpdatedBy();
				Date updatedDate = al2.getUpdatedDate();
				int userId = al2.getUserId();
				

//	public OutWorkMaterial saveOutWorkMaterial(OutWorkMaterial OutWorkMaterial) throws ClassNotFoundException, SQLException {
//
//		OutWorkMaterial outworkIdss = OutWorkMaterialRepo.save(OutWorkMaterial);
//		int outworkId = outworkIdss.getOutWorkMaterialId();

		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpdb", "root", "root");

//		int srMstValide = OutWorkMaterial.getOutWorkMaterialMasterId();
//
//		if (srMstValide == 0) {
//
//			int branch_id = OutWorkMaterial.getBranchId();
//			Date created_date = OutWorkMaterial.getCreatedDate();
//			int org_id = OutWorkMaterial.getOrgId();
//			int purchase_order_id = OutWorkMaterial.getPurchaseOrderId();
//			int updated_by = OutWorkMaterial.getUpdatedBy();
//			Date updated_date = OutWorkMaterial.getUpdatedDate();
//			int user_id = OutWorkMaterial.getUserId();

			String sql = "insert into  out_work_material_master( branch_id, created_date,org_id, purchase_order_id, updated_by, updated_date, user_id) values(?,?,?,?,?,?,?)";

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
			int OutWorkId = -1;
			if (rs.next()) {
				OutWorkId = rs.getInt(1);
			}
			for (OutWorkMaterial al3 : OutWork) {
				al3.setOutWorkMaterialId(OutWorkId);
				existInqMst = OutWorkId;
			}
		}

		System.out.println("Data inserted successfully...");
		return OutWorkMaterialRepo.saveAll(OutWork);
	}
	return OutWork;
	}

//			ResultSet rs = ps.getGeneratedKeys();
//			int outWorkMaterialMasterId = -1;
//			if (rs.next()) {
//				outWorkMaterialMasterId = rs.getInt(1);
//			}
//
//			String sql1 = " update out_work_material set out_work_material_master_id= " + outWorkMaterialMasterId + " where out_work_material_id="
//					+ outworkId;
//
//			PreparedStatement ps1 = con.prepareStatement(sql1);
//
//			System.out.println(sql + "  " + sql1);
//			ps1.execute();
//		}
//
//		return OutWorkMaterial;
//	}

	public String getAllOutWorkMaterial(OutWorkMaterial OutWorkMaterial) throws Exception {
		JSONArray result = new JSONArray();
		int orgId = OutWorkMaterial.getOrgId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpdb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery("SELECT * FROM  out_work_material where org_id=" + orgId);

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

	public OutWorkMaterial updateDeleteOutWorkMaterial(OutWorkMaterial OutWorkMaterial) throws ClassNotFoundException, SQLException {

		return OutWorkMaterialRepo.save(OutWorkMaterial);
	}

	public OutWorkMaterial findOutWorkMaterialById(int OutWorkMaterialId) {
		return (OutWorkMaterial) OutWorkMaterialRepo.findById(OutWorkMaterialId).get();
	}

	public String deleteOutWorkMaterialById(int OutWorkMaterialId) {
		OutWorkMaterialRepo.deleteById(OutWorkMaterialId);
		return "deleted";
	}
	
}
