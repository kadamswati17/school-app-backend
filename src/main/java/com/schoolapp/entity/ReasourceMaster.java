package com.schoolapp.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ReasourceMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reasourceId;
	private String reasourceName;
	private int isActive;
	private int userId;
	private int branchId;
	private int orgId;
	private Date createdDate;
	private int updatedBy;

	public ReasourceMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReasourceMaster(int reasourceId, String reasourceName, int isActive, int userId, int branchId, int orgId,
			Date createdDate, int updatedBy) {
		super();
		this.reasourceId = reasourceId;
		this.reasourceName = reasourceName;
		this.isActive = isActive;
		this.userId = userId;
		this.branchId = branchId;
		this.orgId = orgId;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
	}

	public int getReasourceId() {
		return reasourceId;
	}

	public void setReasourceId(int reasourceId) {
		this.reasourceId = reasourceId;
	}

	public String getReasourceName() {
		return reasourceName;
	}

	public void setReasourceName(String reasourceName) {
		this.reasourceName = reasourceName;
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

	@Override
	public String toString() {
		return "ReasourceMaster [reasourceId=" + reasourceId + ", reasourceName=" + reasourceName + ", isActive="
				+ isActive + ", userId=" + userId + ", branchId=" + branchId + ", orgId=" + orgId + ", createdDate="
				+ createdDate + ", updatedBy=" + updatedBy + "]";
	}

}
