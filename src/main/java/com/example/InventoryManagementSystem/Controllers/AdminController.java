package com.example.InventoryManagementSystem.Controllers;

import com.example.InventoryManagementSystem.Models.Admin;
import com.example.InventoryManagementSystem.Models.Inventory;
import com.example.InventoryManagementSystem.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Admin admin){
        boolean isAuthenticated = adminService.authenticate(admin.getAdminUserName(), admin.getPassword());
        if (isAuthenticated) {
            return ResponseEntity.ok("Logged in successfully");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
        }
    }

    @GetMapping("/inventories/{adminID}")
    public ResponseEntity<List<Inventory>> getAdminInventories(@RequestParam String adminID){
        List<Inventory> inventoryList = adminService.getAdminInventory(adminID);
        return ResponseEntity.ok(inventoryList);
    }
}
