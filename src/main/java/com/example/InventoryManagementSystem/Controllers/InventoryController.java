package com.example.InventoryManagementSystem.Controllers;

import com.example.InventoryManagementSystem.Models.Inventory;
import com.example.InventoryManagementSystem.Models.Transaction;
import com.example.InventoryManagementSystem.Services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
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

    @GetMapping("/transactions/{inventoryID}")
    public ResponseEntity<List<Transaction>> getAllTransactions(@RequestParam String inventoryID){
        List<Transaction> transactions = inventoryService.getAllTransactions(inventoryID);

        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/by-productID/{inventoryId}/{productId}")
    public ResponseEntity<ArrayList<Map<String,String>>> getInventoriesByProduct(
            @PathVariable String inventoryId,
            @PathVariable String productId){
        ArrayList<Map<String,String>> inventories = inventoryService.getNearestInventries(inventoryId, productId);
        return ResponseEntity.ok(inventories);
    }


}
