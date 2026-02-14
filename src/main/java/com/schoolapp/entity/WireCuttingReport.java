package com.schoolapp.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "wire_cutting_report")
public class WireCuttingReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String batchNo;

    @Temporal(TemporalType.DATE)
    private Date cuttingDate;

    private int mouldNo;
    private int size;
    private int ballTestMm;

    private String otherReason;
    private String time;

    // ===== APPROVAL FLOW =====
    private String approvalStage; // L1, L2, L3, APPROVED, REJECTED

    private String approvedByL1;
    private String approvedByL2;
    private String approvedByL3;

    private String rejectionReason;

    // ===== SYSTEM =====
    private int userId;
    private int branchId;
    private int orgId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    private int updatedBy;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    private int isActive;

    @PrePersist
    public void onCreate() {
        createdDate = new Date();
        isActive = 1;
    }

    @PreUpdate
    public void onUpdate() {
        updatedDate = new Date();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public Date getCuttingDate() {
		return cuttingDate;
	}

	public void setCuttingDate(Date cuttingDate) {
		this.cuttingDate = cuttingDate;
	}

	public int getMouldNo() {
		return mouldNo;
	}

	public void setMouldNo(int mouldNo) {
		this.mouldNo = mouldNo;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getBallTestMm() {
		return ballTestMm;
	}

	public void setBallTestMm(int ballTestMm) {
		this.ballTestMm = ballTestMm;
	}

	public String getOtherReason() {
		return otherReason;
	}

	public void setOtherReason(String otherReason) {
		this.otherReason = otherReason;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getApprovalStage() {
		return approvalStage;
	}

	public void setApprovalStage(String approvalStage) {
		this.approvalStage = approvalStage;
	}

	public String getApprovedByL1() {
		return approvedByL1;
	}

	public void setApprovedByL1(String approvedByL1) {
		this.approvedByL1 = approvedByL1;
	}

	public String getApprovedByL2() {
		return approvedByL2;
	}

	public void setApprovedByL2(String approvedByL2) {
		this.approvedByL2 = approvedByL2;
	}

	public String getApprovedByL3() {
		return approvedByL3;
	}

	public void setApprovedByL3(String approvedByL3) {
		this.approvedByL3 = approvedByL3;
	}

	public String getRejectionReason() {
		return rejectionReason;
	}

	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

}
