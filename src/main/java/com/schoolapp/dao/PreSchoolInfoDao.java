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

import com.schoolapp.entity.PreSchoolInfo;
import com.schoolapp.repository.PreSchoolInfoRepo;

@Component
public class PreSchoolInfoDao {
	@Autowired
	PreSchoolInfoRepo preSchoolInfoRepo;

	public PreSchoolInfo savePreSchoolInfo(PreSchoolInfo preSchoolInfo) {

		return preSchoolInfoRepo.save(preSchoolInfo);
	}

	public String getAllPreSchoolInfo(PreSchoolInfo preSchoolInfo) throws ClassNotFoundException, SQLException {

		JSONArray result = new JSONArray();

		int orgId = preSchoolInfo.getOrgId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery(
				"SELECT pre_school_info_id, admission_std, date_of_admission, division, last_year_result, name_of_previous_school, school_id, std_of_previous_school,  branch_id, created_date, org_id, updated_by, updated_date, user_id, s_id FROM schooldb.pre_school_info where org_id="
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

	public String updatePreSchoolInfo(PreSchoolInfo preSchoolInfo) throws SQLException, ClassNotFoundException {
		Integer srNo = preSchoolInfo.getPreSchoolInfoId();
		int admission_std = preSchoolInfo.getAdmissionStd();
		Date date_of_admission = preSchoolInfo.getDateOfAdmission();
		int division = preSchoolInfo.getDivision();
		String last_year_result = preSchoolInfo.getLastYearResult();
		String name_of_previous_school = preSchoolInfo.getNameOfPreviousSchool();
		int school_id = preSchoolInfo.getSchoolId();
		int std_of_previous_school = preSchoolInfo.getStdOfPreviousSchool();
		int student_id = preSchoolInfo.getSchoolId();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");
		String query = "update pre_school_info set  admission_std=?, date_of_admission=?,  division=?, last_year_result=?, name_of_previous_school=?, "
				+ " school_id=?, std_of_previous_school=? where pre_school_info_id=?";
		PreparedStatement ps = con.prepareStatement(query);

		ps.setInt(1, admission_std);
		ps.setDate(2, date_of_admission);
		ps.setInt(3, division);
		ps.setString(4, last_year_result);
		ps.setString(5, name_of_previous_school);
		ps.setInt(6, school_id);
		ps.setInt(7, std_of_previous_school); 
		ps.setInt(8, srNo);
		ps.executeUpdate();

		System.out.println("Record updated successfully..!");
		return "Record updated..!";

	}

	public PreSchoolInfo findPreSchoolInfoById(int preSchoolInfoID) {
		return preSchoolInfoRepo.findById(preSchoolInfoID).get();
	}

	public String deletePreSchoolInfoById(int preSchoolInfoID) {
		preSchoolInfoRepo.deleteById(preSchoolInfoID);
		;
		return "deleted";
	}

}
