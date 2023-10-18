package com.example.InventoryManagementSystem.Services;

import com.example.InventoryManagementSystem.DataTransferObjectClasses.NewProductDTO;
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
        System.out.println(newProduct.getProductId());
        Product product = new Product(newProduct.getProductId(),newProduct.getProductName(), newProduct.getUnitPrice(), newProduct.getDescription());
        Inventory inventory = inventoryRepository.findInventoryByInventoryId(newProduct.getInventoryId());
        productRepository.save(product);

        InventoryProduct inventoryProduct = new InventoryProduct(new InventoryProductKey(product.getProductId(), inventory.getInventoryId()),product,inventory,10);
        //System.out.println("TEST: "+inventoryProduct.getInventory().getInventoryId());
        inventoryProductRepository.save(inventoryProduct);

        return product;
    }

    public List<Product> productList(String inventoryId){
        List<Product> productList = productRepository.selectAllProductsByInventoryId(inventoryId);
        return productList;
    }

    public Product deleteProduct(String productId){
        Product product = productRepository.findProductByProductId(productId);
        List<InventoryProduct> inventoryProductList = inventoryProductRepository.findByProductId(productId);
        if (inventoryProductList != null){
            for (InventoryProduct inventoryProduct:inventoryProductList){
                inventoryProductRepository.delete(inventoryProduct);
            }
        }

        if (product != null){
            productRepository.delete(product);
            System.out.println("Product Sucessfully deleted!");
        }else{
            System.out.println("Product Could Not Found!");

        }

        return product;
    }

    public Product updateProduct(String productId, NewProductDTO productDTO){
        Product product = productRepository.findProductByProductId(productId);
        if (product !=null){
            product.setProductName(productDTO.getProductName());
            product.setUnitPrice(productDTO.getUnitPrice());
            product.setDescription(productDTO.getDescription());
            productRepository.save(product);
            System.out.println("Product Details Updated!");
            return product;
        }

        return null;
    }

}
