package com.example.InventoryManagementSystem.Models;

import jakarta.persistence.*;
import jakarta.persistence.Id;

@Entity
@Table(name = "InventoryProduct")
public class InventoryProduct {
    @Id
    @ManyToOne
    @JoinColumn(name = "productID", referencedColumnName = "productID")
    private Product productId;

    @Id
    @ManyToOne
    @JoinColumn(name = "inventoryID", referencedColumnName = "inventory_id")
    private Inventory inventory;

    @Column(name = "availableQuantity")
    private Integer availableQuantity;

    public InventoryProduct() {
    }

    public InventoryProduct(Product productId, Inventory inventory, Integer availableQuantity) {
        this.productId = productId;
        this.inventory = inventory;
        this.availableQuantity = availableQuantity;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }
}
