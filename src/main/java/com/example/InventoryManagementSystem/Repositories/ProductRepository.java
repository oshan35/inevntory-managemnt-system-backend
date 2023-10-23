package com.example.InventoryManagementSystem.Repositories;

import com.example.InventoryManagementSystem.Models.Inventory;
import com.example.InventoryManagementSystem.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {

    @Query("SELECT p FROM Product p JOIN InventoryProduct ip ON p.productId = ip.product.productId WHERE ip.inventory.inventoryId = :inventoryId")
    List<Product> selectAllProductsByInventoryId(@Param("inventoryId") String inventoryId);

    Product findProductByProductId(String productId);

    boolean existsByProductId(String productId);

}
