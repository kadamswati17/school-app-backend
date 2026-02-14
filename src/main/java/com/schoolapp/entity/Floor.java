package com.schoolapp.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Floor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int floorId;
	private String floorName;
	private int projectId;
	private int siteId;
	private int srno;
	private int wingId;
	private int userId;
	private int orgId;
	private int branchId;
	private Date createdDate;
	private int updatedBy;
	private Date updatedDate;
	private int isActive;
	
	
	public Floor() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Floor(int floorId, String floorName, int projectId, int siteId, int srno, int wingId, int userId, int orgId,
			int branchId, Date createdDate, int updatedBy, Date updatedDate, int isActive) {
		super();
		this.floorId = floorId;
		this.floorName = floorName;
		this.projectId = projectId;
		this.siteId = siteId;
		this.srno = srno;
		this.wingId = wingId;
		this.userId = userId;
		this.orgId = orgId;
		this.branchId = branchId;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.isActive = isActive;
	}


	public int getFloorId() {
		return floorId;
	}


	public void setFloorId(int floorId) {
		this.floorId = floorId;
	}


	public String getFloorName() {
		return floorName;
	}


	public void setFloorName(String floorName) {
		this.floorName = floorName;
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


	public int getSrno() {
		return srno;
	}


	public void setSrno(int srno) {
		this.srno = srno;
	}


	public int getWingId() {
		return wingId;
	}


	public void setWingId(int wingId) {
		this.wingId = wingId;
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
		return "Floor [floorId=" + floorId + ", floorName=" + floorName + ", projectId=" + projectId + ", siteId="
				+ siteId + ", srno=" + srno + ", wingId=" + wingId + ", userId=" + userId + ", orgId=" + orgId
				+ ", branchId=" + branchId + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy
				+ ", updatedDate=" + updatedDate + ", isActive=" + isActive + "]";
	}


	 
}
