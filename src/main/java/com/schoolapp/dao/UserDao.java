package com.schoolapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import com.schoolapp.entity.UserEntity;
import com.schoolapp.repository.UserRepository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.schoolapp.entity.AccessPermission;
import com.schoolapp.entity.LeadAccounts;
import com.schoolapp.entity.Unit;
import com.schoolapp.entity.User;
import com.schoolapp.repository.UserRepo;

@Component
public class UserDao {

	@Autowired
	UserRepo userRepo;
	// ✅ ADD THIS
    @Autowired
    private UserRepository userEntityRepo;
	public User saveUser(User user) throws ClassNotFoundException, SQLException {
		System.out.println("Data inserted successfully...");
		return userRepo.save(user);
	}
	
	public String getAllUser(User users) throws SQLException, ClassNotFoundException {
		JSONArray result = new JSONArray();
		int orgId = users.getOrgId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpdb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery("SELECT * FROM  user where org_id=" + orgId);

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

	public AccessPermission userValidation(User users, AccessPermission accessPermission)
			throws ClassNotFoundException, SQLException {

		String email = users.getEmail();
		String pass = users.getPassword();

		int userId = users.getuId();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpdb", "root", "root");
			if (userId > 0) {

				query = "SELECT u.u_id,u.user_name,u.email,ap.access_create,ap.access_read,ap.access_delete,ap.access_update,u.user_sr_no,u.branch_id,u.org_id\r\n"
						+ " FROM access_permission ap \r\n" + "inner join user u on ap.access_user_id=u.u_id\r\n"
						+ "where u.is_active=1 and u.user_id=?";
				ps = con.prepareStatement(query);
				ps.setInt(1, userId);
				rs = ps.executeQuery();
				while (rs.next()) {
					accessPermission.setAccessCreate(rs.getInt("access_create"));
					accessPermission.setAccessRead(rs.getInt("access_read"));
					accessPermission.setAccessDelete(rs.getInt("access_delete"));
					accessPermission.setAccessUpdate(rs.getInt("access_update"));

					users.setEmail(rs.getString("email"));
					users.setuId(rs.getInt("u_id"));
					users.setUserSrNo(rs.getInt("user_sr_no"));
					users.setUserName(rs.getString("user_name"));
					users.setBranchId(rs.getInt("branch_id"));
					users.setOrgId(rs.getInt("org_id"));
				}
				System.out.println("Valid Userrrr");

			} else {
				System.out.println("inside " + email);
				query = "SELECT u.u_id,u.user_name,u.email,ap.access_create,ap.access_read,ap.access_delete,ap.access_update,u.user_sr_no,u.branch_id,u.org_id\r\n"
						+ "										 FROM  access_permission ap inner join user u on ap.access_user_id=u.u_id \r\n"
						+ "									where email=? and password=?";
				ps = con.prepareStatement(query);
				ps.setString(1, email);
				ps.setString(2, pass);
				rs = ps.executeQuery();
				while (rs.next()) {
					String dbEmail = rs.getString("email");
					String dbPass = rs.getString("password");

					if (email.equals(dbEmail) && pass.equals(dbPass)) {

						accessPermission.setAccessCreate(rs.getInt("access_create"));
						accessPermission.setAccessRead(rs.getInt("access_read"));
						accessPermission.setAccessDelete(rs.getInt("access_delete"));
						accessPermission.setAccessUpdate(rs.getInt("access_update"));

						users.setEmail(rs.getString("email"));
						users.setuId(rs.getInt("u_id"));
						users.setUserSrNo(rs.getInt("user_sr_no"));
						users.setUserName(rs.getString("user_name"));
						users.setBranchId(rs.getInt("branch_id"));
						users.setOrgId(rs.getInt("org_id"));
					} else {
						System.out.println("Not Valid User");
					}
				}

			}
		} finally {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (con != null)
				con.close();
		}
		return accessPermission;
	}

