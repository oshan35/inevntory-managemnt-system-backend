package com.example.InventoryManagementSystem.Repositories;

import com.example.InventoryManagementSystem.Models.Order;
import com.example.InventoryManagementSystem.Models.Product;
import com.example.InventoryManagementSystem.Models.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SalesRepository extends JpaRepository<Sales, String> {

    @Query("SELECT i FROM Sales i WHERE i.inventory.inventoryId = :inventoryID")
    List<Sales> findAllByInventoryId(String inventoryID);

    @Query("SELECT SUM(s.total), FUNCTION('MONTH', s.date) " +
            "FROM Sales s " +
            "WHERE s.inventory.inventoryId = :inventoryId " +
            "GROUP BY FUNCTION('MONTH', s.date)")
    List<Object[]> findTotalSalesByMonthForInventory(@Param("inventoryId") String inventoryId);


    @Query("SELECT s.product " +
            "FROM Sales s " +
            "WHERE s.inventory.inventoryId = :inventoryId " +
            "GROUP BY s.product.productId " +
            "ORDER BY SUM(s.quantity) DESC")
    List<Product> findTop5BestSellingProductsByInventoryId(@Param("inventoryId") String inventoryId);


    @Query("SELECT FUNCTION('MONTH', s.date) as month, SUM(s.quantity) as totalSales " +
            "FROM Sales s " +
            "WHERE s.product.productId = :productId AND s.inventory.inventoryId = :inventoryId " +
            "GROUP BY FUNCTION('MONTH', s.date) " +
            "ORDER BY month ASC")
    List<Object[]> findTotalSalesByProductGroupedByMonth(@Param("inventoryId") String inventoryId,@Param("productId") String productId);




}
