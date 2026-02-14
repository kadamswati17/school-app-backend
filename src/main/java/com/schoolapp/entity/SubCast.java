package com.schoolapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SubCast {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subCastId;
	private String subCastName;

	public SubCast() {
		super();
	}

	public SubCast(int subCastId, String subCastName) {
		super();
		this.subCastId = subCastId;
		this.subCastName = subCastName;
	}

	public int getSubCastId() {
		return subCastId;
	}

	public void setSubCastId(int subCastId) {
		this.subCastId = subCastId;
	}

	public String getSubCastName() {
		return subCastName;
	}

	public void setSubCastName(String subCastName) {
		this.subCastName = subCastName;
	}

	@Override
	public String toString() {
		return "SubCast [subCastId=" + subCastId + ", subCastName=" + subCastName + "]";
	}

}
