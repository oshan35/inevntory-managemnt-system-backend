package com.example.InventoryManagementSystem.Repositories;

import com.example.InventoryManagementSystem.Models.Inventory;
import com.example.InventoryManagementSystem.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Order, String> {

    @Query("SELECT i FROM Order i WHERE i.inventory.inventoryId = :inventoryID")
    List<Order> findAllByInventoryId(String inventoryID);

}
