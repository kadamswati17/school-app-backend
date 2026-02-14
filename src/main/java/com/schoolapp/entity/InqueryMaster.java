package com.schoolapp.entity;

import java.sql.Date;
import java.time.LocalDateTime;
 
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class InqueryMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private	int	InqueryId;  
	private	Date Date;
	private	int	LeadAccount;
	private	int	total;
	private int srno;
	private int userId;
	private int orgId;
	private int branchId;
	private Date createdDate;
	private int updatedBy;
	private Date updatedDate;
	private int isActive;
	
 

	public InqueryMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InqueryMaster(int inqueryId, java.sql.Date date, int leadAccount, int total, int srno, int userId, int orgId,
			int branchId, java.sql.Date createdDate, int updatedBy, java.sql.Date updatedDate, int isActive) {
		super();
		InqueryId = inqueryId;
		Date = date;
		LeadAccount = leadAccount;
		this.total = total;
		this.srno = srno;
		this.userId = userId;
		this.orgId = orgId;
		this.branchId = branchId;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.isActive = isActive;
	}

	public int getInqueryId() {
		return InqueryId;
	}

	public void setInqueryId(int inqueryId) {
		InqueryId = inqueryId;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public int getLeadAccount() {
		return LeadAccount;
	}

	public void setLeadAccount(int leadAccount) {
		LeadAccount = leadAccount;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getSrno() {
		return srno;
	}

	public void setSrno(int srno) {
		this.srno = srno;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
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

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	} 
	
	
	
	
}
