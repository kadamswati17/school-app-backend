package com.schoolapp.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Wing {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int wingId;
	private String wingName;
	private int projectId;
	private int siteId;
	private int srNO;
	private int noOfFlower;
	private int userId;
	private int orgId;
	private int branchId;
	private Date createdDate;
	private int updatedBy;
	private Date updatedDate;
	private int isActive;

	public Wing() {
		super();

	}

	

	public Wing(int wingId, String wingName, int projectId, int siteId, int srNO, int noOfFlower, int userId, int orgId,
			int branchId, Date createdDate, int updatedBy, Date updatedDate, int isActive) {
		super();
		this.wingId = wingId;
		this.wingName = wingName;
		this.projectId = projectId;
		this.siteId = siteId;
		this.srNO = srNO;
		this.noOfFlower = noOfFlower;
		this.userId = userId;
		this.orgId = orgId;
		this.branchId = branchId;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.isActive = isActive;
	}



	public int getWingId() {
		return wingId;
	}



	public void setWingId(int wingId) {
		this.wingId = wingId;
	}



	public String getWingName() {
		return wingName;
	}



	public void setWingName(String wingName) {
		this.wingName = wingName;
	}



	public int getProjectId() {
		return projectId;
	}



	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}



	public int getSiteId() {
		return siteId;
	}



	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}



	public int getSrNO() {
		return srNO;
	}



	public void setSrNO(int srNO) {
		this.srNO = srNO;
	}



	public int getNoOfFlower() {
		return noOfFlower;
	}



	public void setNoOfFlower(int noOfFlower) {
		this.noOfFlower = noOfFlower;
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
		return "Wing [wingId=" + wingId + ", wingName=" + wingName + ", projectId=" + projectId + ", siteId=" + siteId
				+ ", srNO=" + srNO + ", noOfFlower=" + noOfFlower + ", userId=" + userId + ", orgId=" + orgId
				+ ", branchId=" + branchId + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy
				+ ", updatedDate=" + updatedDate + ", isActive=" + isActive + "]";
	}



}
