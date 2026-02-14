package com.schoolapp.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class GRNEntry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int grnentryId;
	private int GRNEntryMasterId;
	private int userId;
	private int branchId;
	private int orgId;
	private Date createdDate;
	
	private int updatedBy;
	private Date updatedDate;
	private int okQty;
	private String description ;
	private int  orderQty;
	private int rejectQty;
	private int actualQty;
	private int rate;
	private int productId;
	private int customerId;
	public GRNEntry() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GRNEntry(int grnentryId, int gRNEntryMasterId, int userId, int branchId, int orgId, Date createdDate,
			int updatedBy, Date updatedDate, int okQty, String description, int orderQty, int rejectQty, int actualQty,
			int rate, int productId, int customerId) {
		super();
		this.grnentryId = grnentryId;
		GRNEntryMasterId = gRNEntryMasterId;
		this.userId = userId;
		this.branchId = branchId;
		this.orgId = orgId;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.okQty = okQty;
		this.description = description;
		this.orderQty = orderQty;
		this.rejectQty = rejectQty;
		this.actualQty = actualQty;
		this.rate = rate;
		this.productId = productId;
		this.customerId = customerId;
	}
	public int getGrnentryId() {
		return grnentryId;
	}
	public void setGrnentryId(int grnentryId) {
		this.grnentryId = grnentryId;
	}
	public int getGRNEntryMasterId() {
		return GRNEntryMasterId;
	}
	public void setGRNEntryMasterId(int gRNEntryMasterId) {
		GRNEntryMasterId = gRNEntryMasterId;
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
	public int getOkQty() {
		return okQty;
	}
	public void setOkQty(int okQty) {
		this.okQty = okQty;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}
	public int getRejectQty() {
		return rejectQty;
	}
	public void setRejectQty(int rejectQty) {
		this.rejectQty = rejectQty;
	}
	public int getActualQty() {
		return actualQty;
	}
	public void setActualQty(int actualQty) {
		this.actualQty = actualQty;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	@Override
	public String toString() {
		return "GRNEntry [grnentryId=" + grnentryId + ", GRNEntryMasterId=" + GRNEntryMasterId + ", userId=" + userId
				+ ", branchId=" + branchId + ", orgId=" + orgId + ", createdDate=" + createdDate + ", updatedBy="
				+ updatedBy + ", updatedDate=" + updatedDate + ", okQty=" + okQty + ", description=" + description
				+ ", orderQty=" + orderQty + ", rejectQty=" + rejectQty + ", actualQty=" + actualQty + ", rate=" + rate
				+ ", productId=" + productId + ", customerId=" + customerId + ", getGrnentryId()=" + getGrnentryId()
				+ ", getGRNEntryMasterId()=" + getGRNEntryMasterId() + ", getUserId()=" + getUserId()
				+ ", getBranchId()=" + getBranchId() + ", getOrgId()=" + getOrgId() + ", getCreatedDate()="
				+ getCreatedDate() + ", getUpdatedBy()=" + getUpdatedBy() + ", getUpdatedDate()=" + getUpdatedDate()
				+ ", getOkQty()=" + getOkQty() + ", getDescription()=" + getDescription() + ", getOrderQty()="
				+ getOrderQty() + ", getRejectQty()=" + getRejectQty() + ", getActualQty()=" + getActualQty()
				+ ", getRate()=" + getRate() + ", getProductId()=" + getProductId() + ", getCustomerId()="
				+ getCustomerId() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	 
	
	
}