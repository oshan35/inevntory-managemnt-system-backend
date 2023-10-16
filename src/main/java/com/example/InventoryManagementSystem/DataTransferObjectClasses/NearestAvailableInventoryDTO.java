package com.example.InventoryManagementSystem.DataTransferObjectClasses;

public class NearestAvailableInventoryDTO {
    private String inventoryId;
    private String productId;
    private String address;
    private double distance;
    private int quantity;


    public NearestAvailableInventoryDTO(String inventoryId, String productId, String address, double distance, int quantity) {
        this.inventoryId = inventoryId;
        this.productId = productId;
        this.address = address;
        this.distance = distance;
        this.quantity = quantity;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
