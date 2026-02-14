package com.schoolapp.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Site {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int siteId;
	private int srNo;
	private String siteName;
	private String siteAddress;
	private int projectId;
	private int orgId;
	private int branchId;
	private int userId;
	private Date createdDate;
	private int updatedBy;
	private Date updatedDate;
	private int isActive;
	public int getSiteId() {
		return siteId;
	}
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}
	public int getSrNo() {
		return srNo;
	}
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getSiteAddress() {
		return siteAddress;
	}
	public void setSiteAddress(String siteAddress) {
		this.siteAddress = siteAddress;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public Site(int siteId, int srNo, String siteName, String siteAddress, int projectId, int orgId, int branchId,
			int userId, Date createdDate, int updatedBy, Date updatedDate, int isActive) {
		super();
		this.siteId = siteId;
		this.srNo = srNo;
		this.siteName = siteName;
		this.siteAddress = siteAddress;
		this.projectId = projectId;
		this.orgId = orgId;
		this.branchId = branchId;
		this.userId = userId;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.isActive = isActive;
	}
	public Site() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Site [siteId=" + siteId + ", srNo=" + srNo + ", siteName=" + siteName + ", siteAddress=" + siteAddress
				+ ", projectId=" + projectId + ", orgId=" + orgId + ", branchId=" + branchId + ", userId=" + userId
				+ ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate
				+ ", isActive=" + isActive + "]";
	}
	
	
	
}
