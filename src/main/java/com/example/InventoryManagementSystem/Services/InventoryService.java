package com.example.InventoryManagementSystem.Services;

import com.example.InventoryManagementSystem.Models.Inventory;
import com.example.InventoryManagementSystem.Repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    private InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }


    public Inventory createNewInventory(Inventory inventory){
        return inventoryRepository.save(inventory);
    }

}
