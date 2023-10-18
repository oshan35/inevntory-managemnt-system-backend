package com.example.InventoryManagementSystem.DataTransferObjectClasses;

import java.util.List;

public class TopFiveYearDTO {
    private List<String> names;
    private List<Double> values;

    public TopFiveYearDTO() {
    }

    public TopFiveYearDTO(List<String> names, List<Double> values) {
        this.names = names;
        this.values = values;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public List<Double> getValues() {
        return values;
    }

    public void setValues(List<Double> values) {
        this.values = values;
    }
}
