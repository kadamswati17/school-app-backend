package com.schoolapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmailForm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int emailId;
	private String to_email;
	private String subject;
	private String body;

	public EmailForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmailForm(int emailId, String to, String subject, String body) {
		super();
		this.emailId = emailId;
		this.to_email = to;
		this.subject = subject;
		this.body = body;
	}

	public int getEmailId() {
		return emailId;
	}

	public void setEmailId(int emailId) {
		this.emailId = emailId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "EmailForm [emailId=" + emailId + ", to_email=" + to_email + ", subject=" + subject + ", body=" + body + "]";
	}

	public String getTo_email() {
		return to_email;
	}

	public void setTo_email(String to_email) {
		this.to_email = to_email;
	}

}
