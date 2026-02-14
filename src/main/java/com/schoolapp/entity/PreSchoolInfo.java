package com.schoolapp.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PreSchoolInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int preSchoolInfoId;
	private int schoolId;
	private String nameOfPreviousSchool;
	private int stdOfPreviousSchool;
	private String lastYearResult;
	private Date dateOfAdmission;
	private int admissionStd;

	private int division;
	private int sId;
	private int userId;
	private int branchId;
	private int orgId;
	private Date createdDate;
	private int updatedBy;
	private Date updatedDate;

	public PreSchoolInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PreSchoolInfo(int preSchoolInfoId, int schoolId, String nameOfPreviousSchool, int stdOfPreviousSchool,
			String lastYearResult, Date dateOfAdmission, int admissionStd, int division, int sId, int userId,
			int branchId, int orgId, Date createdDate, int updatedBy, Date updatedDate) {
		super();
		this.preSchoolInfoId = preSchoolInfoId;
		this.schoolId = schoolId;
		this.nameOfPreviousSchool = nameOfPreviousSchool;
		this.stdOfPreviousSchool = stdOfPreviousSchool;
		this.lastYearResult = lastYearResult;
		this.dateOfAdmission = dateOfAdmission;
		this.admissionStd = admissionStd;
		this.division = division;
		this.sId = sId;
		this.userId = userId;
		this.branchId = branchId;
		this.orgId = orgId;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public int getPreSchoolInfoId() {
		return preSchoolInfoId;
	}

	public void setPreSchoolInfoId(int preSchoolInfoId) {
		this.preSchoolInfoId = preSchoolInfoId;
	}

	public int getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	public String getNameOfPreviousSchool() {
		return nameOfPreviousSchool;
	}

	public void setNameOfPreviousSchool(String nameOfPreviousSchool) {
		this.nameOfPreviousSchool = nameOfPreviousSchool;
	}

	public int getStdOfPreviousSchool() {
		return stdOfPreviousSchool;
	}

	public void setStdOfPreviousSchool(int stdOfPreviousSchool) {
		this.stdOfPreviousSchool = stdOfPreviousSchool;
	}

	public String getLastYearResult() {
		return lastYearResult;
	}

	public void setLastYearResult(String lastYearResult) {
		this.lastYearResult = lastYearResult;
	}

	public Date getDateOfAdmission() {
		return dateOfAdmission;
	}

	public void setDateOfAdmission(Date dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}

	public int getAdmissionStd() {
		return admissionStd;
	}

	public void setAdmissionStd(int admissionStd) {
		this.admissionStd = admissionStd;
	}

	public int getDivision() {
		return division;
	}

	public void setDivision(int division) {
		this.division = division;
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
		return "PreSchoolInfo [preSchoolInfoId=" + preSchoolInfoId + ", schoolId=" + schoolId
				+ ", nameOfPreviousSchool=" + nameOfPreviousSchool + ", stdOfPreviousSchool=" + stdOfPreviousSchool
				+ ", lastYearResult=" + lastYearResult + ", dateOfAdmission=" + dateOfAdmission + ", admissionStd="
				+ admissionStd + ", division=" + division + ", sId=" + sId + ", userId=" + userId + ", branchId="
				+ branchId + ", orgId=" + orgId + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy
				+ ", updatedDate=" + updatedDate + "]";
	}

}
