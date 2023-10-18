package com.example.InventoryManagementSystem.Controllers;

import com.example.InventoryManagementSystem.DataTransferObjectClasses.*;
import com.example.InventoryManagementSystem.Models.Inventory;
import com.example.InventoryManagementSystem.Services.InventoryService;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService){
        this.inventoryService = inventoryService;
    }

    @PostMapping
    public ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory){
        Inventory newInventory = inventoryService.createNewInventory(inventory);
        return ResponseEntity.ok(newInventory);
    }

    @PostMapping("/login")
    public ResponseEntity<String> inventoryLoginAuthentication(@RequestBody InventoryLoginDTO inventoryLoginDTO){
        Pair<String, Boolean> response = inventoryService.authenticateLogin(inventoryLoginDTO.getInventoryUserName(),inventoryLoginDTO.getInventoryPassword());
        if (response.getValue()) {
            return ResponseEntity.ok(response.getKey());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
        }
    }

    @GetMapping("/transactions/{inventoryID}")
    public ResponseEntity<List<Transaction>> getAllTransactions(@PathVariable String inventoryID){
        List<Transaction> transactions = inventoryService.getAllTransactions(inventoryID);

        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/by-productID/{inventoryId}/{productId}")
    public ResponseEntity<List<NearestAvailableInventoryDTO>> getInventoriesByProduct(
            @PathVariable String inventoryId,
            @PathVariable String productId){
        List<NearestAvailableInventoryDTO> inventories = inventoryService.getNearestInventries(inventoryId, productId);
        return ResponseEntity.ok(inventories);
    }

    @GetMapping("/cost-Revenue/{inventoryId}")
    public ResponseEntity<List<ChartRevenueCostDTO>> getCostRevenueData(@PathVariable String inventoryId){
        List<ChartRevenueCostDTO> costRevenueData = inventoryService.getCostRevenueChartData(inventoryId);

        return ResponseEntity.ok(costRevenueData);
    }

}
