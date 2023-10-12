package com.example.InventoryManagementSystem.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @Column(name = "customerID", nullable = false, length = 50)
    private String customerID;

    @Column(name = "customerName", length = 255)
    private String customerName;

    @Column(name = "contactNo", length = 15)
    private String contactNo;

    @Column(name = "customerAddress", length = 255)
    private String customerAddress;

    public Customer() {
    }

    public Customer(String customerID, String customerName, String contactNo, String customerAddress) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.contactNo = contactNo;
        this.customerAddress = customerAddress;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
}
