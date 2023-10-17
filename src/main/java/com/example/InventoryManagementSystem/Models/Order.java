package com.example.InventoryManagementSystem.Models;

import jakarta.persistence.*;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @Column(name = "orderID", nullable = false, length = 50)
    private String orderID;

    @ManyToOne
    @JoinColumn(name = "productID", referencedColumnName = "productID")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "supplierID", referencedColumnName = "supplierID")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "inventoryID", referencedColumnName = "inventory_id")
    private Inventory inventory;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "unitPrice", precision = 10, scale = 2)
    private Double unitPrice;

    @Column(name = "total", precision = 10, scale = 2)
    private Double total;

    public Order() {
    }

    public Order(String orderID, Product product, Supplier supplier, Inventory inventory, Date date, Integer quantity, Double unitPrice, Double total) {
        this.orderID = orderID;
        this.product = product;
        this.supplier = supplier;
        this.inventory = inventory;
        this.date = date;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.total = total;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
