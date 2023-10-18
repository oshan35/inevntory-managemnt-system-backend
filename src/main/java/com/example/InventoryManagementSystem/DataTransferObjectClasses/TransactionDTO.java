package com.example.InventoryManagementSystem.DataTransferObjectClasses;

import com.example.InventoryManagementSystem.Models.Inventory;

import java.util.Date;

public class TransactionDTO {

    private String inventoryId;

    private String transactionID;

    private String productID;

    private Date date;

    private Integer quantity;

    private Double unitPrice;

    private Double total;

    private String type;

    public TransactionDTO() {
    }

    public TransactionDTO(String inventoryId, String transactionID, String productID, Date date, Integer quantity, Double unitPrice, Double total, String type) {
        this.inventoryId = inventoryId;
        this.transactionID = transactionID;
        this.productID = productID;
        this.date = date;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.total = total;
        this.type = type;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
