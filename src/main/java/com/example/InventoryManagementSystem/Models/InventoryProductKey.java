package com.example.InventoryManagementSystem.Models;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class InventoryProductKey implements Serializable {
    @Column(name = "productID")
    private String productId;

    @Column(name = "inventoryID")
    private String inventoryId;

    public InventoryProductKey() {
    }

    public InventoryProductKey(String productId, String inventoryId) {
        this.productId = productId;
        this.inventoryId = inventoryId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }
}