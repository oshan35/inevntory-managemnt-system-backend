package com.example.InventoryManagementSystem.Controllers;

import com.example.InventoryManagementSystem.DataTransferObjectClasses.NewProductDTO;
import com.example.InventoryManagementSystem.Models.Product;
import com.example.InventoryManagementSystem.Services.ProductService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.ProtectionDomain;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/all/{inventoryId}")
    public ResponseEntity<List<Product>> getAllProductsForInventory(@PathVariable String inventoryId){
        List<Product> productList = productService.productList(inventoryId);

        return ResponseEntity.ok(productList);
    }

    @PostMapping("/new")
    public ResponseEntity<Product> createNewProduct(@RequestBody NewProductDTO newProduct){
       Product response = productService.createProduct(newProduct);
       return ResponseEntity.ok(response);
    }

}
