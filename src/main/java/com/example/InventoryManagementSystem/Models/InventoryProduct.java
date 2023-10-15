package com.example.InventoryManagementSystem.Models;

import jakarta.persistence.*;
import jakarta.persistence.Id;

import java.io.Serializable;

@Embeddable
class InventoryProductKey implements Serializable {
    @Column(name = "productID")
    private String productId;

    @Column(name = "inventoryID")
    private String inventoryId;

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

@Entity
@Table(name = "InventoryProduct")
public class InventoryProduct {
    @EmbeddedId
    private InventoryProductKey id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "productID")
    private Product product;

    @ManyToOne
    @MapsId("inventoryId")
    @JoinColumn(name = "inventoryID")
    private Inventory inventory;

    @Column(name = "availableQuantity")
    private Integer availableQuantity;

    public InventoryProduct() {
    }

    public InventoryProduct(InventoryProductKey id, Product product, Inventory inventory, Integer availableQuantity) {
        this.id = id;
        this.product = product;
        this.inventory = inventory;
        this.availableQuantity = availableQuantity;
    }

    public InventoryProductKey getId() {
        return id;
    }

    public void setId(InventoryProductKey id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
