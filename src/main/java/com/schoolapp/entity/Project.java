package com.schoolapp.entity;

//import java.sql.Date;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "projects")   // ✅ THIS IS REQUIRED
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int projectId;
	private int srNo;
	private String projectName;
//	private Date sanctionDate;
//	private Date startDate;
//	private Date endDate; 
	private String srvGutNo;
	private String previousLandOwner;
	private String landOwner;
	private String builderName;
	private int reraNo;
	private String Address;
	private int budgetAmt;
	private int orgId;
	private int branchId;
	private int userId;
//	private Date createdDate;
	private int updatedBy;
//	private Date updatedDate;.
	
	@Temporal(TemporalType.DATE)
	private Date sanctionDate;

	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Temporal(TemporalType.DATE)
	private Date endDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	private int isActive;
	
	
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Project(int projectId, int srNo, String projectName, Date sanctionDate, Date startDate, Date endDate,
			String srvGutNo, String previousLandOwner, String landOwner, String builderName, int reraNo, String address,
			int budgetAmt, int orgId, int branchId, int userId, Date createdDate, int updatedBy, Date updatedDate,
			int isActive) {
		super();
		this.projectId = projectId;
		this.srNo = srNo;
		this.projectName = projectName;
		this.sanctionDate = sanctionDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.srvGutNo = srvGutNo;
		this.previousLandOwner = previousLandOwner;
		this.landOwner = landOwner;
		this.builderName = builderName;
		this.reraNo = reraNo;
		Address = address;
		this.budgetAmt = budgetAmt;
		this.orgId = orgId;
		this.branchId = branchId;
		this.userId = userId;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.isActive = isActive;
	}


	public int getProjectId() {
		return projectId;
	}


	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}


	public int getSrNo() {
		return srNo;
	}


	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}


	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public Date getSanctionDate() {
		return sanctionDate;
	}


	public void setSanctionDate(Date sanctionDate) {
		this.sanctionDate = sanctionDate;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public String getSrvGutNo() {
		return srvGutNo;
	}


	public void setSrvGutNo(String srvGutNo) {
		this.srvGutNo = srvGutNo;
	}


	public String getPreviousLandOwner() {
		return previousLandOwner;
	}


	public void setPreviousLandOwner(String previousLandOwner) {
		this.previousLandOwner = previousLandOwner;
	}


	public String getLandOwner() {
		return landOwner;
	}


	public void setLandOwner(String landOwner) {
		this.landOwner = landOwner;
	}


	public String getBuilderName() {
		return builderName;
	}


	public void setBuilderName(String builderName) {
		this.builderName = builderName;
	}


	public int getReraNo() {
		return reraNo;
	}


	public void setReraNo(int reraNo) {
		this.reraNo = reraNo;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public int getBudgetAmt() {
		return budgetAmt;
	}


	public void setBudgetAmt(int budgetAmt) {
		this.budgetAmt = budgetAmt;
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


	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", srNo=" + srNo + ", projectName=" + projectName + ", sanctionDate="
				+ sanctionDate + ", startDate=" + startDate + ", endDate=" + endDate + ", srvGutNo=" + srvGutNo
				+ ", previousLandOwner=" + previousLandOwner + ", landOwner=" + landOwner + ", builderName="
				+ builderName + ", reraNo=" + reraNo + ", Address=" + Address + ", budgetAmt=" + budgetAmt + ", orgId="
				+ orgId + ", branchId=" + branchId + ", userId=" + userId + ", createdDate=" + createdDate
				+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + ", isActive=" + isActive + "]";
	}
	
	
	
}
