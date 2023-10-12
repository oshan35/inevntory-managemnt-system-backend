package com.example.InventoryManagementSystem.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="Admin")
public class Admin {

    @Id
    @Column(name = "admin_id", nullable = false, length = 50)
    private String adminId;

    @Column(name="admin_username",nullable = false, length = 50)
    private String adminUserName;

    @Column(name="admin_password",nullable = false, length = 50)
    private String password;

    public Admin() {
    }

    public Admin(String adminId, String adminUserName, String password) {
        this.adminId = adminId;
        this.adminUserName = adminUserName;
        this.password = password;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminUserName() {
        return adminUserName;
    }

    public void setAdminUserName(String adminUserName) {
        this.adminUserName = adminUserName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
