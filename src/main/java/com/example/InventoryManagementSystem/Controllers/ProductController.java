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
    public ResponseEntity<NewProductDTO> createNewProduct(@RequestBody NewProductDTO newProduct){
        NewProductDTO response = productService.createProduct(newProduct);
       return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete-product/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable String productId) {
        Product response = productService.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable String productId, @RequestBody NewProductDTO updatedProductDetails) {
        Product updatedProduct = productService.updateProduct(productId, updatedProductDetails);
        if (updatedProduct == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedProduct);
    }

}
