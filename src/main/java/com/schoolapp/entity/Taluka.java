package com.schoolapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "talukas")
public class Taluka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    // ✅ store district id only
    @Column(name = "district_id", nullable = false)
    private Long districtId;

    // ✅ store state id only
    @Column(name = "state_id", nullable = false)
    private Long stateId;

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Long getDistrictId() { return districtId; }
    public void setDistrictId(Long districtId) { this.districtId = districtId; }

    public Long getStateId() { return stateId; }
    public void setStateId(Long stateId) { this.stateId = stateId; }
}
