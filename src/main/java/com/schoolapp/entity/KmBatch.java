package com.schoolapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "km_batch")
public class KmBatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "km_batch_no")
    private Long kmBatchNo;

    private Date trndate;
    private String createdby;

    @Column(name = "approval_stage")
    private String approvalStage = "NONE";

    private String approval1;
    private String approval2;
    private String approval3;
    private String approval4; // rejection auditor userId

    @Transient
    private String approval1Name;

    @Transient
    private String approval2Name;

    @Transient
    private String approval3Name;

    @OneToMany(mappedBy = "batch", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<KmDetails> entries;

    @Transient
    private Integer totalEntries;

    // Getters & setters
    public Long getKmBatchNo() { return kmBatchNo; }
    public void setKmBatchNo(Long kmBatchNo) { this.kmBatchNo = kmBatchNo; }

    public Date getTrndate() { return trndate; }
    public void setTrndate(Date trndate) { this.trndate = trndate; }

    public String getCreatedby() { return createdby; }
    public void setCreatedby(String createdby) { this.createdby = createdby; }

    public String getApprovalStage() { return approvalStage; }
    public void setApprovalStage(String approvalStage) { this.approvalStage = approvalStage; }

    public String getApproval1() { return approval1; }
    public void setApproval1(String approval1) { this.approval1 = approval1; }

    public String getApproval2() { return approval2; }
    public void setApproval2(String approval2) { this.approval2 = approval2; }

    public String getApproval3() { return approval3; }
    public void setApproval3(String approval3) { this.approval3 = approval3; }

    public String getApproval4() { return approval4; }
    public void setApproval4(String approval4) { this.approval4 = approval4; }

    public String getApproval1Name() { return approval1Name; }
    public void setApproval1Name(String approval1Name) { this.approval1Name = approval1Name; }

    public String getApproval2Name() { return approval2Name; }
    public void setApproval2Name(String approval2Name) { this.approval2Name = approval2Name; }

    public String getApproval3Name() { return approval3Name; }
    public void setApproval3Name(String approval3Name) { this.approval3Name = approval3Name; }

    public List<KmDetails> getEntries() { return entries; }
    public void setEntries(List<KmDetails> entries) { this.entries = entries; }

    public Integer getTotalEntries() {
        return entries == null ? 0 : entries.size();
    }

    public void setTotalEntries(Integer totalEntries) { this.totalEntries = totalEntries; }
}
