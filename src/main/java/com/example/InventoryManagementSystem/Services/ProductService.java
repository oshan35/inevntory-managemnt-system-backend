package com.example.InventoryManagementSystem.Services;

import com.example.InventoryManagementSystem.DataTransferObjectClasses.NewProductDTO;
import com.example.InventoryManagementSystem.DataTransferObjectClasses.Transaction;
import com.example.InventoryManagementSystem.DataTransferObjectClasses.TransactionDTO;
import com.example.InventoryManagementSystem.Models.*;
import com.example.InventoryManagementSystem.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private InventoryProductRepository inventoryProductRepository;
    private InventoryRepository inventoryRepository;
    private OrdersRepository ordersRepository;
    private SalesRepository salesRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, InventoryProductRepository inventoryProductRepository, InventoryRepository inventoryRepository, OrdersRepository ordersRepository,SalesRepository salesRepository) {
        this.productRepository = productRepository;
        this.inventoryProductRepository = inventoryProductRepository;
        this.inventoryRepository = inventoryRepository;
        this.ordersRepository = ordersRepository;
        this.salesRepository = salesRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product createProduct(NewProductDTO newProduct){
        System.out.println(newProduct.getInventoryId());
        Inventory inventory = inventoryRepository.findInventoryByInventoryId(newProduct.getInventoryId());
        productRepository.save(newProduct.getProduct());
        InventoryProduct inventoryProduct = new InventoryProduct(newProduct.getProduct(),inventory,10);
        if (inventoryProduct != null){
            inventoryProductRepository.save(inventoryProduct);
        }else{
            System.out.println(inventoryProduct.getInventory().getInventoryId());
        }

        return newProduct.getProduct();
    }

    public List<Product> productList(String inventoryId){
        List<Product> productList = productRepository.selectAllProductsByInventoryId(inventoryId);
        return productList;
    }


}
