package com.schoolapp.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class QuotationMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int quotationMstId;
	private Date Date;
	private int customerId;
	private int total;
	private int srno;
	private int userId;
	private int orgId;
	private int branchId;
	private Date createdDate;
	private int updatedBy;
	private Date updatedDate;
	private int isActive;
	public QuotationMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QuotationMaster(int quotationMstId, java.sql.Date date, int customerId, int total, int srno, int userId,
			int orgId, int branchId, java.sql.Date createdDate, int updatedBy, java.sql.Date updatedDate,
			int isActive) {
		super();
		this.quotationMstId = quotationMstId;
		Date = date;
		this.customerId = customerId;
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
	public int getQuotationMstId() {
		return quotationMstId;
	}
	public void setQuotationMstId(int quotationMstId) {
		this.quotationMstId = quotationMstId;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
	@Override
	public String toString() {
		return "QuotationMaster [quotationMstId=" + quotationMstId + ", Date=" + Date + ", customerId=" + customerId
				+ ", total=" + total + ", srno=" + srno + ", userId=" + userId + ", orgId=" + orgId + ", branchId="
				+ branchId + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate="
				+ updatedDate + ", isActive=" + isActive + "]";
	}


}
