package com.schoolapp.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TransactionMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionMasterId;
	private int srNo;
	private Date trDate;
	private int sId;
	private int financeYear;
	private int recivedAmt;
	private String description;

	private int userId;
	private int orgId;
	private int branchId;
	private Date createdDate;
	private int updatedBy;
	private Date updatedDate;
	private int isActive;

	public TransactionMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionMaster(int transactionMasterId, int srNo, Date trDate, int sId, int financeYear, int recivedAmt,
			String description, int userId, int orgId, int branchId, Date createdDate, int updatedBy, Date updatedDate,
			int isActive) {
		super();
		this.transactionMasterId = transactionMasterId;
		this.srNo = srNo;
		this.trDate = trDate;
		this.sId = sId;
		this.financeYear = financeYear;
		this.recivedAmt = recivedAmt;
		this.description = description;
		this.userId = userId;
		this.orgId = orgId;
		this.branchId = branchId;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.isActive = isActive;
	}

	public int getTransactionMasterId() {
		return transactionMasterId;
	}

	public void setTransactionMasterId(int transactionMasterId) {
		this.transactionMasterId = transactionMasterId;
	}

	public int getSrNo() {
		return srNo;
	}

	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}

	public Date getTrDate() {
		return trDate;
	}

	public void setTrDate(Date trDate) {
		this.trDate = trDate;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public int getFinanceYear() {
		return financeYear;
	}

	public void setFinanceYear(int financeYear) {
		this.financeYear = financeYear;
	}

	public int getRecivedAmt() {
		return recivedAmt;
	}

	public void setRecivedAmt(int recivedAmt) {
		this.recivedAmt = recivedAmt;
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
		return "TransactionMaster [transactionMasterId=" + transactionMasterId + ", srNo=" + srNo + ", trDate=" + trDate
				+ ", sId=" + sId + ", financeYear=" + financeYear + ", recivedAmt=" + recivedAmt + ", description="
				+ description + ", userId=" + userId + ", orgId=" + orgId + ", branchId=" + branchId + ", createdDate="
				+ createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + ", isActive=" + isActive
				+ "]";
	}

}
