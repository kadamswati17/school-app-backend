package com.schoolapp.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AccessPermission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accessPermissionId;
	private int accessUserId;
	private int modelId;
	private int accessCreate;
	private int accessRead;
	private int accessUpdate;
	private int accessDelete;
	private int userId;
	private int orgId;
	private int branchId;
	private Date createdDate;
	private int updatedBy;
	private Date updatedDate;
	private int isActive;
	public AccessPermission() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccessPermission(int accessPermissionId, int accessUserId, int modelId, int accessCreate, int accessRead,
			int accessUpdate, int accessDelete, int userId, int orgId, int branchId, Date createdDate, int updatedBy,
			Date updatedDate, int isActive) {
		super();
		this.accessPermissionId = accessPermissionId;
		this.accessUserId = accessUserId;
		this.modelId = modelId;
		this.accessCreate = accessCreate;
		this.accessRead = accessRead;
		this.accessUpdate = accessUpdate;
		this.accessDelete = accessDelete;
		this.userId = userId;
		this.orgId = orgId;
		this.branchId = branchId;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.isActive = isActive;
	}
	public int getAccessPermissionId() {
		return accessPermissionId;
	}
	public void setAccessPermissionId(int accessPermissionId) {
		this.accessPermissionId = accessPermissionId;
	}
	public int getAccessUserId() {
		return accessUserId;
	}
	public void setAccessUserId(int accessUserId) {
		this.accessUserId = accessUserId;
	}
	public int getModelId() {
		return modelId;
	}
	public void setModelId(int modelId) {
		this.modelId = modelId;
	}
	public int getAccessCreate() {
		return accessCreate;
	}
	public void setAccessCreate(int accessCreate) {
		this.accessCreate = accessCreate;
	}
	public int getAccessRead() {
		return accessRead;
	}
	public void setAccessRead(int accessRead) {
		this.accessRead = accessRead;
	}
	public int getAccessUpdate() {
		return accessUpdate;
	}
	public void setAccessUpdate(int accessUpdate) {
		this.accessUpdate = accessUpdate;
	}
	public int getAccessDelete() {
		return accessDelete;
	}
	public void setAccessDelete(int accessDelete) {
		this.accessDelete = accessDelete;
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
		return "AccessPermission [accessPermissionId=" + accessPermissionId + ", accessUserId=" + accessUserId
				+ ", modelId=" + modelId + ", accessCreate=" + accessCreate + ", accessRead=" + accessRead
				+ ", accessUpdate=" + accessUpdate + ", accessDelete=" + accessDelete + ", userId=" + userId
				+ ", orgId=" + orgId + ", branchId=" + branchId + ", createdDate=" + createdDate + ", updatedBy="
				+ updatedBy + ", updatedDate=" + updatedDate + ", isActive=" + isActive + "]";
	}
	
	
	
}
