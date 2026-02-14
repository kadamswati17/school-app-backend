package com.schoolapp.entity;


//package com.Crmemp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {

    // ===============================
    // PRIMARY KEY
    // ===============================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ===============================
    // BASIC USER INFO
    // ===============================
    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(nullable = false, length = 50)
    private String username;

    @Column(nullable = false, length = 120)
    private String password;

    @Column(nullable = false, length = 20)
    private String role; // ROLE_ADMIN, ROLE_L1, etc.

    @Column(nullable = false)
    private boolean active = true;

    @Column(length = 20)
    private String mobile;

    @Column(columnDefinition = "LONGTEXT")
    private String profileImage; // base64 image

    // ===============================
    // PARENT ADMIN ID
    // ===============================
    @Column(name = "parent_id", nullable = true)
    private Long parentId;

    // ===============================
    // CONSTRUCTORS
    // ===============================
    public UserEntity() {}

    public UserEntity(String username, String email, String password, String role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // ===============================
    // GETTERS & SETTERS
    // ===============================
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
