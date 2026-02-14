package com.schoolapp.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AreaMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int areaMasterId;
	private String areaMasterName;
	private int srNo;
	private int userId;
	private int orgId;
	private int branchId;
	private Date createdDate;
	private int updatedBy;
	private Date updatedDate;
	private int isActive;
	public AreaMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AreaMaster(int areaMasterId, String areaMasterName, int srNo, int userId, int orgId, int branchId,
			Date createdDate, int updatedBy, Date updatedDate, int isActive) {
		super();
		this.areaMasterId = areaMasterId;
		this.areaMasterName = areaMasterName;
		this.srNo = srNo;
		this.userId = userId;
		this.orgId = orgId;
		this.branchId = branchId;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.isActive = isActive;
	}
	public int getAreaMasterId() {
		return areaMasterId;
	}
	public void setAreaMasterId(int areaMasterId) {
		this.areaMasterId = areaMasterId;
	}
	public String getAreaMasterName() {
		return areaMasterName;
	}
	public void setAreaMasterName(String areaMasterName) {
		this.areaMasterName = areaMasterName;
	}
	public int getSrNo() {
		return srNo;
	}
	public void setSrNo(int srNo) {
		this.srNo = srNo;
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
		return "AreaMaster [areaMasterId=" + areaMasterId + ", areaMasterName=" + areaMasterName + ", srNo=" + srNo
				+ ", userId=" + userId + ", orgId=" + orgId + ", branchId=" + branchId + ", createdDate=" + createdDate
				+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + ", isActive=" + isActive + "]";
	}
	
	
	
}
