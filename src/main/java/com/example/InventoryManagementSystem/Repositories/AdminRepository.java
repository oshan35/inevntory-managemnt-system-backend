package com.example.InventoryManagementSystem.Repositories;

import com.example.InventoryManagementSystem.Models.Admin;
import com.example.InventoryManagementSystem.Models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,String> {
    Optional<Admin> findByAdminUserNameAndPassword(String username, String password);

    @Query("SELECT i FROM Inventory i WHERE i.admin.adminId = :adminId")
    List<Inventory> findAllByAdminId(String adminId);
}
