package com.example.InventoryManagementSystem.Controllers;

import com.example.InventoryManagementSystem.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestParam String userName, String password){
        adminService.loginAuthentication(userName,password);

        return ResponseEntity.ok("Logged in successfully");
    }

}
