package com.schoolapp.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class InqueryDetailes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int inqueryDetailesId;
	private Date inqueryDate;
	private int inqueryMstNo;
	private int leadAccountId;
	private int productCode;
	private String partiCulars;
	private int rate;
	private int quantity;
	private int discount;
	private int amount;
	private int total;
	private int grandTotal;
	private int mrp;
	private int scheme;
	private int cgst;
	private int sgst;
	private int cgstPer;
	private int sgstPer;
	private int igst;
	private int igstPer;
	private int dcn;
	private int userId;
	private int orgId;
	private int branchId;
	private Date createdDate;
	private int updatedBy;
	private Date updatedDate;
	private int isActive;

	public InqueryDetailes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InqueryDetailes(int inqueryDetailesId, Date inqueryDate, int inqueryMstNo, int leadAccountId,
			int productCode, String partiCulars, int rate, int quantity, int discount, int amount, int total,
			int grandTotal, int mrp, int scheme, int cgst, int sgst, int cgstPer, int sgstPer, int igst, int igstPer,
			int dcn, int userId, int orgId, int branchId, Date createdDate, int updatedBy, Date updatedDate,
			int isActive) {
		super();
		this.inqueryDetailesId = inqueryDetailesId;
		this.inqueryDate = inqueryDate;
		this.inqueryMstNo = inqueryMstNo;
		this.leadAccountId = leadAccountId;
		this.productCode = productCode;
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
		this.dcn = dcn;
		this.userId = userId;
		this.orgId = orgId;
		this.branchId = branchId;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.isActive = isActive;
	}

	public int getInqueryDetailesId() {
		return inqueryDetailesId;
	}

	public void setInqueryDetailesId(int inqueryDetailesId) {
		this.inqueryDetailesId = inqueryDetailesId;
	}

	public Date getInqueryDate() {
		return inqueryDate;
	}

	public void setInqueryDate(Date inqueryDate) {
		this.inqueryDate = inqueryDate;
	}

	public int getInqueryMstNo() {
		return inqueryMstNo;
	}

	public void setInqueryMstNo(int inqueryMstNo) {
		this.inqueryMstNo = inqueryMstNo;
	}

	public int getLeadAccountId() {
		return leadAccountId;
	}

	public void setLeadAccountId(int leadAccountId) {
		this.leadAccountId = leadAccountId;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public String getPartiCulars() {
		return partiCulars;
	}

	public void setPartiCulars(String partiCulars) {
		this.partiCulars = partiCulars;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(int grandTotal) {
		this.grandTotal = grandTotal;
	}

	public int getMrp() {
		return mrp;
	}

	public void setMrp(int mrp) {
		this.mrp = mrp;
	}

	public int getScheme() {
		return scheme;
	}

	public void setScheme(int scheme) {
		this.scheme = scheme;
	}

	public int getCgst() {
		return cgst;
	}

	public void setCgst(int cgst) {
		this.cgst = cgst;
	}

	public int getSgst() {
		return sgst;
	}

	public void setSgst(int sgst) {
		this.sgst = sgst;
	}

	public int getCgstPer() {
		return cgstPer;
	}

	public void setCgstPer(int cgstPer) {
		this.cgstPer = cgstPer;
	}

	public int getSgstPer() {
		return sgstPer;
	}

	public void setSgstPer(int sgstPer) {
		this.sgstPer = sgstPer;
	}

	public int getIgst() {
		return igst;
	}

	public void setIgst(int igst) {
		this.igst = igst;
	}

	public int getIgstPer() {
		return igstPer;
	}

	public void setIgstPer(int igstPer) {
		this.igstPer = igstPer;
	}

	public int getDcn() {
		return dcn;
	}

	public void setDcn(int dcn) {
		this.dcn = dcn;
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
		return "InqueryDetailes [inqueryDetailesId=" + inqueryDetailesId + ", inqueryDate=" + inqueryDate
				+ ", inqueryMstNo=" + inqueryMstNo + ", leadAccountId=" + leadAccountId + ", productCode=" + productCode
				+ ", partiCulars=" + partiCulars + ", rate=" + rate + ", quantity=" + quantity + ", discount="
				+ discount + ", amount=" + amount + ", total=" + total + ", grandTotal=" + grandTotal + ", mrp=" + mrp
				+ ", scheme=" + scheme + ", cgst=" + cgst + ", sgst=" + sgst + ", cgstPer=" + cgstPer + ", sgstPer="
				+ sgstPer + ", igst=" + igst + ", igstPer=" + igstPer + ", dcn=" + dcn + ", userId=" + userId
				+ ", orgId=" + orgId + ", branchId=" + branchId + ", createdDate=" + createdDate + ", updatedBy="
				+ updatedBy + ", updatedDate=" + updatedDate + ", isActive=" + isActive + "]";
	}

	

}
