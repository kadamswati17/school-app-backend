package com.schoolapp.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Quotation {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int quotationId;
	private Date quotationDate;
	private int quotationMstId;
	private int customerId;
	private int productId;
	private String partiCulars;
	private float rate;
	private float quantity;
	private float discount;
	private float amount;
	private float total;
	private int grandTotal;
	private float mrp;
	private float scheme;
	private float cgst;
	private float sgst;
	private float cgstPer;
	private float sgstPer;
	private float igst;
	private float igstPer;
	private int userId;
	private int orgId;
	private int branchId;
	private Date createdDate;
	private int updatedBy;
	private Date updatedDate;
	private int isActive;
	
	public Quotation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Quotation(int quotationId, Date quotationDate, int quotationMstId, int customerId, int productId,
			String partiCulars, float rate, float quantity, float discount, float amount, float total, int grandTotal,
			float mrp, float scheme, float cgst, float sgst, float cgstPer, float sgstPer, float igst, float igstPer,
			int userId, int orgId, int branchId, Date createdDate, int updatedBy, Date updatedDate, int isActive) {
		super();
		this.quotationId = quotationId;
		this.quotationDate = quotationDate;
		this.quotationMstId = quotationMstId;
		this.customerId = customerId;
		this.productId = productId;
		this.partiCulars = partiCulars;
		this.rate = rate;
		this.quantity = quantity;
		this.discount = discount;
		this.amount = amount;
		this.total = total;
		this.grandTotal = grandTotal;
		this.mrp = mrp;
		this.scheme = scheme;
		this.cgst = cgst;
		this.sgst = sgst;
		this.cgstPer = cgstPer;
		this.sgstPer = sgstPer;
		this.igst = igst;
		this.igstPer = igstPer;
		this.userId = userId;
		this.orgId = orgId;
		this.branchId = branchId;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.isActive = isActive;
	}
	public int getQuotationId() {
		return quotationId;
	}
	public void setQuotationId(int quotationId) {
		this.quotationId = quotationId;
	}
	public Date getQuotationDate() {
		return quotationDate;
	}
	public void setQuotationDate(Date quotationDate) {
		this.quotationDate = quotationDate;
	}
	public int getQuotationMstId() {
		return quotationMstId;
	}
	public void setQuotationMstId(int quotationMstId) {
		this.quotationMstId = quotationMstId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getPartiCulars() {
		return partiCulars;
	}
	public void setPartiCulars(String partiCulars) {
		this.partiCulars = partiCulars;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public int getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(int grandTotal) {
		this.grandTotal = grandTotal;
	}
	public float getMrp() {
		return mrp;
	}
	public void setMrp(float mrp) {
		this.mrp = mrp;
	}
	public float getScheme() {
		return scheme;
	}
	public void setScheme(float scheme) {
		this.scheme = scheme;
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
	public float getCgstPer() {
		return cgstPer;
	}
	public void setCgstPer(float cgstPer) {
		this.cgstPer = cgstPer;
	}
	public float getSgstPer() {
		return sgstPer;
	}
	public void setSgstPer(float sgstPer) {
		this.sgstPer = sgstPer;
	}
	public float getIgst() {
		return igst;
	}
	public void setIgst(float igst) {
		this.igst = igst;
	}
	public float getIgstPer() {
		return igstPer;
	}
	public void setIgstPer(float igstPer) {
		this.igstPer = igstPer;
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
		return "Quotation [quotationId=" + quotationId + ", quotationDate=" + quotationDate + ", quotationMstId="
				+ quotationMstId + ", customerId=" + customerId + ", productId=" + productId + ", partiCulars="
				+ partiCulars + ", rate=" + rate + ", quantity=" + quantity + ", discount=" + discount + ", amount="
				+ amount + ", total=" + total + ", grandTotal=" + grandTotal + ", mrp=" + mrp + ", scheme=" + scheme
				+ ", cgst=" + cgst + ", sgst=" + sgst + ", cgstPer=" + cgstPer + ", sgstPer=" + sgstPer + ", igst="
				+ igst + ", igstPer=" + igstPer + ", userId=" + userId + ", orgId=" + orgId + ", branchId=" + branchId
				+ ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate
				+ ", isActive=" + isActive + "]";
	}
	
	
}
	