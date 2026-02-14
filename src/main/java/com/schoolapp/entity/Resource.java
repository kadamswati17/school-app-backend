package com.schoolapp.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Resource {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int resourceId;
	private String resourceName;
	private String resourceTpye;
	private int isActive;
	
	public Resource() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Resource(int resourceId, String resourceName, String resourceTpye, int isActive) {
		super();
		this.resourceId = resourceId;
		this.resourceName = resourceName;
		this.resourceTpye = resourceTpye;
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Resource [resourceId=" + resourceId + ", resourceName=" + resourceName + ", resourceTpye="
				+ resourceTpye + ", isActive=" + isActive + "]";
	}

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceTpye() {
		return resourceTpye;
	}

	public void setResourceTpye(String resourceTpye) {
		this.resourceTpye = resourceTpye;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	
	
	
}
