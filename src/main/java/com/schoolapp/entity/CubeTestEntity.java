package com.schoolapp.entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "cube_test")
public class CubeTestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "batch_no")
    private String batchNo;

    @Column(name = "cast_date")
    @Temporal(TemporalType.DATE)
    private Date castDate;

    @Column(name = "testing_date")
    @Temporal(TemporalType.DATE)
    private Date testingDate;

    @Column(name = "shift")
    private String shift;

    @Column(name = "cube_dimension_immediate")
    private String cubeDimensionImmediate;

    @Column(name = "cube_dimension_over_dry")
    private String cubeDimensionOverDry;

    @Column(name = "weight_immediate_kg")
    private String weightImmediateKg;

    @Column(name = "weight_over_dry_kg")
    private String weightOverDryKg;

    @Column(name = "weight_with_moisture_kg")
    private Double weightWithMoistureKg;

    @Column(name = "load_over_dry_tonn")
    private Double loadOverDryTonn;

    @Column(name = "load_moisture_tonn")
    private Double loadMoistureTonn;

    @Column(name = "comp_strength_over_dry")
    private Double compStrengthOverDry;

    @Column(name = "comp_strength_moisture")
    private Double compStrengthMoisture;

    @Column(name = "density_kgm3")
    private Double densityKgM3;
    
 // ---------- APPROVAL WORKFLOW ----------

    @Column(name="approved_by_l1")
    private String approvedByL1;

    @Column(name="approved_by_l2")
    private String approvedByL2;

    @Column(name="approved_by_l3")
    private String approvedByL3;

//    @Column(length = 20)
    @Column(name="approval_stage")
    private String approvalStage = "NONE";

    @Column(name="rejected_by")
    private String rejectedBy;

    @Column(name="reject_reason")
    private String rejectReason;


    @Column(name = "user_id")
    private int userId;

    @Column(name = "branch_id")
    private int branchId;

    @Column(name = "org_id")
    private int orgId;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "updated_by")
    private int updatedBy;

    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @Column(name = "is_active")
    private int isActive;

    // ===== GETTERS / SETTERS =====

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBatchNo() { return batchNo; }
    public void setBatchNo(String batchNo) { this.batchNo = batchNo; }

    public Date getCastDate() { return castDate; }
    public void setCastDate(Date castDate) { this.castDate = castDate; }

    public Date getTestingDate() { return testingDate; }
    public void setTestingDate(Date testingDate) { this.testingDate = testingDate; }

    public String getShift() { return shift; }
    public void setShift(String shift) { this.shift = shift; }

    public String getCubeDimensionImmediate() { return cubeDimensionImmediate; }
    public void setCubeDimensionImmediate(String cubeDimensionImmediate) { this.cubeDimensionImmediate = cubeDimensionImmediate; }

    public String getCubeDimensionOverDry() { return cubeDimensionOverDry; }
    public void setCubeDimensionOverDry(String cubeDimensionOverDry) { this.cubeDimensionOverDry = cubeDimensionOverDry; }

    public String getWeightImmediateKg() { return weightImmediateKg; }
    public void setWeightImmediateKg(String weightImmediateKg) { this.weightImmediateKg = weightImmediateKg; }

    public String getWeightOverDryKg() { return weightOverDryKg; }
    public void setWeightOverDryKg(String weightOverDryKg) { this.weightOverDryKg = weightOverDryKg; }

    public Double getWeightWithMoistureKg() { return weightWithMoistureKg; }
    public void setWeightWithMoistureKg(Double weightWithMoistureKg) { this.weightWithMoistureKg = weightWithMoistureKg; }

    public Double getLoadOverDryTonn() { return loadOverDryTonn; }
    public void setLoadOverDryTonn(Double loadOverDryTonn) { this.loadOverDryTonn = loadOverDryTonn; }

    public Double getLoadMoistureTonn() { return loadMoistureTonn; }
    public void setLoadMoistureTonn(Double loadMoistureTonn) { this.loadMoistureTonn = loadMoistureTonn; }

    public Double getCompStrengthOverDry() { return compStrengthOverDry; }
    public void setCompStrengthOverDry(Double compStrengthOverDry) { this.compStrengthOverDry = compStrengthOverDry; }

    public Double getCompStrengthMoisture() { return compStrengthMoisture; }
    public void setCompStrengthMoisture(Double compStrengthMoisture) { this.compStrengthMoisture = compStrengthMoisture; }

    public Double getDensityKgM3() { return densityKgM3; }
    public void setDensityKgM3(Double densityKgM3) { this.densityKgM3 = densityKgM3; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getBranchId() { return branchId; }
    public void setBranchId(int branchId) { this.branchId = branchId; }

    public int getOrgId() { return orgId; }
    public void setOrgId(int orgId) { this.orgId = orgId; }

    public Date getCreatedDate() { return createdDate; }
    public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }

    public int getUpdatedBy() { return updatedBy; }
    public void setUpdatedBy(int updatedBy) { this.updatedBy = updatedBy; }

    public Date getUpdatedDate() { return updatedDate; }
    public void setUpdatedDate(Date updatedDate) { this.updatedDate = updatedDate; }

    public int getIsActive() { return isActive; }
    public void setIsActive(int isActive) { this.isActive = isActive; }
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
	public String getApprovalStage() {
		return approvalStage;
	}
	public void setApprovalStage(String approvalStage) {
		this.approvalStage = approvalStage;
	}
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
    
}
