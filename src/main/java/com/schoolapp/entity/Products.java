package com.schoolapp.entity;

//package com.Crmemp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "products")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Products {

    // ===============================
    // PRIMARY KEY (DB column: id)
    // ===============================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ===============================
    // BASIC FIELDS
    // ===============================
    @Column(nullable = false)
    private String name;

    @Column(name = "unit_price", nullable = false)
    private Double unitPrice;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;

    // ===============================
    // PRODUCT IMAGE (Base64 / Blob)
    // ===============================
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] img;

    // ===============================
    // CREATED BY USER (FK)
    // ===============================
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    @JsonIgnore
    private UserEntity createdBy;

    // ===============================
    // PARENT ADMIN LOGIC
    // ===============================
    @Column(name = "parent_id")
    private Long parentId;

    // ===============================
    // GETTERS & SETTERS
    // ===============================
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public UserEntity getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserEntity createdBy) {
        this.createdBy = createdBy;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}

