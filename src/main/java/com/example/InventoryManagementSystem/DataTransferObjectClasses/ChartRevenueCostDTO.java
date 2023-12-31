package com.example.InventoryManagementSystem.DataTransferObjectClasses;

import java.util.List;

public class ChartRevenueCostDTO {
    private String name;
    private String type = "column";
    private List<Double> data;

    public ChartRevenueCostDTO(String name, String type, List<Double> data) {
        this.name = name;
        this.type = type;
        this.data = data;
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

    public List<Double> getData() {
        return data;
    }

    public void setData(List<Double> data) {
        this.data = data;
    }
}
