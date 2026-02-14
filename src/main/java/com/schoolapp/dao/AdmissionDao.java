package com.schoolapp.dao;

import java.io.ByteArrayInputStream;
import java.io.IOException;
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

import org.hibernate.SessionFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.schoolapp.entity.Admission;
import com.schoolapp.repository.AdmissionRepo;

@Component
public class AdmissionDao {

	@Autowired
	AdmissionRepo admissionRepo;

	int sId = 1;

	public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file)
			throws SQLException, ClassNotFoundException {

		int admId = sId;
		try {
			byte[] imageData = file.getBytes();
			saveImageDataToDatabase(imageData, admId);
			return ResponseEntity.ok().body("Image uploaded successfully.");
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading image");
		}
	}

	public Object saveAdmission(Admission al) throws SQLException, ClassNotFoundException {
		Admission id = admissionRepo.save(al);
		sId = id.getAdmissionId();
		int pickUpId = id.getPickUpPoint();
		int classId = id.getClassId();
		Date created_date = null;
		int is_active = 1;
		Date tr_date = null;
		int user_id = 0;
		int branch_id = 0;
		int org_id = 0;
		int rte = 0;

		created_date = al.getCreatedDate();
		tr_date = al.getCreatedDate();

		user_id = al.getUserId();
		branch_id = al.getBranchId();
		org_id = al.getOrgId();
		rte = al.getRte();

		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");

		String sql = "insert into std_annual_fees(s_id,fees_structure_id, reasource_id,class_id, charges,\r\n"
				+ "finance_year,created_date,is_active,tr_date ,user_id ,branch_id, org_id,updated_by,updated_date)\r\n"
				+ " SELECT  ad.admission_id, fs.fees_structure_id, fs.reasource_id, ad.class_id, fs.charges, fs.finance_year , ad.created_date\r\n"
				+ ", fs.is_active  , ad.created_date , ad.user_id , ad.branch_id , ad.org_id\r\n"
				+ ",ad.updated_by,ad.updated_date	 \r\n" + "FROM admission ad\r\n"
				+ "left join fees_structure fs  on fs.org_id=ad.org_id and fs.class_id=ad.class_id\r\n"
				+ "where ad.class_id=" + classId + " and ad.admission_id=" + sId + "  and fs.org_id=" + org_id;

		PreparedStatement ps = con.prepareStatement(sql);
		ps.execute();
		System.out.println("after std-- " + sql);
		System.out.println("before info");
		String sql1 = "insert into student_info(s_id,branch_id, created_date, current_address, father_name, father_occupation, home_contact, mobile_no, \r\n"
				+ " mother_name, mother_occupation, mothly_income, office_address, office_contact, org_id, permanent_address,updated_by, updated_date, user_id)\r\n"
				+ " SELECT admission_id,branch_id, created_date, '', middle_name, '', 0, 0, \r\n"
				+ "'', '', 0, '', 0, org_id, '', 0, updated_date, user_id FROM  admission  \r\n"
				+ "where admission_id =" + sId + "";

		PreparedStatement ps1 = con.prepareStatement(sql1);
		ps1.execute();
		System.out.println("after info--- " + sql1);
		String sql2 = "insert into pre_school_info(admission_std, branch_id, created_date, date_of_admission, division, last_year_result,  name_of_previous_school, \r\n"
				+ "org_id, school_id, std_of_previous_school, updated_by, updated_date, user_id, s_id) \r\n"
				+ "SELECT admission_id, branch_id, created_date,created_date, 0, '', '', \r\n"
				+ "org_id, 0, 0,0, updated_date, user_id,admission_id "
				+ " FROM schooldb.admission  where admission_id =" + sId + "";

		PreparedStatement ps2 = con.prepareStatement(sql2);
		ps2.execute();

		String sql3 = "SELECT bus_charges FROM  bus_management where bus_management_id=" + pickUpId;
		PreparedStatement ps3 = con.prepareStatement(sql3);

		ResultSet rs3 = ps3.executeQuery();
		int busCharges = 0;
		int stdAnlFId = 0;
		int finYear = 0;

		if (rs3.next()) {
			busCharges = rs3.getInt("bus_charges");
		}

		String sql4 = "SELECT sf.finance_year, sf.std_annual_fees_id, rm.reasource_id FROM reasource_master rm \r\n"
				+ "inner join std_annual_fees sf on rm.org_id=sf.org_id and rm.reasource_id=sf.reasource_id \r\n"
				+ "where rm.reasource_name='Bus Fees' and rm.org_id=" + org_id + " and sf.s_id=" + sId;

		PreparedStatement ps4 = con.prepareStatement(sql4);
		ResultSet rs4 = ps4.executeQuery();
		int resId = 0;
		if (rs4.next()) {
			finYear = rs4.getInt("finance_year");
			stdAnlFId = rs4.getInt("std_annual_fees_id");
			resId = rs4.getInt("reasource_id");
		}

		if (pickUpId > 0) {

			String sql5 = " update std_annual_fees set charges=" + busCharges + "  where reasource_id=" + resId
					+ " and finance_year=" + finYear + " and s_id=" + sId + " and std_annual_fees_id=" + stdAnlFId;

			PreparedStatement ps5 = con.prepareStatement(sql5);
			ps5.executeUpdate();
		}

		con.close();
		return al;
	}

	private String saveImageDataToDatabase(byte[] imageData, int admId) throws ClassNotFoundException, SQLException {

		int admissionId = admId;

		System.out.println("s idd : " + admissionId);
		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");
		System.out.println("before update");
		String sql = "update admission set image_data=? where admission_id=?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setBinaryStream(1, new ByteArrayInputStream(imageData));
		ps.setInt(2, admissionId);
		ps.execute();

		return "done";
	}

	public String getAllAdmission(Admission admission) throws ClassNotFoundException, SQLException {

		JSONArray result = new JSONArray();
		int orgId = admission.getOrgId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery(
				"SELECT  tcm.tc_std_name,tcm.taluka_name,tcm.dist_name,org.owner_contact,dist.dist_name,org.reg_id, c.city_name,  tcm.conduct,tcm.date_of_leaving,tcm.reason_of_leaving, tcm.remark, org.org_name,\r\n"
						+ "org.invoice_address,org.reg_id,org.u_disk_id, cm.class_name,sti.current_address,  psi.name_of_previous_school,\r\n"
						+ "ifnull(cs.cast_name,\" \") as cast_name ,ifnull(scs.sub_cast_name,\" \") as sub_cast_name,\r\n"
						+ "ct.category_name, ad. admission_id, ad.age, ad.birth_place, ad.branch_id, ad.bus, ad.cast, \r\n"
						+ "ad.category, ad.class_id, ad.created_date, ad.dob , ad.first_name, ad.gender, ad.last_name, ad.middle_name, ad.mother_tongue, \r\n"
						+ "ad.nationality,ad.mother_name,  ad.org_id, ad.religion, ad.sub_cast, ad.teacher_relative, ad.updated_by, ad.updated_date, ad.user_id, \r\n"
						+ "ad.class_standard, ad.grno, ad.adhar_no, ad.pick_up_point, ad.reg_id, \r\n"
						+ "ad.std_saral_portal_id, ad.u_disk_id, ad.rte, ad.mobile_no1, ad.mobile_no2  \r\n"
						+ "FROM  admission  ad  left join cast cs on ad.cast=cs.cast_id \r\n"
						+ "left join pre_school_info psi on ad.admission_id=psi.s_id\r\n"
						+ "left join sub_cast scs on ad.sub_cast=scs.sub_cast_id  \r\n"
						+ "left join student_info sti on ad.admission_id=sti.s_id\r\n"
						+ "left join category ct on ad.category=ct.category_id   \r\n"
						+ "left join class_master cm on ad.class_id=cm.class_id left join tc_master tcm on ad.admission_id=tcm.tc_std_name \r\n"
						+ "inner join organization org on ad.org_id=org.org_id  left join district dist on org.dist_id=dist.dist_id left join city c on org.city_id=c.city_id  where  ad.org_id="
						+ orgId +" order by ad.admission_id desc");

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

	public String getAllStudentClassWise(Admission admission) throws ClassNotFoundException, SQLException {

		JSONArray result = new JSONArray();
		int orgId = admission.getOrgId();
		int classId = admission.getClassId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery(
				"SELECT  admission_id, age, birth_place, branch_id, bus, cast, category, class_id, created_date, dob, first_name, gender, last_name, middle_name, \r\n"
						+ "						 mother_tongue, nationality, org_id, religion, sub_cast, teacher_relative, updated_by, updated_date, user_id  \r\n"
						+ "						 FROM  admission  \r\n" + "						 where class_id="
						+ classId + " and org_id=" + orgId);

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

	public String getPdfBonafied(Admission admission) throws ClassNotFoundException, SQLException {

		JSONArray result = new JSONArray();
		int orgId = admission.getOrgId();
		int sId = admission.getAdmissionId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery(
				"SELECT org.invoice_address,cm.class_name,ad.admission_id ,org.org_name,DATE_FORMAT(ad.dob,'%d/%m/%Y') as dob,sf.finance_year,DATE_FORMAT(ad.created_date,'%d/%m/%Y') as admission_date\r\n"
						+ ",  concat(ad.first_name,' ',ad.middle_name,' ', ad.last_name)as name,concat(ad.middle_name,\" \",ad.last_name) as father_name,ad.class_standard\r\n"
						+ "FROM  admission ad \r\n" + "inner join organization org on ad.org_id=org.org_id \r\n"
						+ "inner join class_master cm on ad.class_id=cm.class_id\r\n"
						+ "left join std_annual_fees sf on ad.admission_id=sf.s_id\r\n" + "where ad.admission_id=" + sId
						+ " and ad.org_id=" + orgId + "\r\n"
						+ "group by org.invoice_address,cm.class_name,ad.admission_id ,org.org_name,ad.dob,sf.finance_year,ad.created_date\r\n"
						+ "");

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

	public Admission findAdmissionById(int admissionID) {
		return admissionRepo.findById(admissionID).get();
	}

	public String updateAdmission(Admission admission) throws SQLException, ClassNotFoundException {
		int admissionId = admission.getAdmissionId();
		int age = admission.getAge();
		String birth_place = admission.getBirthPlace();
		String bus = admission.getBus();
		int cast = admission.getCast();
		int category = admission.getCategory();
		Date dob = admission.getDob();
		String first_name = admission.getFirstName();
		String gender = admission.getGender();
		String last_name = admission.getLastName();
		String middle_name = admission.getMiddleName();
		String mother_tongue = admission.getMotherTongue();
		String nationality = admission.getNationality();
		String religion = admission.getReligion();
		int sub_cast = admission.getSubCast();
		String teacher_relative = admission.getTeacherRelative();
		String mobileNo1 = admission.getMobileNo1();
		String mobileNo2 = admission.getMobileNo2();
		String adharNo = admission.getAdharNo();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schooldb", "root", "root");
		String query = "update admission set  age=?, birth_place=?,  bus=?, cast=?, category=?, "
				+ "  dob=?, first_name=?, gender=?,   last_name=?, middle_name=?, mother_tongue=?, nationality=?,"
				+ "   religion=?,  sub_cast=?, teacher_relative=?,mobile_no1=?,mobile_no2=?,adhar_no=? where admission_id="
				+ admissionId;
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, age);
		ps.setString(2, birth_place);
		ps.setString(3, bus);
		ps.setInt(4, cast);
		ps.setInt(5, category);
		ps.setDate(6, dob);
		ps.setString(7, first_name);
		ps.setString(8, gender);
		ps.setString(9, last_name);
		ps.setString(10, middle_name);
		ps.setString(11, mother_tongue);
		ps.setString(12, nationality);
		ps.setString(13, religion);
		ps.setInt(14, sub_cast);
		ps.setString(15, teacher_relative);
		ps.setString(16, mobileNo1);
		ps.setString(17, mobileNo2);
		ps.setString(18, adharNo);
		ps.executeUpdate();

		System.out.println("Record updated successfully..!");
		return "Record updated..!";

	}

	public String deleteAdmissionById(int admissionID) {
		admissionRepo.deleteById(admissionID);
		return "deleted";
	}

}
