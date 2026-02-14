package com.schoolapp.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "autoclave_cycle")
public class AutoclaveCycle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String autoclaveNo;
    private String runNo;
    private String startedAt;
    private Date startedDate;
    private String completedAt;
    private Date completedDate;

    @Column(length = 1000)
    private String remarks;

    // 🔥 REQUIRED FIELDS
    private int userId;
    private int branchId;
    private int orgId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    private int updatedBy;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    private int isActive = 1;

    // 🔗 RELATION
    @OneToMany(mappedBy = "autoclave", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AutoclaveWagon> wagons;

    // ===== GETTERS & SETTERS =====
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAutoclaveNo() { return autoclaveNo; }
    public void setAutoclaveNo(String autoclaveNo) { this.autoclaveNo = autoclaveNo; }

    public String getRunNo() { return runNo; }
    public void setRunNo(String runNo) { this.runNo = runNo; }

    public String getStartedAt() { return startedAt; }
    public void setStartedAt(String startedAt) { this.startedAt = startedAt; }

    public Date getStartedDate() { return startedDate; }
    public void setStartedDate(Date startedDate) { this.startedDate = startedDate; }

    public String getCompletedAt() { return completedAt; }
    public void setCompletedAt(String completedAt) { this.completedAt = completedAt; }

    public Date getCompletedDate() { return completedDate; }
    public void setCompletedDate(Date completedDate) { this.completedDate = completedDate; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }

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

    public List<AutoclaveWagon> getWagons() { return wagons; }
    public void setWagons(List<AutoclaveWagon> wagons) { this.wagons = wagons; }
}
