package com.schoolapp.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Unit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int unitId;
	private String unitName;
	private int floorId;
	private int wingId;
	private int projectId;
	private int siteId;
	private int srNo;
	private float totoalSqrft;
	private int price;
	private int userId;
	private int orgId;
	private int branchId;
	private Date createdDate;
	private int updatedBy;
	private Date updatedDate;
	private int isActive;
	
	public Unit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Unit(int unitId, String unitName, int floorId, int wingId, int projectId, int siteId, int srNo,
			float totoalSqrft, int price, int userId, int orgId, int branchId, Date createdDate, int updatedBy,
			Date updatedDate, int isActive) {
		super();
		this.unitId = unitId;
		this.unitName = unitName;
		this.floorId = floorId;
		this.wingId = wingId;
		this.projectId = projectId;
		this.siteId = siteId;
		this.srNo = srNo;
		this.totoalSqrft = totoalSqrft;
		this.price = price;
		this.userId = userId;
		this.orgId = orgId;
		this.branchId = branchId;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.isActive = isActive;
	}

	public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public int getFloorId() {
		return floorId;
	}

	public void setFloorId(int floorId) {
		this.floorId = floorId;
	}

	public int getWingId() {
		return wingId;
	}

	public void setWingId(int wingId) {
		this.wingId = wingId;
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

	public int getSrNo() {
		return srNo;
	}

	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}

	public float getTotoalSqrft() {
		return totoalSqrft;
	}

	public void setTotoalSqrft(float totoalSqrft) {
		this.totoalSqrft = totoalSqrft;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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
		return "Unit [unitId=" + unitId + ", unitName=" + unitName + ", floorId=" + floorId + ", wingId=" + wingId
				+ ", projectId=" + projectId + ", siteId=" + siteId + ", srNo=" + srNo + ", totoalSqrft=" + totoalSqrft
				+ ", price=" + price + ", userId=" + userId + ", orgId=" + orgId + ", branchId=" + branchId
				+ ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate
				+ ", isActive=" + isActive + "]";
	}

	 
}
