package com.schoolapp.entity;

import jakarta.persistence.*;
//import lombok.Data;
import java.util.Date;

@Entity
@Table(name = "customer_trn_details")
//@Data
public class CustomerTrnDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long trbactno;
    private Date trndate;
    private String customerName;
    private String toolingdrawingpartno;
    private String partdrawingname;
    private String partdrawingno;
    private String descriptionoftooling;
    private String cmworkorderno;
    private String toolingassetno;
    private String createdby;
    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private String status = "PENDING";


    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTrbactno() {
		return trbactno;
	}

	public void setTrbactno(Long trbactno) {
		this.trbactno = trbactno;
	}

	public Date getTrndate() {
		return trndate;
	}

	public void setTrndate(Date trndate) {
		this.trndate = trndate;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getToolingdrawingpartno() {
		return toolingdrawingpartno;
	}

	public void setToolingdrawingpartno(String toolingdrawingpartno) {
		this.toolingdrawingpartno = toolingdrawingpartno;
	}

	public String getPartdrawingname() {
		return partdrawingname;
	}

	public void setPartdrawingname(String partdrawingname) {
		this.partdrawingname = partdrawingname;
	}

	public String getPartdrawingno() {
		return partdrawingno;
	}

	public void setPartdrawingno(String partdrawingno) {
		this.partdrawingno = partdrawingno;
	}

	public String getDescriptionoftooling() {
		return descriptionoftooling;
	}

	public void setDescriptionoftooling(String descriptionoftooling) {
		this.descriptionoftooling = descriptionoftooling;
	}

	public String getCmworkorderno() {
		return cmworkorderno;
	}

	public void setCmworkorderno(String cmworkorderno) {
		this.cmworkorderno = cmworkorderno;
	}

	public String getToolingassetno() {
		return toolingassetno;
	}

	public void setToolingassetno(String toolingassetno) {
		this.toolingassetno = toolingassetno;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public BatchDetails getBatchDetails() {
		return batchDetails;
	}

	public void setBatchDetails(BatchDetails batchDetails) {
		this.batchDetails = batchDetails;
	}

	@ManyToOne
	@JoinColumn(name = "bactno")
    private BatchDetails batchDetails;
}
