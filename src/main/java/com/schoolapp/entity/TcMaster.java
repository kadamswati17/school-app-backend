package com.schoolapp.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TcMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tcMasterId;

	private String tcStdName;
	private String talukaName;
	private String distName;
	private String conduct;
	private Date dateOfLeaving;
	private String reasonOfLeaving;
	private String remark;
	private int lcissueNo;

	private int userId;
	private int orgId;
	private int branchId;
	private Date createdDate;
	private int updatedBy;
	private Date updatedDate;
	private int isActive;

	public TcMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TcMaster(int tcMasterId, String tcStdName, String talukaName, String distName, String conduct,
			Date dateOfLeaving, String reasonOfLeaving, String remark, int lcissueNo, int userId, int orgId,
			int branchId, Date createdDate, int updatedBy, Date updatedDate, int isActive) {
		super();
		this.tcMasterId = tcMasterId;
		this.tcStdName = tcStdName;
		this.talukaName = talukaName;
		this.distName = distName;
		this.conduct = conduct;
		this.dateOfLeaving = dateOfLeaving;
		this.reasonOfLeaving = reasonOfLeaving;
		this.remark = remark;
		this.lcissueNo = lcissueNo;
		this.userId = userId;
		this.orgId = orgId;
		this.branchId = branchId;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.isActive = isActive;
	}

	public int getTcMasterId() {
		return tcMasterId;
	}

	public void setTcMasterId(int tcMasterId) {
		this.tcMasterId = tcMasterId;
	}

	public String getTcStdName() {
		return tcStdName;
	}

	public void setTcStdName(String tcStdName) {
		this.tcStdName = tcStdName;
	}

	public String getTalukaName() {
		return talukaName;
	}

	public void setTalukaName(String talukaName) {
		this.talukaName = talukaName;
	}

	public String getDistName() {
		return distName;
	}

	public void setDistName(String distName) {
		this.distName = distName;
	}

	public String getConduct() {
		return conduct;
	}

	public void setConduct(String conduct) {
		this.conduct = conduct;
	}

	public Date getDateOfLeaving() {
		return dateOfLeaving;
	}

	public void setDateOfLeaving(Date dateOfLeaving) {
		this.dateOfLeaving = dateOfLeaving;
	}

	public String getReasonOfLeaving() {
		return reasonOfLeaving;
	}

	public void setReasonOfLeaving(String reasonOfLeaving) {
		this.reasonOfLeaving = reasonOfLeaving;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getLcissueNo() {
		return lcissueNo;
	}

	public void setLcissueNo(int lcissueNo) {
		this.lcissueNo = lcissueNo;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	@Override
	public String toString() {
		return "TcMaster [tcMasterId=" + tcMasterId + ", tcStdName=" + tcStdName + ", talukaName=" + talukaName
				+ ", distName=" + distName + ", conduct=" + conduct + ", dateOfLeaving=" + dateOfLeaving
				+ ", reasonOfLeaving=" + reasonOfLeaving + ", remark=" + remark + ", lcissueNo=" + lcissueNo
				+ ", userId=" + userId + ", orgId=" + orgId + ", branchId=" + branchId + ", createdDate=" + createdDate
				+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + ", isActive=" + isActive + "]";
	}

}
