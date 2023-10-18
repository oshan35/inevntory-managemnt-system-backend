package com.example.InventoryManagementSystem.Controllers;

import com.example.InventoryManagementSystem.DataTransferObjectClasses.TopFiveSalesByMonthDTO;
import com.example.InventoryManagementSystem.DataTransferObjectClasses.TopFiveYearDTO;
import com.example.InventoryManagementSystem.Services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/sales")
public class SalesController {
    private SalesService salesService;

    @Autowired
    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping("/topFive/{inventoryId}")
    public ResponseEntity<List<TopFiveSalesByMonthDTO>> getTopFiveProducts(@PathVariable String inventoryId){
        List<TopFiveSalesByMonthDTO> res = salesService.getTopFiveSalesForEachMonth(inventoryId);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/top-five-year/{inventoryId}")
    public ResponseEntity<TopFiveYearDTO> getTopFiveByYear(@PathVariable String inventoryId){
        TopFiveYearDTO response = salesService.getTopFiveSalesForOverYear(inventoryId);

        return ResponseEntity.ok(response);
    }
}
