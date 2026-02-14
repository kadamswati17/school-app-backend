package com.schoolapp.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LeadAccounts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int leadId; 
	private Date date;
	private String cName;
	private String ownerName;
	private int ownerContact;
	private String panNo;
	private String gstNo;
	private String email;  
	private String website;   
	private int phone;
	private int fax;  
	private String invoiceAddress;  
	private int resourceId;
	private int statusId;
	private int assignId;
	private int stateId;
	private int distId; 
	private int cityId;
	private int userId;
	private Date createdDate;
	private int updatedBy;
	private Date updatedDate;
	private int branchId; 
	private int orgId;
	private int income;
	private String incomeSource;
	private int otherIncome;
	private String otherIncomeSource;
	private int budget;
	private int budget1;
	private int budget2;
	private String notes;
	private String area;
	private int isActive;
	
	
	
	public LeadAccounts() {
		super();
		// TODO Auto-generated constructor stub
	}



	public LeadAccounts(int leadId, Date date, String cName, String ownerName, int ownerContact, String panNo,
			String gstNo, String email, String website, int phone, int fax, String invoiceAddress, int resourceId,
			int statusId, int assignId, int stateId, int distId, int cityId, int userId, Date createdDate,
			int updatedBy, Date updatedDate, int branchId, int orgId, int income, String incomeSource, int otherIncome,
			String otherIncomeSource, int budget, int budget1, int budget2, String notes, String area, int isActive) {
		super();
		this.leadId = leadId;
		this.date = date;
		this.cName = cName;
		this.ownerName = ownerName;
		this.ownerContact = ownerContact;
		this.panNo = panNo;
		this.gstNo = gstNo;
		this.email = email;
		this.website = website;
		this.phone = phone;
		this.fax = fax;
		this.invoiceAddress = invoiceAddress;
		this.resourceId = resourceId;
		this.statusId = statusId;
		this.assignId = assignId;
		this.stateId = stateId;
		this.distId = distId;
		this.cityId = cityId;
		this.userId = userId;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.branchId = branchId;
		this.orgId = orgId;
		this.income = income;
		this.incomeSource = incomeSource;
		this.otherIncome = otherIncome;
		this.otherIncomeSource = otherIncomeSource;
		this.budget = budget;
		this.budget1 = budget1;
		this.budget2 = budget2;
		this.notes = notes;
		this.area = area;
		this.isActive=isActive;
		
	}



	public int getLeadId() {
		return leadId;
	}



	public void setLeadId(int leadId) {
		this.leadId = leadId;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public String getcName() {
		return cName;
	}



	public void setcName(String cName) {
		this.cName = cName;
	}



	public String getOwnerName() {
		return ownerName;
	}



	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}



	public int getOwnerContact() {
		return ownerContact;
	}



	public void setOwnerContact(int ownerContact) {
		this.ownerContact = ownerContact;
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



	public int getResourceId() {
		return resourceId;
	}



	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}



	public int getStatusId() {
		return statusId;
	}



	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}



	public int getAssignId() {
		return assignId;
	}



	public void setAssignId(int assignId) {
		this.assignId = assignId;
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



	public int getBudget() {
		return budget;
	}



	public void setBudget(int budget) {
		this.budget = budget;
	}



	public int getBudgetOne() {
		return budget1;
	}



	public void setBudgetOne(int budgetOne) {
		this.budget1 = budgetOne;
	}



	public int getBudgetTwo() {
		return budget2;
	}



	public void setBudgetTwo(int budgetTwo) {
		this.budget2 = budgetTwo;
	}



	public String getNotes() {
		return notes;
	}



	public void setNotes(String notes) {
		this.notes = notes;
	}



	public String getArea() {
		return area;
	}



	public void setArea(String area) {
		this.area = area;
	}
	
	
	public int getIsActive() {
		return isActive;
	}
	
	public void setIsActive(int isActive) {
		this.isActive=isActive;
	}



	@Override
	public String toString() {
		return "LeadAccounts [leadId=" + leadId + ", date=" + date + ", cName=" + cName + ", ownerName=" + ownerName
				+ ", ownerContact=" + ownerContact + ", panNo=" + panNo + ", gstNo=" + gstNo + ", email=" + email
				+ ", website=" + website + ", phone=" + phone + ", fax=" + fax + ", invoiceAddress=" + invoiceAddress
				+ ", resourceId=" + resourceId + ", statusId=" + statusId + ", assignId=" + assignId + ", stateId="
				+ stateId + ", distId=" + distId + ", cityId=" + cityId + ", userId=" + userId + ", createdDate="
				+ createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + ", branchId=" + branchId
				+ ", orgId=" + orgId + ", income=" + income + ", incomeSource=" + incomeSource + ", otherIncome="
				+ otherIncome + ", otherIncomeSource=" + otherIncomeSource + ", budget=" + budget + ", budget1="
				+ budget1 + ", budget2=" + budget2 + ", notes=" + notes + ", area=" + area + ", isActive=" + isActive
				+ "]";
	}



	
	
	
	
	

}
