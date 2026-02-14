package com.schoolapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cast {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int castId;
	private String castName;

	public Cast() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cast(int castId, String castName) {
		super();
		this.castId = castId;
		this.castName = castName;
	}

	public int getCastId() {
		return castId;
	}

	public void setCastId(int castId) {
		this.castId = castId;
	}

	public String getCastName() {
		return castName;
	}

	public void setCastName(String castName) {
		this.castName = castName;
	}

	@Override
	public String toString() {
		return "Cast [castId=" + castId + ", castName=" + castName + "]";
	}

}
