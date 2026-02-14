package com.schoolapp.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Dispatch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int DispatchId;
	private int DispatchMasterId;
	private int purchaseOrderId;
	private int productId;
	private int customerId;
	private int orderQty;
	private int actualQty;
	private int OkQty;
	private int rejectQty;
	private int rate;
	private String description;

	private int userId;
	private int branchId;
	private int orgId;
	private Date createdDate;
	private int updatedBy;
	private Date updatedDate;
	
	
	public Dispatch() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Dispatch(int dispatchId, int dispatchMasterId, int purchaseOrderId, int productId, int customerId,
			int orderQty, int actualQty, int okQty, int rejectQty, int rate, String description, int userId,
			int branchId, int orgId, Date createdDate, int updatedBy, Date updatedDate) {
		super();
		DispatchId = dispatchId;
		DispatchMasterId = dispatchMasterId;
		this.purchaseOrderId = purchaseOrderId;
		this.productId = productId;
		this.customerId = customerId;
		this.orderQty = orderQty;
		this.actualQty = actualQty;
		OkQty = okQty;
		this.rejectQty = rejectQty;
		this.rate = rate;
		this.description = description;
		this.userId = userId;
		this.branchId = branchId;
		this.orgId = orgId;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}
	
	
	public int getDispatchId() {
		return DispatchId;
	}
	public void setDispatchId(int dispatchId) {
		DispatchId = dispatchId;
	}
	public int getDispatchMasterId() {
		return DispatchMasterId;
	}
	public void setDispatchMasterId(int dispatchMasterId) {
		DispatchMasterId = dispatchMasterId;
	}
	public int getPurchaseOrderId() {
		return purchaseOrderId;
	}
	public void setPurchaseOrderId(int purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
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
	public int getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}
	public int getActualQty() {
		return actualQty;
	}
	public void setActualQty(int actualQty) {
		this.actualQty = actualQty;
	}
	public int getOkQty() {
		return OkQty;
	}
	public void setOkQty(int okQty) {
		OkQty = okQty;
	}
	public int getRejectQty() {
		return rejectQty;
	}
	public void setRejectQty(int rejectQty) {
		this.rejectQty = rejectQty;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
		return "Dispatch [DispatchId=" + DispatchId + ", DispatchMasterId=" + DispatchMasterId + ", purchaseOrderId="
				+ purchaseOrderId + ", productId=" + productId + ", customerId=" + customerId + ", orderQty=" + orderQty
				+ ", actualQty=" + actualQty + ", OkQty=" + OkQty + ", rejectQty=" + rejectQty + ", rate=" + rate
				+ ", description=" + description + ", userId=" + userId + ", branchId=" + branchId + ", orgId=" + orgId
				+ ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + "]";
	}
	
	
	

}
