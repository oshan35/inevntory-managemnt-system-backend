package com.example.InventoryManagementSystem.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @Column(name = "productID", nullable = false, length = 50)
    private String productID;

    @Column(name = "productName", length = 255)
    private String productName;

    @Column(name = "unitPrice", precision = 10, scale = 2)
    private Double unitPrice;

    @Column(name = "description", columnDefinition="TEXT")
    private String description;

    public Product(){}

    public Product(String productID, String productName, Double unitPrice, String description) {
        this.productID = productID;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.description = description;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
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

    @Override
    public String toString() {
        return "Product{" +
                "productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", unitPrice=" + unitPrice +
                ", description='" + description + '\'' +
                '}';
    }

}

