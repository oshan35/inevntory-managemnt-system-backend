package com.example.InventoryManagementSystem.DataTransferObjectClasses;

import com.example.InventoryManagementSystem.Models.Inventory;

public class TransactionDTO {

    private String inventoryId;
    private Transaction transaction;

    public TransactionDTO(String inventoryId, Transaction transaction) {
        this.inventoryId = inventoryId;
        this.transaction = transaction;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
