package com.schoolapp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.schoolapp.entity.FeesStructure;
import com.schoolapp.repository.FeesStructureRepo;

@Component
public class FeesStructureDao {
	@Autowired
	FeesStructureRepo FeesStructureRepo;

	public List<FeesStructure> saveFeesStructure(List<FeesStructure> al) throws SQLException, ClassNotFoundException {

		List<FeesStructure> path = new ArrayList<>();
		ArrayList<FeesStructure> checkAl = new ArrayList<>();
		ArrayList<FeesStructure> newAl = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");

			for (FeesStructure fee : al) {
				int classId = fee.getClassId();
				int financeYear = fee.getFinanceYear();

				String sql = "SELECT * FROM schooldb.fees_structure WHERE class_id = ? AND finance_year = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, classId);
				ps.setInt(2, financeYear);

				ResultSet rs = ps.executeQuery();

				boolean duplicateFound = false;

				while (rs.next()) {
					FeesStructure fees = new FeesStructure();

					fees.setClassId(rs.getInt("class_id"));
					fees.setFinanceYear(rs.getInt("finance_year"));
					fees.setReasourceId(rs.getInt("reasource_id"));
					checkAl.add(fees);

					if (fees.getClassId() == fee.getClassId() && fees.getFinanceYear() == fee.getFinanceYear()
							&& fees.getReasourceId() == fee.getReasourceId()) {
						duplicateFound = true;
						break;
					}
				}

				if (!duplicateFound) {
					newAl.add(fee);
				} else {
					System.out.println("Duplicate found");
				}

				rs.close();
				ps.close();
			}

			if (!newAl.isEmpty()) {
				path = (List<FeesStructure>) FeesStructureRepo.saveAll(newAl);
			}

			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return path;

	}

	public String getAllFeesStructure(FeesStructure FeesStructure) throws SQLException, ClassNotFoundException {

		JSONArray result = new JSONArray();

		int orgId = FeesStructure.getOrgId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery(
				" SELECT cm.class_name,rm.reasource_name,f.fees_structure_id, f.branch_id, f.charges, f.class_id, f.created_date, f.finance_year, f.is_active, f.org_id, f.reasource_id, f.tr_date, f.updated_by, \r\n"
						+ "f.updated_date, f.user_id FROM  fees_structure f\r\n"
						+ "inner join class_master cm on f.class_id=cm.class_id\r\n"
						+ "inner join reasource_master rm on f.reasource_id=rm.reasource_id where f.org_id=" + orgId);

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

	public FeesStructure findFeesStructureById(int FeesStructureId) {
		return FeesStructureRepo.findById(FeesStructureId).get();
	}

	public String deleteFeesStructureById(int FeesStructureId) {
		FeesStructureRepo.deleteById(FeesStructureId);
		return "deleted";
	}
}
