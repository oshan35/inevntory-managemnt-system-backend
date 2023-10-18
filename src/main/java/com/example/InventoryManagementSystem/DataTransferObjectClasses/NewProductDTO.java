package com.example.InventoryManagementSystem.DataTransferObjectClasses;

public class NewProductDTO {

    private String inventoryId;

    private String productId;


    private String productName;


    private Double unitPrice;

    private String description;

    public NewProductDTO(String inventoryId, String productID, String productName, Double unitPrice, String description) {
        this.inventoryId = inventoryId;
        this.productId = productID;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.description = description;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
}
