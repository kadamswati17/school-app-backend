package com.schoolapp.entity;

import java.io.File;
import java.sql.Date;
import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Admission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int admissionId;
	private int classId;
	private String mobileNo1;
	private String mobileNo2;
	private String classStandard;
	private String firstName;
	private String middleName;
	private String lastName;
	private String motherName;
	private String gender;
	private Date dob;
	private int age;
	private String birthPlace;
	private String nationality;
	private String motherTongue;
	private String religion;
	private int rte;
	private int cast;
	private int subCast;
	private int category;
	private String bus;
	private String teacherRelative;
	private int userId;
	private int branchId;
	private int orgId;
	private Date createdDate;
	private int updatedBy;
	private Date updatedDate;
	private String regId;
	private String uDiskId;
	private String GRno;
	private String stdSaralPortalId;
	private int pickUpPoint;
	private String adharNo;
//	private File file;

	public Admission() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admission(int admissionId, int classId, String mobileNo1, String mobileNo2, String classStandard,
			String firstName, String middleName, String lastName, String motherName, String gender, Date dob, int age,
			String birthPlace, String nationality, String motherTongue, String religion, int rte, int cast, int subCast,
			int category, String bus, String teacherRelative, int userId, int branchId, int orgId, Date createdDate,
			int updatedBy, Date updatedDate, String regId, String uDiskId, String gRno, String stdSaralPortalId,
			int pickUpPoint, String adharNo) {
		super();
		this.admissionId = admissionId;
		this.classId = classId;
		this.mobileNo1 = mobileNo1;
		this.mobileNo2 = mobileNo2;
		this.classStandard = classStandard;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.motherName = motherName;
		this.gender = gender;
		this.dob = dob;
		this.age = age;
		this.birthPlace = birthPlace;
		this.nationality = nationality;
		this.motherTongue = motherTongue;
		this.religion = religion;
		this.rte = rte;
		this.cast = cast;
		this.subCast = subCast;
		this.category = category;
		this.bus = bus;
		this.teacherRelative = teacherRelative;
		this.userId = userId;
		this.branchId = branchId;
		this.orgId = orgId;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.regId = regId;
		this.uDiskId = uDiskId;
		GRno = gRno;
		this.stdSaralPortalId = stdSaralPortalId;
		this.pickUpPoint = pickUpPoint;
		this.adharNo = adharNo;
	}

	public int getAdmissionId() {
		return admissionId;
	}

	public void setAdmissionId(int admissionId) {
		this.admissionId = admissionId;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getMobileNo1() {
		return mobileNo1;
	}

	public void setMobileNo1(String mobileNo1) {
		this.mobileNo1 = mobileNo1;
	}

	public String getMobileNo2() {
		return mobileNo2;
	}

	public void setMobileNo2(String mobileNo2) {
		this.mobileNo2 = mobileNo2;
	}

	public String getClassStandard() {
		return classStandard;
	}

	public void setClassStandard(String classStandard) {
		this.classStandard = classStandard;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getMotherTongue() {
		return motherTongue;
	}

	public void setMotherTongue(String motherTongue) {
		this.motherTongue = motherTongue;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public int getRte() {
		return rte;
	}

	public void setRte(int rte) {
		this.rte = rte;
	}

	public int getCast() {
		return cast;
	}

	public void setCast(int cast) {
		this.cast = cast;
	}

	public int getSubCast() {
		return subCast;
	}

	public void setSubCast(int subCast) {
		this.subCast = subCast;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getBus() {
		return bus;
	}

	public void setBus(String bus) {
		this.bus = bus;
	}

	public String getTeacherRelative() {
		return teacherRelative;
	}

	public void setTeacherRelative(String teacherRelative) {
		this.teacherRelative = teacherRelative;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public String getuDiskId() {
		return uDiskId;
	}

	public void setuDiskId(String uDiskId) {
		this.uDiskId = uDiskId;
	}

	public String getGRno() {
		return GRno;
	}

	public void setGRno(String gRno) {
		GRno = gRno;
	}

	public String getStdSaralPortalId() {
		return stdSaralPortalId;
	}

	public void setStdSaralPortalId(String stdSaralPortalId) {
		this.stdSaralPortalId = stdSaralPortalId;
	}

	public int getPickUpPoint() {
		return pickUpPoint;
	}

	public void setPickUpPoint(int pickUpPoint) {
		this.pickUpPoint = pickUpPoint;
	}

	public String getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}

	@Override
	public String toString() {
		return "Admission [admissionId=" + admissionId + ", classId=" + classId + ", mobileNo1=" + mobileNo1
				+ ", mobileNo2=" + mobileNo2 + ", classStandard=" + classStandard + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", motherName=" + motherName + ", gender="
				+ gender + ", dob=" + dob + ", age=" + age + ", birthPlace=" + birthPlace + ", nationality="
				+ nationality + ", motherTongue=" + motherTongue + ", religion=" + religion + ", rte=" + rte + ", cast="
				+ cast + ", subCast=" + subCast + ", category=" + category + ", bus=" + bus + ", teacherRelative="
				+ teacherRelative + ", userId=" + userId + ", branchId=" + branchId + ", orgId=" + orgId
				+ ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate
				+ ", regId=" + regId + ", uDiskId=" + uDiskId + ", GRno=" + GRno + ", stdSaralPortalId="
				+ stdSaralPortalId + ", pickUpPoint=" + pickUpPoint + ", adharNo=" + adharNo + "]";
	}

}
