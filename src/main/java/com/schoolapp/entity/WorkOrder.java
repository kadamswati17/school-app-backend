package com.schoolapp.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class WorkOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int workOrderId;
	private int srNo;
	private Date orderDate;
	private int contractorId;
	private int areaId;
	private int productId;
	private int areaSqrFt;
	private int rate;
	private int userId;
	private int orgId;
	private int branchId;
	private Date createdDate;
	private int updatedBy;
	private Date updatedDate;
	private int isActive;

	public WorkOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WorkOrder(int workOrderId, int srNo, Date orderDate, int contractorId, int areaId, int productId,
			int areaSqrFt, int rate, int userId, int orgId, int branchId, Date createdDate, int updatedBy,
			Date updatedDate, int isActive) {
		super();
		this.workOrderId = workOrderId;
		this.srNo = srNo;
		this.orderDate = orderDate;
		this.contractorId = contractorId;
		this.areaId = areaId;
		this.productId = productId;
		this.areaSqrFt = areaSqrFt;
		this.rate = rate;
		this.userId = userId;
		this.orgId = orgId;
		this.branchId = branchId;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.isActive = isActive;
	}

	public int getWorkOrderId() {
		return workOrderId;
	}

	public void setWorkOrderId(int workOrderId) {
		this.workOrderId = workOrderId;
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

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getAreaSqrFt() {
		return areaSqrFt;
	}

	public void setAreaSqrFt(int areaSqrFt) {
		this.areaSqrFt = areaSqrFt;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
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
		return "WorkOrder [workOrderId=" + workOrderId + ", srNo=" + srNo + ", orderDate=" + orderDate
				+ ", contractorId=" + contractorId + ", areaId=" + areaId + ", productId=" + productId + ", areaSqrFt="
				+ areaSqrFt + ", rate=" + rate + ", userId=" + userId + ", orgId=" + orgId + ", branchId=" + branchId
				+ ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate
				+ ", isActive=" + isActive + "]";
	}

}
