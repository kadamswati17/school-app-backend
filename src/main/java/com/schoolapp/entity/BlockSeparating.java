package com.schoolapp.entity;

//package com.yourapp.blockseparating.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "block_separating")
public class BlockSeparating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ===== FORM FIELDS =====
    @Column(nullable = false)
    private String batchNumber;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date castingDate;

    @Column(nullable = false)
    private String blockSize;

    @Column(nullable = false)
    private Integer time;

    // 🔥 ADD THIS
    @Column(name = "shift", length = 1, nullable = false)
    private String shift;   // 1, 2, 3, G
    private String remark;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "report_date", nullable = false)
    private Date reportDate;

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }


    public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	// ===== COMMON REQUIRED FIELDS =====
    private int userId;
    private int branchId;
    private int orgId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    private int updatedBy;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    private int isActive;

    // ===== GETTERS & SETTERS =====

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBatchNumber() { return batchNumber; }
    public void setBatchNumber(String batchNumber) { this.batchNumber = batchNumber; }

    public Date getCastingDate() { return castingDate; }
    public void setCastingDate(Date castingDate) { this.castingDate = castingDate; }

    public String getBlockSize() { return blockSize; }
    public void setBlockSize(String blockSize) { this.blockSize = blockSize; }

    public Integer getTime() { return time; }
    public void setTime(Integer time) { this.time = time; }

    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }

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
}

