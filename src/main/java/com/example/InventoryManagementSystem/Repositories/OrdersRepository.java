package com.example.InventoryManagementSystem.Repositories;

import com.example.InventoryManagementSystem.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Order, String> {
}
