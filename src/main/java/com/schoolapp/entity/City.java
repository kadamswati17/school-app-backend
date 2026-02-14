package com.schoolapp.entity;



import jakarta.persistence.*;
@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "taluka_id", nullable = false)
    private Taluka taluka;

    // ✅ NEW
    @ManyToOne
    @JoinColumn(name = "district_id", nullable = false)
    private District district;

    // ✅ NEW
    @ManyToOne
    @JoinColumn(name = "state_id", nullable = false)
    private State state;

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Taluka getTaluka() { return taluka; }
    public void setTaluka(Taluka taluka) { this.taluka = taluka; }

    public District getDistrict() { return district; }
    public void setDistrict(District district) { this.district = district; }

    public State getState() { return state; }
    public void setState(State state) { this.state = state; }
}
