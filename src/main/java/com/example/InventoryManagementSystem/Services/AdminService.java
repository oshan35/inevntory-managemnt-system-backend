package com.example.InventoryManagementSystem.Services;

import com.example.InventoryManagementSystem.Models.Admin;
import com.example.InventoryManagementSystem.Repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public Admin loginAuthentication(String userName, String password){
        return adminRepository.findByUsernameAndPassword(userName,password);
    }

}
