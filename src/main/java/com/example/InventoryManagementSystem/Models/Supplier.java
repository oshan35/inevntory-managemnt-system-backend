package com.example.InventoryManagementSystem.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "Suppliers")
public class Supplier {

    @Id
    @Column(name = "supplierID", nullable = false, length = 50)
    private String supplierID;

    @Column(name = "supplierName", length = 255)
    private String supplierName;

    @Column(name = "contactNo", length = 15)
    private String contactNo;

    public Supplier() {
    }

    public Supplier(String supplierID, String supplierName, String contactNo) {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.contactNo = contactNo;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
}
