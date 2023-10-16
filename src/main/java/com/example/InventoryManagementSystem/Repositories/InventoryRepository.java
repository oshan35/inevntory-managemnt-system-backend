package com.example.InventoryManagementSystem.Repositories;

import com.example.InventoryManagementSystem.Models.Admin;
import com.example.InventoryManagementSystem.Models.Inventory;
import com.example.InventoryManagementSystem.Models.InventoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory,String> {
    @Query("SELECT ip.inventory FROM InventoryProduct ip WHERE ip.product.productId = :productId")
    List<Inventory> findInventoriesByProductId(@Param("productId") String productId);

    Inventory findInventoryByInventoryId(String inventoryId);

    Optional<Inventory> findInventoryByUserNameAndPassword(String username, String password);

    @Query("SELECT i.inventoryId FROM Inventory i WHERE i.userName = :userName AND i.password= :password")
    String findInventory(@Param("userName") String userName, @Param("password") String password);

}
