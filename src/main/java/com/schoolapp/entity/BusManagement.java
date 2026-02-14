package com.schoolapp.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BusManagement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int busManagementId;
	private String nameOfVillage;
	private int distanceFromVillage;
	private int busCharges;

	private int userId;
	private int branchId;
	private int orgId;
	private Date createdDate;
	private int updatedBy;
	private Date updatedDate;

	public BusManagement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BusManagement(int busManagementId, String nameOfVillage, int distanceFromVillage, int busCharges, int userId,
			int branchId, int orgId, Date createdDate, int updatedBy, Date updatedDate) {
		super();
		this.busManagementId = busManagementId;
		this.nameOfVillage = nameOfVillage;
		this.distanceFromVillage = distanceFromVillage;
		this.busCharges = busCharges;
		this.userId = userId;
		this.branchId = branchId;
		this.orgId = orgId;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public int getBusManagementId() {
		return busManagementId;
	}

	public void setBusManagementId(int busManagementId) {
		this.busManagementId = busManagementId;
	}

	public String getNameOfVillage() {
		return nameOfVillage;
	}

	public void setNameOfVillage(String nameOfVillage) {
		this.nameOfVillage = nameOfVillage;
	}

	public int getDistanceFromVillage() {
		return distanceFromVillage;
	}

	public void setDistanceFromVillage(int distanceFromVillage) {
		this.distanceFromVillage = distanceFromVillage;
	}

	public int getBusCharges() {
		return busCharges;
	}

	public void setBusCharges(int busCharges) {
		this.busCharges = busCharges;
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
		return "BusManagement [busManagementId=" + busManagementId + ", nameOfVillage=" + nameOfVillage
				+ ", distanceFromVillage=" + distanceFromVillage + ", busCharges=" + busCharges + ", userId=" + userId
				+ ", branchId=" + branchId + ", orgId=" + orgId + ", createdDate=" + createdDate + ", updatedBy="
				+ updatedBy + ", updatedDate=" + updatedDate + "]";
	}

}
