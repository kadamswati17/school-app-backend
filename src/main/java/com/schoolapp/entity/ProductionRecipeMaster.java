package com.schoolapp.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProductionRecipeMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productionRecipeMasterId;
	private int userId;
	private int branchId;
	private int orgId;
	private Date createdDate;
	private int updatedBy;
	private Date updatedDate;

	public ProductionRecipeMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductionRecipeMaster(int productionRecipeMasterId, int userId, int branchId, int orgId, Date createdDate,
			int updatedBy, Date updatedDate) {
		super();
		this.productionRecipeMasterId = productionRecipeMasterId;
		this.userId = userId;
		this.branchId = branchId;
		this.orgId = orgId;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public int getProductionRecipeMasterId() {
		return productionRecipeMasterId;
	}

	public void setProductionRecipeMasterId(int productionRecipeMasterId) {
		this.productionRecipeMasterId = productionRecipeMasterId;
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
		return "ProductionRecipeMaster [productionRecipeMasterId=" + productionRecipeMasterId + ", userId=" + userId
				+ ", branchId=" + branchId + ", orgId=" + orgId + ", createdDate=" + createdDate + ", updatedBy="
				+ updatedBy + ", updatedDate=" + updatedDate + "]";
	}

}
