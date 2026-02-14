package com.schoolapp.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RecieptPaymentTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int recieptPaymentTransactionId;
	private int customerId;
	private int preBalance;
	private Date trDate;
	private int trnTypeId;
	private Date chequeDate;
	private int chequeNo;
	private int trnAmount;
	private int paymentRcvId;
	private String description;
	private int userId;
	private int branchId;
	private int orgId;
	private Date createdDate;
	private int updatedBy;
	private Date updatedDate;

	public RecieptPaymentTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RecieptPaymentTransaction(int recieptPaymentTransactionId, int customerId, int preBalance, Date trDate,
			int trnTypeId, Date chequeDate, int chequeNo, int trnAmount, int paymentRcvId, String description,
			int userId, int branchId, int orgId, Date createdDate, int updatedBy, Date updatedDate) {
		super();
		this.recieptPaymentTransactionId = recieptPaymentTransactionId;
		this.customerId = customerId;
		this.preBalance = preBalance;
		this.trDate = trDate;
		this.trnTypeId = trnTypeId;
		this.chequeDate = chequeDate;
		this.chequeNo = chequeNo;
		this.trnAmount = trnAmount;
		this.paymentRcvId = paymentRcvId;
		this.description = description;
		this.userId = userId;
		this.branchId = branchId;
		this.orgId = orgId;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public int getRecieptPaymentTransactionId() {
		return recieptPaymentTransactionId;
	}

	public void setRecieptPaymentTransactionId(int recieptPaymentTransactionId) {
		this.recieptPaymentTransactionId = recieptPaymentTransactionId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public int getTrnTypeId() {
		return trnTypeId;
	}

	public void setTrnTypeId(int trnTypeId) {
		this.trnTypeId = trnTypeId;
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

	public int getTrnAmount() {
		return trnAmount;
	}

	public void setTrnAmount(int trnAmount) {
		this.trnAmount = trnAmount;
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
		return "RecieptPaymentTransaction [recieptPaymentTransactionId=" + recieptPaymentTransactionId + ", customerId="
				+ customerId + ", preBalance=" + preBalance + ", trDate=" + trDate + ", trnTypeId=" + trnTypeId
				+ ", chequeDate=" + chequeDate + ", chequeNo=" + chequeNo + ", trnAmount=" + trnAmount
				+ ", paymentRcvId=" + paymentRcvId + ", description=" + description + ", userId=" + userId
				+ ", branchId=" + branchId + ", orgId=" + orgId + ", createdDate=" + createdDate + ", updatedBy="
				+ updatedBy + ", updatedDate=" + updatedDate + "]";
	}

}
