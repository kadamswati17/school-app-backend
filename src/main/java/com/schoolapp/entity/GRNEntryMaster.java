package com.schoolapp.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class GRNEntryMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int GRNEntryMasterId;
	private int purchaseOrderId;
	private int userId;
	private int branchId;
	private int orgId;
	private Date createdDate;
	private int updatedBy;
	private Date updatedDate;

	public GRNEntryMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GRNEntryMaster(int gRNEntryMasterId, int purchaseOrderId, int userId, int branchId, int orgId,
			Date createdDate, int updatedBy, Date updatedDate) {
		super();
		GRNEntryMasterId = gRNEntryMasterId;
		this.purchaseOrderId = purchaseOrderId;
		this.userId = userId;
		this.branchId = branchId;
		this.orgId = orgId;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public int getGRNEntryMasterId() {
		return GRNEntryMasterId;
	}

	public void setGRNEntryMasterId(int gRNEntryMasterId) {
		GRNEntryMasterId = gRNEntryMasterId;
	}

	public int getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(int purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
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
		return "GRNEntryMaster [GRNEntryMasterId=" + GRNEntryMasterId + ", purchaseOrderId=" + purchaseOrderId
				+ ", userId=" + userId + ", branchId=" + branchId + ", orgId=" + orgId + ", createdDate=" + createdDate
				+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + "]";
	}

}
