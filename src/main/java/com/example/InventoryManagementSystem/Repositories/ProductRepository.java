package com.example.InventoryManagementSystem.Repositories;

import com.example.InventoryManagementSystem.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {

}
