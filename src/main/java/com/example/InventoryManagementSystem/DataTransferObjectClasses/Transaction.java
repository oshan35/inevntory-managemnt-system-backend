package com.example.InventoryManagementSystem.DataTransferObjectClasses;

import java.util.Date;

public class Transaction implements Comparable<Transaction>{

    private String transactionID;

    private String productID;

    private Date date;

    private Integer quantity;

    private Double unitPrice;

    private Double total;

    private String type;

    public Transaction(String transactionID, String productID, Date date, Integer quantity, Double unitPrice, Double total, String type) {
        this.transactionID = transactionID;
        this.productID = productID;
        this.date = date;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.total = total;
        this.type = type;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getProduct() {
        return productID;
    }

    public void setProduct(String productID) {
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

    @Override
    public int compareTo(Transaction o) {
        return getDate().compareTo(o.getDate());
    }
}
