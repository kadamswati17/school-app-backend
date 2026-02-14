package com.schoolapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "receipts")
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;    // optional (if you store customers as users)
    private Long partyId;       // reference to users.id
    private String partyName;   // stored for convenience

    private String mobile;      // mobile number saved with receipt

    private Integer transactionType; // 1=Receipt,2=Payment
    private Integer paymentMode;     // 0=Cash,1=UPI,2=Bank,3=Card

    private String transactionId;
    private Double amount;

    @Column(columnDefinition = "LONGTEXT")
    private String receiptImage;

    private String receiptDate;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Long createdBy; // who created the receipt (user id)

    public Receipt() {}

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
    public Long getPartyId() { return partyId; }
    public void setPartyId(Long partyId) { this.partyId = partyId; }
    public String getPartyName() { return partyName; }
    public void setPartyName(String partyName) { this.partyName = partyName; }
    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }
    public Integer getTransactionType() { return transactionType; }
    public void setTransactionType(Integer transactionType) { this.transactionType = transactionType; }
    public Integer getPaymentMode() { return paymentMode; }
    public void setPaymentMode(Integer paymentMode) { this.paymentMode = paymentMode; }
    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
    public String getReceiptImage() { return receiptImage; }
    public void setReceiptImage(String receiptImage) { this.receiptImage = receiptImage; }
    public String getReceiptDate() { return receiptDate; }
    public void setReceiptDate(String receiptDate) { this.receiptDate = receiptDate; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Long getCreatedBy() { return createdBy; }
    public void setCreatedBy(Long createdBy) { this.createdBy = createdBy; }
}
