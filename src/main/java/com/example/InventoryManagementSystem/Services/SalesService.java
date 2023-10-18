package com.example.InventoryManagementSystem.Services;

import com.example.InventoryManagementSystem.DataTransferObjectClasses.TopFiveSalesByMonthDTO;
import com.example.InventoryManagementSystem.DataTransferObjectClasses.TopFiveYearDTO;
import com.example.InventoryManagementSystem.Models.Product;
import com.example.InventoryManagementSystem.Repositories.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SalesService {

    private SalesRepository salesRepository;

    @Autowired
    public SalesService(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }


    public List<TopFiveSalesByMonthDTO> getTopFiveSalesForEachMonth(String inventoryId){
        List<Product> topFive = salesRepository.findTop5BestSellingProductsByInventoryId(inventoryId);


        List<TopFiveSalesByMonthDTO> topFiveData = new ArrayList<>();
        for (Product product:topFive){
            TopFiveSalesByMonthDTO topFiveSalesByMonthDTO = new TopFiveSalesByMonthDTO();
            Double[] productMonthlySales =new Double[12];
            Arrays.fill(productMonthlySales, 0.0);

            List<Object[]> details = salesRepository.findTotalSalesByProductGroupedByMonth(inventoryId,product.getProductId());
            for (Object[] objects : details) {
                int index = (Integer) objects[0];
                Double value = ((Long) objects[1]).doubleValue();
                productMonthlySales[index] = value;

            }

            topFiveSalesByMonthDTO.setName(product.getProductName());
            topFiveSalesByMonthDTO.setData(productMonthlySales);
            topFiveData.add(topFiveSalesByMonthDTO);
        }

        return topFiveData;
    }

    public TopFiveYearDTO getTopFiveSalesForOverYear(String inventoryId){
        List<Product> topFive = salesRepository.findTop5BestSellingProductsByInventoryId(inventoryId);
        List<String> names= new ArrayList<>();
        List<Double> totals = new ArrayList<>();
        for (Product product:topFive){
            Double total =0.0;
            names.add(product.getProductName());

            List<Object[]> details = salesRepository.findTotalSalesByProductGroupedByMonth(inventoryId,product.getProductId());
            for (Object[] objects : details) {

                Double value = ((Long) objects[1]).doubleValue();
                total = total+value;
            }
            totals.add(total);
        }

        TopFiveYearDTO topFiveYearDTO= new TopFiveYearDTO();
        topFiveYearDTO.setNames(names);
        topFiveYearDTO.setValues(totals);

        return topFiveYearDTO;
    }

}
