package com.example.InventoryManagementSystem.Repositories;
import com.example.InventoryManagementSystem.Models.InventoryProduct;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InventoryProductRepository extends JpaRepository<InventoryProduct,String> {
    @Query("SELECT availableQuantity FROM InventoryProduct ip WHERE ip.product.productId = :productId AND ip.inventory.inventoryId = :inventoryId")
    int findQuantityByInventoryAndProductId(@Param("productId") String productId, @Param("inventoryId") String inventoryId);

}
