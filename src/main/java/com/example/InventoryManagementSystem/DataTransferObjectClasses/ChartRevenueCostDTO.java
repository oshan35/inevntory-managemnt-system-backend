package com.example.InventoryManagementSystem.DataTransferObjectClasses;

import java.util.List;

public class ChartRevenueCostDTO {
    private String name;
    private String type = "column";
    private List<Double> transactions;

    public ChartRevenueCostDTO(String name, String type, List<Double> transactions) {
        this.name = name;
        this.type = type;
        this.transactions = transactions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Double> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Double> transactions) {
        this.transactions = transactions;
    }
}
