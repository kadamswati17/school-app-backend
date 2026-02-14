package com.schoolapp.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class WorkOrderMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int workOrderMasterId;
	private int srNo;
	private Date orderDate;
	private int contractorId;
	private int productId;
	private int userId;
	private int orgId;
	private int branchId;
	private Date createdDate;
	private int updatedBy;
	private Date updatedDate;
	private int isActive;
	public WorkOrderMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WorkOrderMaster(int workOrderMasterId, int srNo, Date orderDate, int contractorId, int productId, int userId,
			int orgId, int branchId, Date createdDate, int updatedBy, Date updatedDate, int isActive) {
		super();
		this.workOrderMasterId = workOrderMasterId;
		this.srNo = srNo;
		this.orderDate = orderDate;
		this.contractorId = contractorId;
		this.productId = productId;
		this.userId = userId;
		this.orgId = orgId;
		this.branchId = branchId;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.isActive = isActive;
	}
	public int getWorkOrderMasterId() {
		return workOrderMasterId;
	}
	public void setWorkOrderMasterId(int workOrderMasterId) {
		this.workOrderMasterId = workOrderMasterId;
	}
	public int getSrNo() {
		return srNo;
	}
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getContractorId() {
		return contractorId;
	}
	public void setContractorId(int contractorId) {
		this.contractorId = contractorId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
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
		return "WorkOrderMaster [workOrderMasterId=" + workOrderMasterId + ", srNo=" + srNo + ", orderDate=" + orderDate
				+ ", contractorId=" + contractorId + ", productId=" + productId + ", userId=" + userId + ", orgId="
				+ orgId + ", branchId=" + branchId + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy
				+ ", updatedDate=" + updatedDate + ", isActive=" + isActive + "]";
	}
	
	
	
}
