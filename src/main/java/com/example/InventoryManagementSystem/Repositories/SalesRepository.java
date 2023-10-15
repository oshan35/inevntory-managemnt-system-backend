package com.example.InventoryManagementSystem.Repositories;

import com.example.InventoryManagementSystem.Models.Order;
import com.example.InventoryManagementSystem.Models.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SalesRepository extends JpaRepository<Sales, String> {

    @Query("SELECT i FROM Sales i WHERE i.inventory.inventoryId = :inventoryID")
    List<Sales> findAllByInventoryId(String inventoryID);

}
