package com.example.InventoryManagementSystem.DataTransferObjectClasses;

import com.example.InventoryManagementSystem.Models.Product;

public class NewProductDTO {

    private String inventoryId;

    private Product product;

    public NewProductDTO(String inventoryId, Product product) {
        this.inventoryId = inventoryId;
        this.product = product;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
