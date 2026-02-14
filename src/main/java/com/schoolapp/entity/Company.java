package com.schoolapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int userId;
	private int orgId;
	private int date;
	private int createdDate;
	private int updateDate;
	private int updateId;
	private String brandName;
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Company(int id, int userId, int orgId, int date, int createdDate, int updateDate, int updateId,
			String brandName) {
		super();
		this.id = id;
		this.userId = userId;
		this.orgId = orgId;
		this.date = date;
		this.createdDate = createdDate;
		this.updateDate = updateDate;
		this.updateId = updateId;
		this.brandName = brandName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(int createdDate) {
		this.createdDate = createdDate;
	}
	public int getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(int updateDate) {
		this.updateDate = updateDate;
	}
	public int getUpdateId() {
		return updateId;
	}
	public void setUpdateId(int updateId) {
		this.updateId = updateId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", userId=" + userId + ", orgId=" + orgId + ", date=" + date + ", createdDate="
				+ createdDate + ", updateDate=" + updateDate + ", updateId=" + updateId + ", brandName=" + brandName
				+ "]";
	}
	
	
	
	
	
	
	
}
