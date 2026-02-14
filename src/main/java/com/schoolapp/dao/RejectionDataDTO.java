package com.schoolapp.dao;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class RejectionDataDTO {

    private Long id;
    private Date date;
    private String batchNo;
    private String blockSize;
    private Integer qty;
    private String shift;

    private Integer cornerDamage;
    private Integer eruptionType;
    private Integer topSideDamages;
    private Integer sideCrackThermalCrack;
    private Integer risingCrack;
    private Integer centreCrack;
    private Integer bottomUncutBlocks;
    private Integer totalBreakages;
    @Column(name="user_id")
    private Integer userId;

    @Column(name="branch_id")
    private Integer branchId;

    @Column(name="org_id")
    private Integer orgId;

    @Column(name="created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name="updated_by")
    private Integer updatedBy;

    @Column(name="updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getBlockSize() {
		return blockSize;
	}
	public void setBlockSize(String blockSize) {
		this.blockSize = blockSize;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	
	public String getShift() {
	    return shift;
	}

	public void setShift(String shift) {
	    this.shift = shift;
	}

	public Integer getCornerDamage() {
		return cornerDamage;
	}
	public void setCornerDamage(Integer cornerDamage) {
		this.cornerDamage = cornerDamage;
	}
	public Integer getEruptionType() {
		return eruptionType;
	}
	public void setEruptionType(Integer eruptionType) {
		this.eruptionType = eruptionType;
	}
	public Integer getTopSideDamages() {
		return topSideDamages;
	}
	public void setTopSideDamages(Integer topSideDamages) {
		this.topSideDamages = topSideDamages;
	}
	public Integer getSideCrackThermalCrack() {
		return sideCrackThermalCrack;
	}
	public void setSideCrackThermalCrack(Integer sideCrackThermalCrack) {
		this.sideCrackThermalCrack = sideCrackThermalCrack;
	}
	public Integer getRisingCrack() {
		return risingCrack;
	}
	public void setRisingCrack(Integer risingCrack) {
		this.risingCrack = risingCrack;
	}
	public Integer getCentreCrack() {
		return centreCrack;
	}
	public void setCentreCrack(Integer centreCrack) {
		this.centreCrack = centreCrack;
	}
	public Integer getBottomUncutBlocks() {
		return bottomUncutBlocks;
	}
	public void setBottomUncutBlocks(Integer bottomUncutBlocks) {
		this.bottomUncutBlocks = bottomUncutBlocks;
	}
	public Integer getTotalBreakages() {
		return totalBreakages;
	}
	public void setTotalBreakages(Integer totalBreakages) {
		this.totalBreakages = totalBreakages;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getBranchId() {
		return branchId;
	}
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Integer getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	private Integer isActive;

    // getters setters
}
