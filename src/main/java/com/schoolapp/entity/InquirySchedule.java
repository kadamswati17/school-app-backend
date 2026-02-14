package com.schoolapp.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "inquiry_schedule")
public class InquirySchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inqId;              // ✅ Schedule ID (NO CHANGE)

    private Long inquiryId;          // ✅ Inquiry ID (NEW)

    private int orgId = 0;
    private int branchId = 0;
    private int userId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    private int updatedBy;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @Temporal(TemporalType.DATE)
    private Date scheduleDate;

    private String scheTime;
    private String remark;
    private String inqStatus;
    private int assignTo;

    // ===== Getters & Setters =====

    public Long getInqId() {
        return inqId;
    }

    public void setInqId(Long inqId) {
        this.inqId = inqId;
    }

    public Long getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(Long inquiryId) {
        this.inquiryId = inquiryId;
    }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getScheTime() {
        return scheTime;
    }

    public void setScheTime(String scheTime) {
        this.scheTime = scheTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getInqStatus() {
        return inqStatus;
    }

    public void setInqStatus(String inqStatus) {
        this.inqStatus = inqStatus;
    }

    public int getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(int assignTo) {
        this.assignTo = assignTo;
    }
}
