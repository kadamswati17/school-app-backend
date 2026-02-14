package com.schoolapp.entity;

import java.sql.Date;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Dashboard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dashId;
	private int userId;
	private int orgId;
	private int branchId;
	private String api;
	private Timestamp timeStamp;
	private Date date;
	public Dashboard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dashboard(int dashId, int userId, int orgId, int branchId, String api, Timestamp timeStamp, Date date) {
		super();
		this.dashId = dashId;
		this.userId = userId;
		this.orgId = orgId;
		this.branchId = branchId;
		this.api = api;
		this.timeStamp = timeStamp;
		this.date = date;
	}
	public int getDashId() {
		return dashId;
	}
	public void setDashId(int dashId) {
		this.dashId = dashId;
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
	public String getApi() {
		return api;
	}
	public void setApi(String api) {
		this.api = api;
	}
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Dashboard [dashId=" + dashId + ", userId=" + userId + ", orgId=" + orgId + ", branchId=" + branchId
				+ ", api=" + api + ", timeStamp=" + timeStamp + ", date=" + date + "]";
	}
	
	
	
	
}
