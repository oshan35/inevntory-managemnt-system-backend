package com.example.InventoryManagementSystem.Repositories;
import com.example.InventoryManagementSystem.Models.InventoryProduct;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface InventoryProductRepository extends JpaRepository<InventoryProduct,String> {

    @Query("SELECT availableQuantity FROM InventoryProduct ip WHERE ip.product.productId = :productId AND ip.inventory.inventoryId = :inventoryId")
    int findQuantityByInventoryAndProductId(@Param("productId") String productId, @Param("inventoryId") String inventoryId);

    @Query("SELECT ip FROM InventoryProduct ip WHERE ip.product.productId = :productId AND ip.inventory.inventoryId = :inventoryId")
    InventoryProduct findInventoryProduct(@Param("productId") String productId, @Param("inventoryId") String inventoryId);

    @Query("SELECT ip FROM InventoryProduct ip WHERE ip.product.productId = :productId")
    List<InventoryProduct> findByProductId(@Param("productId") String productId);

}
