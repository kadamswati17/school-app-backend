package com.schoolapp.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StdAnnualFees {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stdAnnualFeesId;
	private int classId;
	private int reasourceId;
	private int sId;
	private int feesStructureId;
	private int financeYear;
	private int charges;
	private Date trDate;
	private int isActive;
	private int userId;
	private int branchId;
	private int orgId;
	private Date createdDate;
	private int updatedBy;
	private Date updatedDate;

	public StdAnnualFees() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StdAnnualFees(int stdAnnualFeesId, int classId, int reasourceId, int sId, int feesStructureId,
			int financeYear, int charges, Date trDate, int isActive, int userId, int branchId, int orgId,
			Date createdDate, int updatedBy, Date updatedDate) {
		super();
		this.stdAnnualFeesId = stdAnnualFeesId;
		this.classId = classId;
		this.reasourceId = reasourceId;
		this.sId = sId;
		this.feesStructureId = feesStructureId;
		this.financeYear = financeYear;
		this.charges = charges;
		this.trDate = trDate;
		this.isActive = isActive;
		this.userId = userId;
		this.branchId = branchId;
		this.orgId = orgId;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public int getStdAnnualFeesId() {
		return stdAnnualFeesId;
	}

	public void setStdAnnualFeesId(int stdAnnualFeesId) {
		this.stdAnnualFeesId = stdAnnualFeesId;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getReasourceId() {
		return reasourceId;
	}

	public void setReasourceId(int reasourceId) {
		this.reasourceId = reasourceId;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public int getFeesStructureId() {
		return feesStructureId;
	}

	public void setFeesStructureId(int feesStructureId) {
		this.feesStructureId = feesStructureId;
	}

	public int getFinanceYear() {
		return financeYear;
	}

	public void setFinanceYear(int financeYear) {
		this.financeYear = financeYear;
	}

	public int getCharges() {
		return charges;
	}

	public void setCharges(int charges) {
		this.charges = charges;
	}

	public Date getTrDate() {
		return trDate;
	}

	public void setTrDate(Date trDate) {
		this.trDate = trDate;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
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
		return "StdAnnualFees [stdAnnualFeesId=" + stdAnnualFeesId + ", classId=" + classId + ", reasourceId="
				+ reasourceId + ", sId=" + sId + ", feesStructureId=" + feesStructureId + ", financeYear=" + financeYear
				+ ", charges=" + charges + ", trDate=" + trDate + ", isActive=" + isActive + ", userId=" + userId
				+ ", branchId=" + branchId + ", orgId=" + orgId + ", createdDate=" + createdDate + ", updatedBy="
				+ updatedBy + ", updatedDate=" + updatedDate + "]";
	}

	 
}
