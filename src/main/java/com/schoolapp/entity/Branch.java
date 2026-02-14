package com.schoolapp.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int branchId;
	private int serialNumber;
	private String branchName;
	private int orgId;
	private Date date;
	private String branchManagerName;
	private int branchContact;
	private String panNo;
	private String gstNo;
	private String email;
	private String website;
	private int phone;
	private int fax;
	private String invoiceAddress;
	private int income;
	private String incomeSource;
	private int otherIncome;
	private String otherIncomeSource;
	private int budget1;
	private int budget2;
	private String notes;
	private int isActive;
	private int stateId;
	private int distId;
	private int cityId;
	private int userId;
	private Date createdDate;
	private int updatedBy;
	private Date updatedDate;

	public Branch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Branch(int branchId, int serialNumber, String branchName, int orgId, Date date, String branchManagerName,
			int branchContact, String panNo, String gstNo, String email, String website, int phone, int fax,
			String invoiceAddress, int income, String incomeSource, int otherIncome, String otherIncomeSource,
			int budget1, int budget2, String notes, int isActive, int stateId, int distId, int cityId, int userId,
			Date createdDate, int updatedBy, Date updatedDate) {
		super();
		this.branchId = branchId;
		this.serialNumber = serialNumber;
		this.branchName = branchName;
		this.orgId = orgId;
		this.date = date;
		this.branchManagerName = branchManagerName;
		this.branchContact = branchContact;
		this.panNo = panNo;
		this.gstNo = gstNo;
		this.email = email;
		this.website = website;
		this.phone = phone;
		this.fax = fax;
		this.invoiceAddress = invoiceAddress;
		this.income = income;
		this.incomeSource = incomeSource;
		this.otherIncome = otherIncome;
		this.otherIncomeSource = otherIncomeSource;
		this.budget1 = budget1;
		this.budget2 = budget2;
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

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
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

	public String getBranchManagerName() {
		return branchManagerName;
	}

	public void setBranchManagerName(String branchManagerName) {
		this.branchManagerName = branchManagerName;
	}

	public int getBranchContact() {
		return branchContact;
	}

	public void setBranchContact(int branchContact) {
		this.branchContact = branchContact;
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

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getFax() {
		return fax;
	}

	public void setFax(int fax) {
		this.fax = fax;
	}

	public String getInvoiceAddress() {
		return invoiceAddress;
	}

	public void setInvoiceAddress(String invoiceAddress) {
		this.invoiceAddress = invoiceAddress;
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

	public int getBudget1() {
		return budget1;
	}

	public void setBudget1(int budget1) {
		this.budget1 = budget1;
	}

	public int getBudget2() {
		return budget2;
	}

	public void setBudget2(int budget2) {
		this.budget2 = budget2;
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
		return "Branch [branchId=" + branchId + ", serialNumber=" + serialNumber + ", branchName=" + branchName
				+ ", orgId=" + orgId + ", date=" + date + ", branchManagerName=" + branchManagerName
				+ ", branchContact=" + branchContact + ", panNo=" + panNo + ", gstNo=" + gstNo + ", email=" + email
				+ ", website=" + website + ", phone=" + phone + ", fax=" + fax + ", invoiceAddress=" + invoiceAddress
				+ ", income=" + income + ", incomeSource=" + incomeSource + ", otherIncome=" + otherIncome
				+ ", otherIncomeSource=" + otherIncomeSource + ", budget1=" + budget1 + ", budget2=" + budget2
				+ ", notes=" + notes + ", isActive=" + isActive + ", stateId=" + stateId + ", distId=" + distId
				+ ", cityId=" + cityId + ", userId=" + userId + ", createdDate=" + createdDate + ", updatedBy="
				+ updatedBy + ", updatedDate=" + updatedDate + "]";
	}

}
