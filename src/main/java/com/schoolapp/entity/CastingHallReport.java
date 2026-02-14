package com.schoolapp.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "casting_hall_report")
public class CastingHallReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String batchNo;

    private int size;
    private int bedNo;
    private int mouldNo;
    private String castingTime;

    private int consistency;
    private int flowInCm;
    private int castingTempC;
    private int vt;
    private int massTemp;
    private int fallingTestMm;
    private int testTime;
    private int hTime;

    private String remark;
    
 // ================= APPROVAL FLOW =================
 // ================= APPROVAL FLOW =================

    @Column(name = "approved_byl1")
    private String approvedByL1;

    @Column(name = "approved_byl2")
    private String approvedByL2;

    @Column(name = "approved_byl3")
    private String approvedByL3;

    @Column(name = "rejected_by")
    private String rejectedBy;

    @Column(name = "rejection_reason")
    private String rejectionReason;

    @Column(name = "approval_stage")
    private String approvalStage;





  

	private int userId;
    private int branchId;
    private int orgId;

    // ✅ AUTO DATE (VERY IMPORTANT)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    private int updatedBy;
    private int isActive;

    // ================= LIFECYCLE =================

    @PrePersist
    protected void onCreate() {
        this.createdDate = new Date();   // 🔥 auto insert date
        this.isActive = 1;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedDate = new Date();   // 🔥 auto update date
    }

    // ================= GETTERS & SETTERS =================

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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getBedNo() {
        return bedNo;
    }

    public void setBedNo(int bedNo) {
        this.bedNo = bedNo;
    }

    public int getMouldNo() {
        return mouldNo;
    }

    public void setMouldNo(int mouldNo) {
        this.mouldNo = mouldNo;
    }

    public String getCastingTime() {
        return castingTime;
    }

    public void setCastingTime(String castingTime) {
        this.castingTime = castingTime;
    }

    public int getConsistency() {
        return consistency;
    }

    public void setConsistency(int consistency) {
        this.consistency = consistency;
    }

    public int getFlowInCm() {
        return flowInCm;
    }

    public void setFlowInCm(int flowInCm) {
        this.flowInCm = flowInCm;
    }

    public int getCastingTempC() {
        return castingTempC;
    }

    public void setCastingTempC(int castingTempC) {
        this.castingTempC = castingTempC;
    }

    public int getVt() {
        return vt;
    }

    public void setVt(int vt) {
        this.vt = vt;
    }

    public int getMassTemp() {
        return massTemp;
    }

    public void setMassTemp(int massTemp) {
        this.massTemp = massTemp;
    }

    public int getFallingTestMm() {
        return fallingTestMm;
    }

    public void setFallingTestMm(int fallingTestMm) {
        this.fallingTestMm = fallingTestMm;
    }

    public int getTestTime() {
        return testTime;
    }

    public void setTestTime(int testTime) {
        this.testTime = testTime;
    }

    public int getHTime() {
        return hTime;
    }

    public void setHTime(int hTime) {
        this.hTime = hTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

	public int gethTime() {
		return hTime;
	}

	public void sethTime(int hTime) {
		this.hTime = hTime;
	}

	public String getApprovalStage() {
		return approvalStage;
	}

	public void setApprovalStage(String approvalStage) {
		this.approvalStage = approvalStage;
	}

	

	public String getRejectionReason() {
		return rejectionReason;
	}

	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
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

	public String getRejectedBy() {
		return rejectedBy;
	}

	public void setRejectedBy(String rejectedBy) {
		this.rejectedBy = rejectedBy;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
    
}
