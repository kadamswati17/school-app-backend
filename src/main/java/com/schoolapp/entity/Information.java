package com.schoolapp.entity;

import java.sql.Blob;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Information {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	private String name;
	 
	@Lob
	private Blob imageBlob;
	
	public Information() {
		super();
	}

	public Information(int id, String name,  Blob imageBlob) {
		super();
		this.id = id;
		this.name = name;
		this.imageBlob = imageBlob;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Blob getPhoto() {
		return imageBlob;
	}

	public void setPhoto(Blob  imageBlob) {
		this.imageBlob = imageBlob;
	}

	@Override
	public String toString() {
		return "Information [id=" + id + ", name=" + name + ", photo=" + imageBlob + "]";
	}
	
	
}
