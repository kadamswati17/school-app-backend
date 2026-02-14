package com.schoolapp.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uId;
	private int userSrNo;
	private String userName;
	private int branchId;
	private int orgId;
	private Date date;
	private String userContact;
	private String panNo;
	private String gstNo;
	private String email;
	private String password;
	private String phone;
	private String uAddress;
	private int income;
	private String incomeSource;
	private int otherIncome;
	private String otherIncomeSource;
	private String notes;
	private int isActive;
	private int stateId;
	private int distId;
	private int cityId;
	private int userId;
	private Date createdDate;
	private int updatedBy;
	private Date updatedDate;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int uId, int userSrNo, String userName, int branchId, int orgId, Date date, String userContact,
			String panNo, String gstNo, String email, String password, String phone, String uAddress, int income,
			String incomeSource, int otherIncome, String otherIncomeSource, String notes, int isActive, int stateId,
			int distId, int cityId, int userId, Date createdDate, int updatedBy, Date updatedDate) {
		super();
		this.uId = uId;
		this.userSrNo = userSrNo;
		this.userName = userName;
		this.branchId = branchId;
		this.orgId = orgId;
		this.date = date;
		this.userContact = userContact;
		this.panNo = panNo;
		this.gstNo = gstNo;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.uAddress = uAddress;
		this.income = income;
		this.incomeSource = incomeSource;
		this.otherIncome = otherIncome;
		this.otherIncomeSource = otherIncomeSource;
		this.notes = notes;
		this.isActive = isActive;
		this.stateId = stateId;
		this.distId = distId;
		this.cityId = cityId;
		this.userId = userId;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public int getUserSrNo() {
		return userSrNo;
	}

	public void setUserSrNo(int userSrNo) {
		this.userSrNo = userSrNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUserContact() {
		return userContact;
	}

	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getuAddress() {
		return uAddress;
	}

	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public String getIncomeSource() {
		return incomeSource;
	}

	public void setIncomeSource(String incomeSource) {
		this.incomeSource = incomeSource;
	}

	public int getOtherIncome() {
		return otherIncome;
	}

	public void setOtherIncome(int otherIncome) {
		this.otherIncome = otherIncome;
	}

	public String getOtherIncomeSource() {
		return otherIncomeSource;
	}

	public void setOtherIncomeSource(String otherIncomeSource) {
		this.otherIncomeSource = otherIncomeSource;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public int getDistId() {
		return distId;
	}

	public void setDistId(int distId) {
		this.distId = distId;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
		return "User [uId=" + uId + ", userSrNo=" + userSrNo + ", userName=" + userName + ", branchId=" + branchId
				+ ", orgId=" + orgId + ", date=" + date + ", userContact=" + userContact + ", panNo=" + panNo
				+ ", gstNo=" + gstNo + ", email=" + email + ", password=" + password + ", phone=" + phone
				+ ", uAddress=" + uAddress + ", income=" + income + ", incomeSource=" + incomeSource + ", otherIncome="
				+ otherIncome + ", otherIncomeSource=" + otherIncomeSource + ", notes=" + notes + ", isActive="
				+ isActive + ", stateId=" + stateId + ", distId=" + distId + ", cityId=" + cityId + ", userId=" + userId
				+ ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + "]";
	}

}
