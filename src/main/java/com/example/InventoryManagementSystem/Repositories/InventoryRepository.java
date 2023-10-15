package com.example.InventoryManagementSystem.Repositories;

import com.example.InventoryManagementSystem.Models.Inventory;
import com.example.InventoryManagementSystem.Models.InventoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory,String> {
    @Query("SELECT ip.inventory FROM InventoryProduct ip WHERE ip.product.productId = :productId")
    List<Inventory> findInventoriesByProductId(@Param("productId") String productId);

    Inventory findInventoryByInventoryId(String inventoryId);

}
