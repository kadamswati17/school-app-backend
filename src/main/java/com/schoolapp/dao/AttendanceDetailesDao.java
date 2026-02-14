package com.schoolapp.dao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

import com.schoolapp.entity.AttendanceDetailes;

@Component
public class AttendanceDetailesDao {
	@Autowired
	com.schoolapp.repository.AttendanceDetailesRepo AttendanceDetailesRepo;

	public ArrayList<AttendanceDetailes> saveAttendanceDetailes(ArrayList<AttendanceDetailes> attendance)
			throws ClassNotFoundException, SQLException {

		ArrayList<AttendanceDetailes> path = null;
		for (AttendanceDetailes fee : attendance) {

			int sId = fee.getsId();
			int subId = fee.getSubjectId();
			int teaId = fee.getTeacherId();
			int year = fee.getYear();
			String month = fee.getMonth();

			String columnName = "d" + teaId;

			int id = 0;
			String prefix = "d";
			for (int i = 1; i <= teaId; i++) {
				if (columnName.equals(prefix + i)) {
					switch (i) {
					case 1 -> id = fee.getD1();
					case 2 -> id = fee.getD2();
					case 3 -> id = fee.getD3();
					case 4 -> id = fee.getD4();
					case 5 -> id = fee.getD5();
					default -> id = 0;
					}
					break;
				}
			}
			System.out.println("===" + id);

			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String query = null;
			int cnt = 0;
			int attendanceId = 0;

			for (int i = 1; i <= teaId; i++) {

				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");
				query = "SELECT count(1) as cnt,attendance_id FROM  attendance_detailes  where s_id=? and subject_id=? and year=? and month=? group by attendance_id";
				ps = con.prepareStatement(query);
				ps.setInt(1, sId);
				ps.setInt(2, subId);
				ps.setInt(3, year);
				ps.setString(4, month);

				rs = ps.executeQuery();

				if (rs.next()) {
					cnt = rs.getInt("cnt");
					attendanceId = rs.getInt("attendance_id");
				}
				if (cnt == 0) {
					path = (ArrayList<AttendanceDetailes>) AttendanceDetailesRepo.saveAll(attendance);
					System.out.println("Attendance Saved..!");

				} else {

					String sql3 = "UPDATE attendance_detailes SET " + columnName + "=" + id + " WHERE attendance_id ="
							+ attendanceId;
					PreparedStatement ps3 = con.prepareStatement(sql3);
					ps3.executeUpdate();
					System.out.println(sql3);
					System.out.println("updated");

				}
			}
		}
		return path;

	}

	public String getAllAttendanceDetailes(AttendanceDetailes AttendanceDetailes) throws Exception {

		JSONArray result = new JSONArray();
		int orgId = AttendanceDetailes.getOrgId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery(
				"SELECT concat(ad.first_name,' ',ad.middle_name,' ',ad.last_name) as name, atd.attendance_id, atd.class_id, atd.d1, atd.div_id, atd.month, atd.s_id, atd.subject_id, atd.teacher_id, atd.time, atd.year, atd.branch_id, atd.created_date, atd.\r\n"
						+ "d10, atd.d11, atd.d12, atd.d13, atd.d14, atd.d15, atd.d16, atd.d17, atd.d18, atd.d19, atd.d2, atd.d20, atd.d21, atd.d22, atd.d23, atd.d24, atd.d25, atd.d26, atd.d27, atd.d28, atd.d29, atd.d3, atd.d30, atd.d31, atd.d4,\r\n"
						+ " d5, atd.d6, atd.d7, atd.d8, atd.d9, atd.is_active, atd.org_id, atd.updated_by, atd.\r\n"
						+ "updated_date, atd.user_id FROM  attendance_detailes atd \r\n"
						+ "inner join admission ad on atd.s_id=ad.admission_id where atd.org_id=" + orgId);

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

	public AttendanceDetailes updateDeleteAttendanceDetailes(AttendanceDetailes AttendanceDetailes)
			throws ClassNotFoundException, SQLException {

		Integer AttendanceDetailesId = AttendanceDetailes.getAttendanceId();
		int userId = AttendanceDetailes.getUserId();
		int updatedBy = AttendanceDetailes.getUpdatedBy();
		Date updatedDate = (Date) AttendanceDetailes.getUpdatedDate();
		int branchId = AttendanceDetailes.getBranchId();
		int orgId = AttendanceDetailes.getOrgId();
		int isActive = AttendanceDetailes.getIsActive();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmdb", "root", "root");
		String query = "update area_master set is_active=?, updated_by=?,updated_date=? "
				+ "where area_master_id=? and org_id=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, isActive);
		ps.setInt(2, updatedBy);
		ps.setDate(3, updatedDate);
		ps.setInt(4, AttendanceDetailesId);
		ps.setInt(5, orgId);
		ps.executeUpdate();
		System.out.println("Record updated");
		return AttendanceDetailesRepo.save(AttendanceDetailes);
	}

	public AttendanceDetailes findAttendanceDetailesById(int AttendanceDetailesId) {
		return (AttendanceDetailes) AttendanceDetailesRepo.findById(AttendanceDetailesId).get();
	}

	public String deleteAttendanceDetailesById(int AttendanceDetailesId) {
		AttendanceDetailesRepo.deleteById(AttendanceDetailesId);
		return "deleted";
	}
}
