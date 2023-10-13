package com.example.InventoryManagementSystem.Repositories;

import com.example.InventoryManagementSystem.Models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory,String> {

}
