package com.schoolapp.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "production_entry")
public class ProductionEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ---------- PRODUCTION DATA ----------
    private String shift;
    private String batchNo;

    private String siloNo1;
    private Double literWeight1;
    private Double faSolid1;

    private String siloNo2;
    private Double literWeight2;
    private Double faSolid2;

    private Double totalSolid;

    private Double waterLiter;
    private Double cementKg;
    private Double limeKg;
    private Double gypsumKg;
    private Double solOilKg;
    private Double aiPowerGm;
    private Double tempC;
    private String approvalTimeL1;
    private String approvalTimeL2;
    private String approvalTimeL3;
    private String approvalTimeL4;
    private String approvalTimeL5;
    private String approvalTimeL6;
    private String approvalTimeL7;

    public String getApprovalTimeL1() {
		return approvalTimeL1;
	}

	public void setApprovalTimeL1(String approvalTimeL1) {
		this.approvalTimeL1 = approvalTimeL1;
	}

	public String getApprovalTimeL2() {
		return approvalTimeL2;
	}

	public void setApprovalTimeL2(String approvalTimeL2) {
		this.approvalTimeL2 = approvalTimeL2;
	}

	public String getApprovalTimeL3() {
		return approvalTimeL3;
	}

	public void setApprovalTimeL3(String approvalTimeL3) {
		this.approvalTimeL3 = approvalTimeL3;
	}

	public String getApprovalTimeL4() {
		return approvalTimeL4;
	}

	public void setApprovalTimeL4(String approvalTimeL4) {
		this.approvalTimeL4 = approvalTimeL4;
	}

	public String getApprovalTimeL5() {
		return approvalTimeL5;
	}

	public void setApprovalTimeL5(String approvalTimeL5) {
		this.approvalTimeL5 = approvalTimeL5;
	}

	public String getApprovalTimeL6() {
		return approvalTimeL6;
	}

	public void setApprovalTimeL6(String approvalTimeL6) {
		this.approvalTimeL6 = approvalTimeL6;
	}

	public String getApprovalTimeL7() {
		return approvalTimeL7;
	}

	public void setApprovalTimeL7(String approvalTimeL7) {
		this.approvalTimeL7 = approvalTimeL7;
	}

	private String castingTime;
    private String productionTime;

    @Column(length = 500)
    private String productionRemark;

    @Column(length = 500)
    private String remark;
 // ---------- APPROVAL WORKFLOW ----------
 

    private String approvedByL1;
    public String getRejectedBy() {
		return rejectedBy;
	}

	public void setRejectedBy(String rejectedBy) {
		this.rejectedBy = rejectedBy;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	private String approvedByL2;
    private String approvedByL3;
    private String approvedByL4;
    
    
    @Column(length = 20)
    private String approvalStage = "NONE";

    private String rejectedBy;
    private String rejectReason;

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

	public String getApprovedByL4() {
		return approvedByL4;
	}

	public void setApprovedByL4(String approvedByL4) {
		this.approvedByL4 = approvedByL4;
	}

	public String getApprovedByL5() {
		return approvedByL5;
	}

	public void setApprovedByL5(String approvedByL5) {
		this.approvedByL5 = approvedByL5;
	}

	public String getApprovedByL6() {
		return approvedByL6;
	}

	public void setApprovedByL6(String approvedByL6) {
		this.approvedByL6 = approvedByL6;
	}

	public String getApprovedByL7() {
		return approvedByL7;
	}

	public void setApprovedByL7(String approvedByL7) {
		this.approvedByL7 = approvedByL7;
	}

	private String approvedByL5;
    private String approvedByL6;
    private String approvedByL7;


    // ---------- SYSTEM FIELDS ----------
    private int userId;
    private int branchId;
    private int orgId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    private int updatedBy;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    private int isActive;

    // ---------- AUTO SET ----------
    @PrePersist
    public void onCreate() {
        this.createdDate = new Date();
        this.isActive = 1;
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedDate = new Date();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getSiloNo1() {
		return siloNo1;
	}

	public void setSiloNo1(String siloNo1) {
		this.siloNo1 = siloNo1;
	}

	public Double getLiterWeight1() {
		return literWeight1;
	}

	public void setLiterWeight1(Double literWeight1) {
		this.literWeight1 = literWeight1;
	}

	public Double getFaSolid1() {
		return faSolid1;
	}

	public void setFaSolid1(Double faSolid1) {
		this.faSolid1 = faSolid1;
	}

	public String getSiloNo2() {
		return siloNo2;
	}

	public void setSiloNo2(String siloNo2) {
		this.siloNo2 = siloNo2;
	}

	public Double getLiterWeight2() {
		return literWeight2;
	}

	public void setLiterWeight2(Double literWeight2) {
		this.literWeight2 = literWeight2;
	}

	public Double getFaSolid2() {
		return faSolid2;
	}

	public void setFaSolid2(Double faSolid2) {
		this.faSolid2 = faSolid2;
	}

	public Double getTotalSolid() {
		return totalSolid;
	}

	public void setTotalSolid(Double totalSolid) {
		this.totalSolid = totalSolid;
	}

	public Double getWaterLiter() {
		return waterLiter;
	}

	public void setWaterLiter(Double waterLiter) {
		this.waterLiter = waterLiter;
	}

	public Double getCementKg() {
		return cementKg;
	}

	public void setCementKg(Double cementKg) {
		this.cementKg = cementKg;
	}

	public Double getLimeKg() {
		return limeKg;
	}

	public void setLimeKg(Double limeKg) {
		this.limeKg = limeKg;
	}

	public Double getGypsumKg() {
		return gypsumKg;
	}

	public void setGypsumKg(Double gypsumKg) {
		this.gypsumKg = gypsumKg;
	}

	public Double getSolOilKg() {
		return solOilKg;
	}

	public void setSolOilKg(Double solOilKg) {
		this.solOilKg = solOilKg;
	}

	public Double getAiPowerGm() {
		return aiPowerGm;
	}

	public void setAiPowerGm(Double aiPowerGm) {
		this.aiPowerGm = aiPowerGm;
	}

	public Double getTempC() {
		return tempC;
	}

	public void setTempC(Double tempC) {
		this.tempC = tempC;
	}

	public String getCastingTime() {
		return castingTime;
	}

	public void setCastingTime(String castingTime) {
		this.castingTime = castingTime;
	}

	public String getProductionTime() {
		return productionTime;
	}

	public void setProductionTime(String productionTime) {
		this.productionTime = productionTime;
	}

	public String getProductionRemark() {
		return productionRemark;
	}

	public void setProductionRemark(String productionRemark) {
		this.productionRemark = productionRemark;
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

    // ---------- GETTERS & SETTERS ----------
    // 👉 Generate using IDE (Alt + Insert)
}
