package com.example.InventoryManagementSystem.DataTransferObjectClasses;

import jakarta.persistence.criteria.CriteriaBuilder;

public class InventoryDTO {

    private String admin_id;
    private String inventoryId;
    private String telNo;
    private String email;
    private String address;
    private Integer noOfEmployee;
    private Integer maxStockCap;
    private Integer availableStockQuantity;
    private String userName;
    private String password;
    private long longitude;
    private long latitude;

    public InventoryDTO(String admin_id, String inventoryId, String telNo, String email, String address, Integer noOfEmployee, Integer maxStockCap, Integer availableStockQuantity, String userName, String password, long longitude, long latitude) {
        this.admin_id = admin_id;
        this.inventoryId = inventoryId;
        this.telNo = telNo;
        this.email = email;
        this.address = address;
        this.noOfEmployee = noOfEmployee;
        this.maxStockCap = maxStockCap;
        this.availableStockQuantity = availableStockQuantity;
        this.userName = userName;
        this.password = password;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNoOfEmployee() {
        return noOfEmployee;
    }

    public void setNoOfEmployee(Integer noOfEmployee) {
        this.noOfEmployee = noOfEmployee;
    }

    public Integer getMaxStockCap() {
        return maxStockCap;
    }

    public void setMaxStockCap(Integer maxStockCap) {
        this.maxStockCap = maxStockCap;
    }

    public Integer getAvailableStockQuantity() {
        return availableStockQuantity;
    }

    public void setAvailableStockQuantity(Integer availableStockQuantity) {
        this.availableStockQuantity = availableStockQuantity;
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

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }
}
