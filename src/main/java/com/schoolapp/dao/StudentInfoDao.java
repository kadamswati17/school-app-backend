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

import com.schoolapp.entity.StudentInfo;
import com.schoolapp.repository.StudentInfoRepo;

@Component
public class StudentInfoDao {

	@Autowired
	StudentInfoRepo studentInfoRepo;

	public StudentInfo saveStudentInfo(StudentInfo studentInfo) {

		return studentInfoRepo.save(studentInfo);
	}

	public String getAllStudentInfo(StudentInfo studentInfo) throws ClassNotFoundException, SQLException {

		JSONArray result = new JSONArray();
		int orgId = studentInfo.getOrgId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery(
				"SELECT student_info_id, current_address, father_name, father_occupation, home_contact, mobile_no, mother_name, mother_occupation, mothly_income, office_address, office_contact, permanent_address, branch_id, created_date, org_id, updated_by, updated_date, user_id, s_id FROM schooldb.student_info   where org_id="
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

	public StudentInfo findStudentInfoById(int StudentInfoID) {
		return studentInfoRepo.findById(StudentInfoID).get();
	}

	public String updateStudentInfo(StudentInfo studentInfo) throws SQLException, ClassNotFoundException {
		Integer studentId = studentInfo.getStudentInfoId();
		String current_address = studentInfo.getCurrentAddress();
		String father_name = studentInfo.getFatherName();
		String father_occupation = studentInfo.getFatherOccupation();
		int home_contact = studentInfo.getHomeContact();
		int mobile_no = studentInfo.getMobileNo();
		String mother_name = studentInfo.getMotherName();
		String mother_occupation = studentInfo.getMotherOccupation();
		int mothly_income = studentInfo.getMothlyIncome();
		String office_address = studentInfo.getOfficeAddress();
		int office_contact = studentInfo.getOfficeContact();
		String permanent_address = studentInfo.getPermanentAddress();

		System.out.println(current_address + father_name + father_occupation + home_contact + mobile_no + mother_name
				+ mother_occupation + mothly_income + office_address + office_contact + permanent_address + studentId);

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");

		String query = "update student_info set  current_address=?, father_name=?,  father_occupation=?, home_contact=?, mobile_no=?, "
				+ " mother_name=?, mother_occupation=?, mothly_income=?, office_address=?,   office_contact=?, permanent_address=? where student_info_id=?";

		System.out.println("---------------- " + query);

		PreparedStatement ps = con.prepareStatement(query);

		ps.setString(1, current_address);
		ps.setString(2, father_name);
		ps.setString(3, father_occupation);
		ps.setInt(4, home_contact);
		ps.setInt(5, mobile_no);
		ps.setString(6, mother_name);
		ps.setString(7, mother_occupation);
		ps.setInt(8, mothly_income);
		ps.setString(9, office_address);
		ps.setInt(10, office_contact);
		ps.setString(11, permanent_address);
		ps.setInt(12, studentId);

		ps.executeUpdate();

		System.out.println("Record updated successfully..!");
		return "Record updated..!";

	}

	public String deleteStudentInfoById(int studentInfoID) {
		studentInfoRepo.deleteById(studentInfoID);
		return "deleted";
	}
}
