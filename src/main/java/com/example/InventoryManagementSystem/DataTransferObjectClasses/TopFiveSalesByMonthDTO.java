package com.example.InventoryManagementSystem.DataTransferObjectClasses;

import java.util.List;

public class TopFiveSalesByMonthDTO {
    private String name;
    private Double[] data;

    public TopFiveSalesByMonthDTO() {
    }

    public TopFiveSalesByMonthDTO(String name, Double[] data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double[] getData() {
        return data;
    }

    public void setData(Double[] data) {
        this.data = data;
    }
}
