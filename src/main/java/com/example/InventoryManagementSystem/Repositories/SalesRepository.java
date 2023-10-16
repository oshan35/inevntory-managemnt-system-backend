package com.example.InventoryManagementSystem.Repositories;

import com.example.InventoryManagementSystem.Models.Order;
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

}
