package com.example.InventoryManagementSystem.Services;

import com.example.InventoryManagementSystem.Models.Admin;
import com.example.InventoryManagementSystem.Models.Inventory;
import com.example.InventoryManagementSystem.Repositories.AdminRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public boolean authenticate(String username, String password) {
        Optional<Admin> adminOpt = adminRepository.findByAdminUserNameAndPassword(username, password);
        return adminOpt.isPresent();
    }

    public List<Inventory> getAdminInventory(String adminID){
        List<Inventory> adminInventories = adminRepository.findAllByAdminId(adminID);
        return adminInventories;
    }

}
