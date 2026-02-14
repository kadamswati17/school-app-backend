package com.schoolapp.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProductionRecipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productionRecipeId;
	private int productionRecipeMasterId;
	private int productId;
	private int finishGoodId;
	private int rowProductId;
	private int qty;
	private int rate;

	private int userId;
	private int branchId;
	private int orgId;
	private Date createdDate;
	private int updatedBy;
	private Date updatedDate;

	public ProductionRecipe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductionRecipe(int productionRecipeId, int productionRecipeMasterId, int productId, int finishGoodId,
			int rowProductId, int qty, int rate, int userId, int branchId, int orgId, Date createdDate, int updatedBy,
			Date updatedDate) {
		super();
		this.productionRecipeId = productionRecipeId;
		this.productionRecipeMasterId = productionRecipeMasterId;
		this.productId = productId;
		this.finishGoodId = finishGoodId;
		this.rowProductId = rowProductId;
		this.qty = qty;
		this.rate = rate;
		this.userId = userId;
		this.branchId = branchId;
		this.orgId = orgId;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public int getProductionRecipeId() {
		return productionRecipeId;
	}

	public void setProductionRecipeId(int productionRecipeId) {
		this.productionRecipeId = productionRecipeId;
	}

	public int getProductionRecipeMasterId() {
		return productionRecipeMasterId;
	}

	public void setProductionRecipeMasterId(int productionRecipeMasterId) {
		this.productionRecipeMasterId = productionRecipeMasterId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getFinishGoodId() {
		return finishGoodId;
	}

	public void setFinishGoodId(int finishGoodId) {
		this.finishGoodId = finishGoodId;
	}

	public int getRowProductId() {
		return rowProductId;
	}

	public void setRowProductId(int rowProductId) {
		this.rowProductId = rowProductId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
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
		return "ProductionRecipe [productionRecipeId=" + productionRecipeId + ", productionRecipeMasterId="
				+ productionRecipeMasterId + ", productId=" + productId + ", finishGoodId=" + finishGoodId
				+ ", rowProductId=" + rowProductId + ", qty=" + qty + ", rate=" + rate + ", userId=" + userId
				+ ", branchId=" + branchId + ", orgId=" + orgId + ", createdDate=" + createdDate + ", updatedBy="
				+ updatedBy + ", updatedDate=" + updatedDate + "]";
	}
}
