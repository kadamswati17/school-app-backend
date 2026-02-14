package com.schoolapp.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StdTransactionDetailes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  
	private int stdTransactionDetailesId;
	private int stdAnnualFeesId;
	private int preBalance;
	private Date trDate;
	private Date chequeDate;
	private int chequeNo;
	private int recivedAmt;
	private int paymentRcvId;
	private String description;
	private int userId;
	private int branchId;
	private int orgId;
	private Date createdDate;
	private int updatedBy;
	private Date updatedDate;

	public StdTransactionDetailes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StdTransactionDetailes(int stdTransactionDetailesId, int stdAnnualFeesId, int preBalance, Date trDate,
			Date chequeDate, int chequeNo, int recivedAmt, int paymentRcvId, String description, int userId,
			int branchId, int orgId, Date createdDate, int updatedBy, Date updatedDate) {
		super();
		this.stdTransactionDetailesId = stdTransactionDetailesId;
		this.stdAnnualFeesId = stdAnnualFeesId;
		this.preBalance = preBalance;
		this.trDate = trDate;
		this.chequeDate = chequeDate;
		this.chequeNo = chequeNo;
		this.recivedAmt = recivedAmt;
		this.paymentRcvId = paymentRcvId;
		this.description = description;
		this.userId = userId;
		this.branchId = branchId;
		this.orgId = orgId;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public int getStdTransactionDetailesId() {
		return stdTransactionDetailesId;
	}

	public void setStdTransactionDetailesId(int stdTransactionDetailesId) {
		this.stdTransactionDetailesId = stdTransactionDetailesId;
	}

	public int getStdAnnualFeesId() {
		return stdAnnualFeesId;
	}

	public void setStdAnnualFeesId(int stdAnnualFeesId) {
		this.stdAnnualFeesId = stdAnnualFeesId;
	}

	public int getPreBalance() {
		return preBalance;
	}

	public void setPreBalance(int preBalance) {
		this.preBalance = preBalance;
	}

	public Date getTrDate() {
		return trDate;
	}

	public void setTrDate(Date trDate) {
		this.trDate = trDate;
	}

	public Date getChequeDate() {
		return chequeDate;
	}

	public void setChequeDate(Date chequeDate) {
		this.chequeDate = chequeDate;
	}

	public int getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(int chequeNo) {
		this.chequeNo = chequeNo;
	}

	public int getRecivedAmt() {
		return recivedAmt;
	}

	public void setRecivedAmt(int recivedAmt) {
		this.recivedAmt = recivedAmt;
	}

	public int getPaymentRcvId() {
		return paymentRcvId;
	}

	public void setPaymentRcvId(int paymentRcvId) {
		this.paymentRcvId = paymentRcvId;
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
		return "StdTransactionDetailes [stdTransactionDetailesId=" + stdTransactionDetailesId + ", stdAnnualFeesId="
				+ stdAnnualFeesId + ", preBalance=" + preBalance + ", trDate=" + trDate + ", chequeDate=" + chequeDate
				+ ", chequeNo=" + chequeNo + ", recivedAmt=" + recivedAmt + ", paymentRcvId=" + paymentRcvId
				+ ", description=" + description + ", userId=" + userId + ", branchId=" + branchId + ", orgId=" + orgId
				+ ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + "]";
	}

}
