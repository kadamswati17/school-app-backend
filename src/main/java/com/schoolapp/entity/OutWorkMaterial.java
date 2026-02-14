package com.schoolapp.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OutWorkMaterial {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int OutWorkMaterialId;
	private int OutWorkMaterialMasterId;
	private int purchaseOrderId;
	private int productId;
	private int customerId;
	private int isshuQty;
	private int scrapQty;
	private int rate;
	private String description;
	private int tranType;
	private int referenceNo;

	private int userId;
	private int branchId;
	private int orgId;
	private Date createdDate;
	private int updatedBy;
	private Date updatedDate;
	public OutWorkMaterial() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OutWorkMaterial(int outWorkMaterialId, int outWorkMaterialMasterId, int purchaseOrderId, int productId,
			int customerId, int isshuQty, int scrapQty, int rate, String description, int tranType, int referenceNo,
			int userId, int branchId, int orgId, Date createdDate, int updatedBy, Date updatedDate) {
		super();
		OutWorkMaterialId = outWorkMaterialId;
		OutWorkMaterialMasterId = outWorkMaterialMasterId;
		this.purchaseOrderId = purchaseOrderId;
		this.productId = productId;
		this.customerId = customerId;
		this.isshuQty = isshuQty;
		this.scrapQty = scrapQty;
		this.rate = rate;
		this.description = description;
		this.tranType = tranType;
		this.referenceNo = referenceNo;
		this.userId = userId;
		this.branchId = branchId;
		this.orgId = orgId;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}
	public int getOutWorkMaterialId() {
		return OutWorkMaterialId;
	}
	public void setOutWorkMaterialId(int outWorkMaterialId) {
		OutWorkMaterialId = outWorkMaterialId;
	}
	public int getOutWorkMaterialMasterId() {
		return OutWorkMaterialMasterId;
	}
	public void setOutWorkMaterialMasterId(int outWorkMaterialMasterId) {
		OutWorkMaterialMasterId = outWorkMaterialMasterId;
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
	public int getIsshuQty() {
		return isshuQty;
	}
	public void setIsshuQty(int isshuQty) {
		this.isshuQty = isshuQty;
	}
	public int getScrapQty() {
		return scrapQty;
	}
	public void setScrapQty(int scrapQty) {
		this.scrapQty = scrapQty;
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
	public int getTranType() {
		return tranType;
	}
	public void setTranType(int tranType) {
		this.tranType = tranType;
	}
	public int getReferenceNo() {
		return referenceNo;
	}
	public void setReferenceNo(int referenceNo) {
		this.referenceNo = referenceNo;
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
		return "OutWorkMaterial [OutWorkMaterialId=" + OutWorkMaterialId + ", OutWorkMaterialMasterId="
				+ OutWorkMaterialMasterId + ", purchaseOrderId=" + purchaseOrderId + ", productId=" + productId
				+ ", customerId=" + customerId + ", isshuQty=" + isshuQty + ", scrapQty=" + scrapQty + ", rate=" + rate
				+ ", description=" + description + ", tranType=" + tranType + ", referenceNo=" + referenceNo
				+ ", userId=" + userId + ", branchId=" + branchId + ", orgId=" + orgId + ", createdDate=" + createdDate
				+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + "]";
	}
	
	
}