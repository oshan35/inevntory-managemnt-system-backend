package com.example.InventoryManagementSystem.DataTransferObjectClasses;

public class InventoryTableDTO {
    private String inventoryId;
    private String telNo;
    private String email;
    private String address;
    private Integer noOfEmployee;
    private Integer maxStockCap;
    private Integer availableStockQuantity;

    public InventoryTableDTO(String inventoryId, String telNo, String email, String address, Integer noOfEmployee, Integer maxStockCap, Integer availableStockQuantity) {
        this.inventoryId = inventoryId;
        this.telNo = telNo;
        this.email = email;
        this.address = address;
        this.noOfEmployee = noOfEmployee;
        this.maxStockCap = maxStockCap;
        this.availableStockQuantity = availableStockQuantity;
    }

    public InventoryTableDTO() {
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
}