	public String valideUserDetailes(User users) throws ClassNotFoundException, SQLException {
		List<Object> dataList = new ArrayList<>();
		String email = users.getEmail();
		String pass = users.getPassword();

		Class.forName("com.mysql.jdbc.Driver");
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpdb", "root", "root");
				Statement st = con.createStatement();) {
			String query = "SELECT * FROM  user where email=? and password=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();

			while (rs.next()) {
				for (int i = 1; i <= columnCount; i++) {

//					String fieldName = metaData.getColumnLabel(i);
					String[] words = metaData.getColumnLabel(i).split("[ _]");
					StringBuilder camelCaseFieldName = new StringBuilder(words[0]);
					for (int j = 1; j < words.length; j++) {
						camelCaseFieldName.append(words[j].substring(0, 1).toUpperCase()).append(words[j].substring(1));
					}
					String fieldName = camelCaseFieldName.toString();

					Object value = rs.getObject(i);
//					dataList.add(fieldName + ": " + value);
					if (value instanceof String || value instanceof Date) {
						dataList.add("\"" + fieldName + "\"" + ": \"" + value + "\"");

					} else {
						dataList.add("\"" + fieldName + "\" " + ": " + value);
					}
				}
			}
		}
		int count = 0;
		StringBuilder jsonBuilder = new StringBuilder("[{\n");
		for (int i = 0; i < dataList.size(); i++) {
			jsonBuilder.append("\t").append(dataList.get(i));

			count++;
			if (i < dataList.size() - 1) {

				if (count != 26) {

					jsonBuilder.append(",\n");
				}
			}
			if (count == 26) {
				jsonBuilder.append("\n},");
				count++;
				if (count >= 27) {
					jsonBuilder.append("\n{");
				}
				count = 0;

			}
		}
		jsonBuilder.append("\n}]");
		int cnt = jsonBuilder.length() - 1;
		jsonBuilder.delete(cnt - 5, cnt);
		return jsonBuilder.toString();
	}

	public String updateUser(User user) throws SQLException, ClassNotFoundException {

		Integer uId = user.getUserId();

		int userSrNo = user.getUserSrNo();
		String userName = user.getUserName();
		int branchId = user.getBranchId();
		int orgId = user.getOrgId();
		Date date = user.getDate();
		String userContact = user.getUserContact();
		String panNo = user.getPanNo();
		String gstNo = user.getGstNo();
		String email = user.getEmail();
		String password = user.getPassword();
		String phone = user.getPhone();
		String uAddress = user.getuAddress();
		int income = user.getIncome();
		String incomeSource = user.getIncomeSource();
		int otherIncome = user.getOtherIncome();
		String otherIncomeSource = user.getOtherIncomeSource();
		String notes = user.getNotes();
		int isActive = user.getIsActive();
		int stateId = user.getStateId();
		int distId = user.getDistId();
		int cityId = user.getCityId();
		int userId = user.getUserId();
		Date createdDate = user.getCreatedDate();
		int updatedBy = user.getUserId();
		Date updatedDate = user.getUpdatedDate();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpdb", "root", "root");
		String query = "update user set u_id = ? , branch_id = ? , city_id = ? , created_date = ? , date = ? , dist_id = ? , email = ? , "
				+ "gst_no = ? , income = ? , income_source = ? , is_active = ? , notes = ? ,  other_income = ? , "
				+ "other_income_source = ? , pan_no = ? , phone = ? , state_id = ? , u_address = ? , updated_by = ? , updated_date = ? , "
				+ "user_contact = ? , user_id = ? , user_name = ? , user_sr_no = ? , password = ?"
				+ " where u_id= ? and org_id = ?";

		PreparedStatement ps = con.prepareStatement(query);

		ps.setInt(1, uId);
		ps.setInt(2, branchId);
		ps.setInt(3, cityId);
		ps.setDate(4, createdDate);
		ps.setDate(5, date);
		ps.setInt(6, distId);
		ps.setString(7, email);
		ps.setString(8, gstNo);
		ps.setInt(9, income);
		ps.setString(10, incomeSource);
		ps.setInt(11, isActive);
		ps.setString(12, notes);
		ps.setInt(13, otherIncome);
		ps.setString(14, otherIncomeSource);
		ps.setString(15, panNo);
		ps.setString(16, phone);
		ps.setInt(17, stateId);
		ps.setString(18, uAddress);
		ps.setInt(19, updatedBy);
		ps.setDate(20, updatedDate);
		ps.setString(21, userContact);
		ps.setInt(22, userId);
		ps.setString(23, userName);
		ps.setInt(24, userSrNo);
		ps.setString(25, password);
		ps.setInt(26, uId);
		ps.setInt(27, orgId);
		ps.executeUpdate();

		System.out.println("Record updated successfully..!");
		return "Record updated..!";

	}

	public String updateDeleteUser(User user) throws ClassNotFoundException, SQLException {
		Integer userId = user.getUserId();
//		Contractor accounts = contractorDao.findContractorById(contractor.getContractorId());

		int updatedBy = user.getUpdatedBy();
		Date updatedDate = user.getUpdatedDate();
		int branchId = user.getBranchId();
		int orgId = user.getOrgId();
		int isActive = user.getIsActive();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpdb", "root", "root");
		String query = "update user set is_active=?, updated_by=?,updated_date=? " + "where u_id=? and org_id=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, isActive);
		ps.setInt(2, updatedBy);
		ps.setDate(3, (java.sql.Date) updatedDate);
		ps.setInt(4, userId);
		ps.setInt(5, orgId);
		ps.executeUpdate();
		System.out.println("Record updated");
		return "Record updated..!";
	}

	public User findUserById(int UserId) {
		return userRepo.findById(UserId).get();
	}

	public String deleteUserById(int UserId) {
		userRepo.deleteById(UserId);
		return "deleted";
	}
	public com.schoolapp.entity.UserEntity saveUser(com.schoolapp.entity.UserEntity userEntity) {
	    return userEntityRepo.save(userEntity);
	}
}
