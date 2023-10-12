package com.example.InventoryManagementSystem.Models;

import jakarta.persistence.*;
import jakarta.persistence.Id;

@Entity
@Table(name = "Inventory")
public class Inventory {

    @Id
    @Column(name = "inventory_id", nullable = false, length = 50)
    private String inventoryId;

    @Column(name = "user_name", nullable = false, length = 50)
    private String userName;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @ManyToOne
    @JoinColumn(name = "admin_id", referencedColumnName = "admin_id")
    private Admin admin;

    @Column(name = "contact_no", length = 15)
    private String contactNo;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "official_address", length = 255)
    private String officialAddress;

    @Column(name = "no_of_employees")
    private Integer noOfEmployees;

    @Column(name = "max_stock_capacity")
    private Integer maxStockCapacity;

    @Column(name = "available_stocks")
    private Integer availableStocks;

    @Column(name = "longitude", precision = 9, scale = 6)
    private Double longitude;

    @Column(name = "latitude", precision = 8, scale = 6)
    private Double latitude;

    public Inventory() {
    }

    public Inventory(String inventoryId, String userName, String password, Admin admin, String contactNo, String email, String officialAddress, Integer noOfEmployees, Integer maxStockCapacity, Integer availableStocks, Double longitude, Double latitude) {
        this.inventoryId = inventoryId;
        this.userName = userName;
        this.password = password;
        this.admin = admin;
        this.contactNo = contactNo;
        this.email = email;
        this.officialAddress = officialAddress;
        this.noOfEmployees = noOfEmployees;
        this.maxStockCapacity = maxStockCapacity;
        this.availableStocks = availableStocks;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOfficialAddress() {
        return officialAddress;
    }

    public void setOfficialAddress(String officialAddress) {
        this.officialAddress = officialAddress;
    }

    public Integer getNoOfEmployees() {
        return noOfEmployees;
    }

    public void setNoOfEmployees(Integer noOfEmployees) {
        this.noOfEmployees = noOfEmployees;
    }

    public Integer getMaxStockCapacity() {
        return maxStockCapacity;
    }

    public void setMaxStockCapacity(Integer maxStockCapacity) {
        this.maxStockCapacity = maxStockCapacity;
    }

    public Integer getAvailableStocks() {
        return availableStocks;
    }

    public void setAvailableStocks(Integer availableStocks) {
        this.availableStocks = availableStocks;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}