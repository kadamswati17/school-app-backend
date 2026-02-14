package com.schoolapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class City2 {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CityId;
	private String CityName;
	private int StateId;
	private int DistId;

	public City2() {
		super();
	}
	
	
	public City2(int cityId, String cityName, int stateId, int distId) {
		super();
		CityId = cityId;
		CityName = cityName;
		StateId = stateId;
		DistId = distId;
	}
	
	
	public int getCityId() {
		return CityId;
	}
	
	public void setCityId(int cityId) {
		CityId = cityId;
	}
	
	public String getCityName() {
		return CityName;
	}
	
	public void setCityName(String cityName) {
		CityName = cityName;
	}
	
	public int getStateId() {
		return StateId;
	}
	
	public void setStateId(int stateId) {
		StateId = stateId;
	}
	
	public int getDistId() {
		return DistId;
	}
	
	public void setDistId(int distId) {
		DistId = distId;
	}
	
	@Override
	public String toString() {
		return "City2 [CityId=" + CityId + ", CityName=" + CityName + ", StateId=" + StateId + ", DistId=" + DistId
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	

}
