package com.example.InventoryManagementSystem.Controllers;

import com.example.InventoryManagementSystem.Models.Product;
import com.example.InventoryManagementSystem.Services.ProductService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.ProtectionDomain;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }


    @PostMapping("/new")
    public Product createNewProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

}
