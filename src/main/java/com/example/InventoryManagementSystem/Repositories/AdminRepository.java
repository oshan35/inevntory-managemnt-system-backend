package com.example.InventoryManagementSystem.Repositories;

import com.example.InventoryManagementSystem.Models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,String> {
    Admin findByUsernameAndPassword(String username, String password);
}
