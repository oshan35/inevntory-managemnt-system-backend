package com.example.InventoryManagementSystem.DataTransferObjectClasses;

public class InventoryLoginDTO {
    private String inventoryUserName;
    private String inventoryPassword;

    public InventoryLoginDTO(String inventoryUserName, String inventoryPassword) {
        this.inventoryUserName = inventoryUserName;
        this.inventoryPassword = inventoryPassword;
    }

    public String getInventoryUserName() {
        return inventoryUserName;
    }

    public void setInventoryUserName(String inventoryUserName) {
        this.inventoryUserName = inventoryUserName;
    }

    public String getInventoryPassword() {
        return inventoryPassword;
    }

    public void setInventoryPassword(String inventoryPassword) {
        this.inventoryPassword = inventoryPassword;
    }
}
