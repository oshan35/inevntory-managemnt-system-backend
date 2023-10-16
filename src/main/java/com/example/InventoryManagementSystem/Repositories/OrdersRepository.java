package com.example.InventoryManagementSystem.Repositories;

import com.example.InventoryManagementSystem.Models.Inventory;
import com.example.InventoryManagementSystem.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Order, String> {

    @Query("SELECT i FROM Order i WHERE i.inventory.inventoryId = :inventoryID")
    List<Order> findAllByInventoryId(String inventoryID);

    @Query("SELECT SUM(o.total), FUNCTION('MONTH', o.date) " +
            "FROM Order o " +
            "WHERE o.inventory.inventoryId = :inventoryId " +
            "GROUP BY FUNCTION('MONTH', o.date)")
    List<Object[]> findTotalOrderByMonthForInventory(@Param("inventoryId") String inventoryId);

}
