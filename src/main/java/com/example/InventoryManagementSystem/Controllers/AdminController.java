package com.example.InventoryManagementSystem.Controllers;

import com.example.InventoryManagementSystem.DataTransferObjectClasses.AdminLoginDTO;
import com.example.InventoryManagementSystem.DataTransferObjectClasses.InventoryDTO;
import com.example.InventoryManagementSystem.DataTransferObjectClasses.InventoryTableDTO;
import com.example.InventoryManagementSystem.Models.Admin;
import com.example.InventoryManagementSystem.Models.Inventory;
import com.example.InventoryManagementSystem.Services.AdminService;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AdminLoginDTO admin){
        Pair<String, Boolean> auth = adminService.authenticate(admin.getAdminUserName(), admin.getAdminPassword());
        if (auth.getValue()) {
            return ResponseEntity.ok(auth.getKey());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
        }
    }

    @GetMapping("/inventories/{adminID}")
    public ResponseEntity<List<Inventory>> getAdminInventories(@RequestParam String adminID){
        List<Inventory> inventoryList = adminService.getAdminInventory(adminID);
        return ResponseEntity.ok(inventoryList);
    }

    @PostMapping("/new-inventory")
    public ResponseEntity<?> addNewInventory(@RequestBody InventoryDTO inventory){
        Inventory response =adminService.addNewInventory(inventory);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/inventory/{adminId}")
    public ResponseEntity<?> getInventoryDataByAdminId(@PathVariable String adminId){
        List<InventoryTableDTO> response = adminService.getAllInventoriesByAminId(adminId);

        return ResponseEntity.ok(response);
    }
}
