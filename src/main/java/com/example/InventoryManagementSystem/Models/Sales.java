package com.example.InventoryManagementSystem.Models;

import jakarta.persistence.*;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
@Table(name = "Sales")
public class Sales {

    @Id
    @Column(name = "salesID", nullable = false, length = 50)
    private String salesID;

    @ManyToOne
    @JoinColumn(name = "productID", referencedColumnName = "productID")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "customerID", referencedColumnName = "customerID")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "inventoryID", referencedColumnName = "inventory_id")
    private Inventory inventory;

    @Column(name = "date")
    @Temporal(TemporalType.DATE) // Needed for Date type
    private Date date;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "unitPrice", precision = 10, scale = 2)
    private Double unitPrice;

    @Column(name = "total", precision = 10, scale = 2)
    private Double total;

    public Sales() {
    }

    public Sales(String salesID, Product product, Customer customer,Inventory inventory, Date date, Integer quantity, Double unitPrice, Double total) {
        this.salesID = salesID;
        this.product = product;
        this.customer = customer;
        this.inventory = inventory;
        this.date = date;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.total = total;
    }

    public String getSalesID() {
        return salesID;
    }

    public void setSalesID(String salesID) {
        this.salesID = salesID;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
