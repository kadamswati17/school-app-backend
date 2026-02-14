package com.schoolapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "km_details")
public class KmDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "batch_no")
    @JsonIgnore
    private KmBatch batch;

    private String salesperson;
    private Double startKm;
    private Double endKm;
    private String visitedPlace;

    private String filePath;
    private String trnDate;

    public KmDetails() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public KmBatch getBatch() { return batch; }
    public void setBatch(KmBatch batch) { this.batch = batch; }

    public Long getBatchNo() {
        return batch == null ? null : batch.getKmBatchNo();
    }

    public String getSalesperson() { return salesperson; }
    public void setSalesperson(String salesperson) { this.salesperson = salesperson; }

    public Double getStartKm() { return startKm; }
    public void setStartKm(Double startKm) { this.startKm = startKm; }

    public Double getEndKm() { return endKm; }
    public void setEndKm(Double endKm) { this.endKm = endKm; }

    public String getVisitedPlace() { return visitedPlace; }
    public void setVisitedPlace(String visitedPlace) { this.visitedPlace = visitedPlace; }

    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }

    public String getTrnDate() { return trnDate; }
    public void setTrnDate(String trnDate) { this.trnDate = trnDate; }
}
