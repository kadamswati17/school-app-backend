package com.schoolapp.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StudentInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentInfoId;
	private String fatherName;
	private String motherName;
	private String fatherOccupation;
	private String motherOccupation;
	private String officeAddress;
	private int officeContact;
	private String currentAddress;
	private String permanentAddress;
	private int homeContact;
	private int mobileNo;
	private int mothlyIncome;
	private int sId;

	private int userId;
	private int branchId;
	private int orgId;
	private Date createdDate;
	private int updatedBy;
	private Date updatedDate;

	public StudentInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentInfo(int studentInfoId, String fatherName, String motherName, String fatherOccupation,
			String motherOccupation, String officeAddress, int officeContact, String currentAddress,
			String permanentAddress, int homeContact, int mobileNo, int mothlyIncome, int sId, int userId, int branchId,
			int orgId, Date createdDate, int updatedBy, Date updatedDate) {
		super();
		this.studentInfoId = studentInfoId;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.fatherOccupation = fatherOccupation;
		this.motherOccupation = motherOccupation;
		this.officeAddress = officeAddress;
		this.officeContact = officeContact;
		this.currentAddress = currentAddress;
		this.permanentAddress = permanentAddress;
		this.homeContact = homeContact;
		this.mobileNo = mobileNo;
		this.mothlyIncome = mothlyIncome;
		this.sId = sId;
		this.userId = userId;
		this.branchId = branchId;
		this.orgId = orgId;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public int getStudentInfoId() {
		return studentInfoId;
	}

	public void setStudentInfoId(int studentInfoId) {
		this.studentInfoId = studentInfoId;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getFatherOccupation() {
		return fatherOccupation;
	}

	public void setFatherOccupation(String fatherOccupation) {
		this.fatherOccupation = fatherOccupation;
	}

	public String getMotherOccupation() {
		return motherOccupation;
	}

	public void setMotherOccupation(String motherOccupation) {
		this.motherOccupation = motherOccupation;
	}

	public String getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	public int getOfficeContact() {
		return officeContact;
	}

	public void setOfficeContact(int officeContact) {
		this.officeContact = officeContact;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public int getHomeContact() {
		return homeContact;
	}

	public void setHomeContact(int homeContact) {
		this.homeContact = homeContact;
	}

	public int getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}

	public int getMothlyIncome() {
		return mothlyIncome;
	}

	public void setMothlyIncome(int mothlyIncome) {
		this.mothlyIncome = mothlyIncome;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
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

	@Override
	public String toString() {
		return "StudentInfo [studentInfoId=" + studentInfoId + ", fatherName=" + fatherName + ", motherName="
				+ motherName + ", fatherOccupation=" + fatherOccupation + ", motherOccupation=" + motherOccupation
				+ ", officeAddress=" + officeAddress + ", officeContact=" + officeContact + ", currentAddress="
				+ currentAddress + ", permanentAddress=" + permanentAddress + ", homeContact=" + homeContact
				+ ", mobileNo=" + mobileNo + ", mothlyIncome=" + mothlyIncome + ", sId=" + sId + ", userId=" + userId
				+ ", branchId=" + branchId + ", orgId=" + orgId + ", createdDate=" + createdDate + ", updatedBy="
				+ updatedBy + ", updatedDate=" + updatedDate + "]";
	}

}
