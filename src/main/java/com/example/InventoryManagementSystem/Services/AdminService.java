package com.example.InventoryManagementSystem.Services;

import com.example.InventoryManagementSystem.DataTransferObjectClasses.InventoryDTO;
import com.example.InventoryManagementSystem.DataTransferObjectClasses.InventoryTableDTO;
import com.example.InventoryManagementSystem.Models.Admin;
import com.example.InventoryManagementSystem.Models.Inventory;
import com.example.InventoryManagementSystem.Repositories.AdminRepository;
import com.example.InventoryManagementSystem.Repositories.InventoryRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AdminService {

    private AdminRepository adminRepository;
    private InventoryRepository inventoryRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository, InventoryRepository inventoryRepository) {
        this.adminRepository = adminRepository;
        this.inventoryRepository = inventoryRepository;
    }

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

    public Inventory addNewInventory(InventoryDTO inventoryDTO){
        Inventory inventory = new Inventory();
        Admin admin = adminRepository.finById(inventoryDTO.getAdmin_id());
        inventory.setAdmin(admin);
        inventory.setInventoryId(inventoryDTO.getInventoryId());
        inventory.setUserName(inventoryDTO.getUserName());
        inventory.setPassword(inventoryDTO.getPassword());
        inventory.setContactNo(inventoryDTO.getTelNo());
        inventory.setEmail(inventoryDTO.getEmail());
        inventory.setOfficialAddress(inventoryDTO.getAddress());
        inventory.setNoOfEmployees(inventoryDTO.getNoOfEmployee());
        inventory.setMaxStockCapacity(inventoryDTO.getMaxStockCap());
        inventory.setAvailableStocks(inventoryDTO.getAvailableStockQuantity());
        inventory.setLongitude((double) inventoryDTO.getLongitude());
        inventory.setLatitude((double) inventoryDTO.getLatitude());

        return inventoryRepository.save(inventory);

    }

    public List<InventoryTableDTO> getAllInventoriesByAminId(String adminId){
        List<Inventory> inventoryList = adminRepository.findAllByAdminId(adminId);
        List<InventoryTableDTO> inventoryTableDTOSList = new ArrayList<>();
        for (Inventory inventory:inventoryList){
            InventoryTableDTO inventoryTableDTO = new InventoryTableDTO();
            inventoryTableDTO.setInventoryId(inventory.getInventoryId());
            inventoryTableDTO.setAddress(inventory.getOfficialAddress());
            inventoryTableDTO.setAvailableStockQuantity(inventory.getAvailableStocks());
            inventoryTableDTO.setTelNo(inventory.getContactNo());
            inventoryTableDTO.setMaxStockCap(inventory.getMaxStockCapacity());
            inventoryTableDTO.setNoOfEmployee(inventory.getNoOfEmployees());
            inventoryTableDTO.setEmail(inventory.getEmail());
            inventoryTableDTOSList.add(inventoryTableDTO);
        }

        return inventoryTableDTOSList;
    }

}
