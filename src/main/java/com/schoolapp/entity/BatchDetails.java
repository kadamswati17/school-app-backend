package com.schoolapp.entity;

import jakarta.persistence.*;
//import lombok.*;

//import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "batch_details")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class BatchDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bactno;

    private Date trndate;
    private String createdby;

    private String aproval1;
    private String aproval2;
    private String aproval3;
    private String aproval4;
    
 // --- Approver Names (Not stored in DB, only for frontend response) ---
    @Transient
    private String aproval1Name;

    @Transient
    private String aproval2Name;

    @Transient
    private String aproval3Name;

    public String getAproval1Name() {
        return aproval1Name;
    }
    public void setAproval1Name(String aproval1Name) {
        this.aproval1Name = aproval1Name;
    }

    public String getAproval2Name() {
        return aproval2Name;
    }
    public void setAproval2Name(String aproval2Name) {
        this.aproval2Name = aproval2Name;
    }

    public String getAproval3Name() {
        return aproval3Name;
    }
    public void setAproval3Name(String aproval3Name) {
        this.aproval3Name = aproval3Name;
    }


    public Long getBactno() {
		return bactno;
	}

	public void setBactno(Long bactno) {
		this.bactno = bactno;
	}

	public Date getTrndate() {
		return trndate;
	}

	public void setTrndate(Date trndate) {
		this.trndate = trndate;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getAproval1() {
		return aproval1;
	}

	public void setAproval1(String aproval1) {
		this.aproval1 = aproval1;
	}

	public String getAproval2() {
		return aproval2;
	}

	public void setAproval2(String aproval2) {
		this.aproval2 = aproval2;
	}

	public String getAproval3() {
		return aproval3;
	}

	public void setAproval3(String aproval3) {
		this.aproval3 = aproval3;
	}

	public String getAproval4() {
		return aproval4;
	}

	public void setAproval4(String aproval4) {
		this.aproval4 = aproval4;
	}

	public String getApprovalStage() {
	    return (approvalStage == null || approvalStage.isEmpty()) ? "NONE" : approvalStage;
	}

	public void setApprovalStage(String approvalStage) {
		this.approvalStage = approvalStage;
	}

	public List<CustomerTrnDetails> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<CustomerTrnDetails> transactions) {
		this.transactions = transactions;
	}

	// 🔥 NEW FIELD FOR WORKFLOW STAGE
    // NONE → L1 → L2 → L3
    @Column(name = "approval_stage")
    private String approvalStage = "NONE";

    @OneToMany(mappedBy = "batchDetails", cascade = CascadeType.ALL)
    @com.fasterxml.jackson.annotation.JsonIgnore
    private List<CustomerTrnDetails> transactions;

}
