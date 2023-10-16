package com.example.InventoryManagementSystem.Services;

import com.example.InventoryManagementSystem.Models.Admin;
import com.example.InventoryManagementSystem.Models.Inventory;
import com.example.InventoryManagementSystem.Repositories.AdminRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public Pair<String, Boolean> authenticate(String username, String password) {

        Optional<Admin> adminOpt = adminRepository.findByAdminUserNameAndPassword(username, password);
        String adminId = adminRepository.findAdmin(username,password);
        Pair<String, Boolean> pair =new ImmutablePair<>(adminId,adminOpt.isPresent());
        return pair;
    }

    public List<Inventory> getAdminInventory(String adminID){
        List<Inventory> adminInventories = adminRepository.findAllByAdminId(adminID);
        return adminInventories;
    }

}
