//package com.crmemp.entity;
package com.schoolapp.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "autoclave_wagon")
public class AutoclaveWagon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer eBatch;
    private Integer eSize;

    private Integer mBatch;
    private Integer mSize;

    private Integer wBatch;
    private Integer wSize;

    // 🔗 FK
    @ManyToOne
    @JoinColumn(name = "autoclave_id")
    private AutoclaveCycle autoclave;

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

    // ===== GETTERS & SETTERS =====
    public Long getId() { return id; }

    public Integer geteBatch() { return eBatch; }
    public void seteBatch(Integer eBatch) { this.eBatch = eBatch; }

    public Integer geteSize() { return eSize; }
    public void seteSize(Integer eSize) { this.eSize = eSize; }

    public Integer getmBatch() { return mBatch; }
    public void setmBatch(Integer mBatch) { this.mBatch = mBatch; }

    public Integer getmSize() { return mSize; }
    public void setmSize(Integer mSize) { this.mSize = mSize; }

    public Integer getwBatch() { return wBatch; }
    public void setwBatch(Integer wBatch) { this.wBatch = wBatch; }

    public Integer getwSize() { return wSize; }
    public void setwSize(Integer wSize) { this.wSize = wSize; }

    public AutoclaveCycle getAutoclave() { return autoclave; }
    public void setAutoclave(AutoclaveCycle autoclave) { this.autoclave = autoclave; }

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
