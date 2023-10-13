package com.example.InventoryManagementSystem.Repositories;

import com.example.InventoryManagementSystem.Models.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<Sales, String> {
}
