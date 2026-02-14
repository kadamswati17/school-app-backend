package com.schoolapp.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
    private String name;
    private String unit;
    private float quantity;
    private float rate;
    private float d1;
    private float d2;
    private String itmType;
    private String shrtnm;
    private String productdiscription;
    private float cgst;
    private float sgst;
    private float igst;
    private float purchaseRate;
    private String hsncode;
    private int category;
    private int categoryID;
    private int brandId;
    private float wrates;
    private int userId;
    private int brId;
    private int orgId;
    private int custId;
	private int isActive;
	private Date createdDate;
	private int updatedBy;
	private Date updatedDate;
    
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int productId, String name, String unit, float quantity, float rate, float d1, float d2,
			String itmType, String shrtnm, String productdiscription, float cgst, float sgst, float igst,
			float purchaseRate, String hsncode, int category, int categoryID, int brandId, float wrates, int userId,
			int brId, int orgId, int custId, int isActive, Date createdDate, int updatedBy, Date updatedDate) {
		super();
		this.productId = productId;
		this.name = name;
		this.unit = unit;
		this.quantity = quantity;
		this.rate = rate;
		this.d1 = d1;
		this.d2 = d2;
		this.itmType = itmType;
		this.shrtnm = shrtnm;
		this.productdiscription = productdiscription;
		this.cgst = cgst;
		this.sgst = sgst;
		this.igst = igst;
		this.purchaseRate = purchaseRate;
		this.hsncode = hsncode;
		this.category = category;
		this.categoryID = categoryID;
		this.brandId = brandId;
		this.wrates = wrates;
		this.userId = userId;
		this.brId = brId;
		this.orgId = orgId;
		this.custId = custId;
		this.isActive = isActive;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public float getD1() {
		return d1;
	}

	public void setD1(float d1) {
		this.d1 = d1;
	}

	public float getD2() {
		return d2;
	}

	public void setD2(float d2) {
		this.d2 = d2;
	}

	public String getItmType() {
		return itmType;
	}

	public void setItmType(String itmType) {
		this.itmType = itmType;
	}

	public String getShrtnm() {
		return shrtnm;
	}

	public void setShrtnm(String shrtnm) {
		this.shrtnm = shrtnm;
	}

	public String getProductdiscription() {
		return productdiscription;
	}

	public void setProductdiscription(String productdiscription) {
		this.productdiscription = productdiscription;
	}

	public float getCgst() {
		return cgst;
	}

	public void setCgst(float cgst) {
		this.cgst = cgst;
	}

	public float getSgst() {
		return sgst;
	}

	public void setSgst(float sgst) {
		this.sgst = sgst;
	}

	public float getIgst() {
		return igst;
	}

	public void setIgst(float igst) {
		this.igst = igst;
	}

	public float getPurchaseRate() {
		return purchaseRate;
	}

	public void setPurchaseRate(float purchaseRate) {
		this.purchaseRate = purchaseRate;
	}

	public String getHsncode() {
		return hsncode;
	}

	public void setHsncode(String hsncode) {
		this.hsncode = hsncode;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public float getWrates() {
		return wrates;
	}

	public void setWrates(float wrates) {
		this.wrates = wrates;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBrId() {
		return brId;
	}

	public void setBrId(int brId) {
		this.brId = brId;
	}

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
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
		return "Product [productId=" + productId + ", name=" + name + ", unit=" + unit + ", quantity=" + quantity
				+ ", rate=" + rate + ", d1=" + d1 + ", d2=" + d2 + ", itmType=" + itmType + ", shrtnm=" + shrtnm
				+ ", productdiscription=" + productdiscription + ", cgst=" + cgst + ", sgst=" + sgst + ", igst=" + igst
				+ ", purchaseRate=" + purchaseRate + ", hsncode=" + hsncode + ", category=" + category + ", categoryID="
				+ categoryID + ", brandId=" + brandId + ", wrates=" + wrates + ", userId=" + userId + ", brId=" + brId
				+ ", orgId=" + orgId + ", custId=" + custId + ", isActive=" + isActive + ", createdDate=" + createdDate
				+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + "]";
	}
	 
    
	

}
