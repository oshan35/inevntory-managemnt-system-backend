package com.example.InventoryManagementSystem.Controllers;

import com.example.InventoryManagementSystem.Models.Inventory;
import com.example.InventoryManagementSystem.Services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
