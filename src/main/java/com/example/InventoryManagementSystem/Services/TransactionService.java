package com.example.InventoryManagementSystem.Services;

import com.example.InventoryManagementSystem.DataTransferObjectClasses.Transaction;
import com.example.InventoryManagementSystem.DataTransferObjectClasses.TransactionDTO;
import com.example.InventoryManagementSystem.Models.*;
import com.example.InventoryManagementSystem.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private ProductRepository productRepository;
    private InventoryProductRepository inventoryProductRepository;
    private InventoryRepository inventoryRepository;
    private OrdersRepository ordersRepository;
    private SalesRepository salesRepository;

    @Autowired
    public TransactionService(ProductRepository productRepository, InventoryProductRepository inventoryProductRepository, InventoryRepository inventoryRepository, OrdersRepository ordersRepository, SalesRepository salesRepository) {
        this.productRepository = productRepository;
        this.inventoryProductRepository = inventoryProductRepository;
        this.inventoryRepository = inventoryRepository;
        this.ordersRepository = ordersRepository;
        this.salesRepository = salesRepository;
    }


    public Transaction addTransaction(TransactionDTO transaction){
        Transaction requestBody = transaction.getTransaction();
        Product product = productRepository.findProductByProductId(requestBody.getProduct());
        InventoryProduct inventoryProduct = inventoryProductRepository.findInventoryProduct(requestBody.getProduct(),transaction.getInventoryId());
        Inventory inventory = inventoryRepository.findInventoryByInventoryId(transaction.getInventoryId());
        if (requestBody.getType().equals("Buy")){
            Order newOrder = new Order();
            newOrder.setOrderID(requestBody.getTransactionID());
            newOrder.setProduct(product);
            newOrder.setInventory(inventory);
            newOrder.setDate(requestBody.getDate());
            newOrder.setQuantity(requestBody.getQuantity());
            newOrder.setUnitPrice(requestBody.getUnitPrice());
            newOrder.setTotal(requestBody.getTotal());

            inventoryProduct.setAvailableQuantity(inventoryProduct.getAvailableQuantity()+requestBody.getQuantity());
            inventoryProductRepository.save(inventoryProduct);
            ordersRepository.save(newOrder);

            return transaction.getTransaction();
        }else if (requestBody.getType().equals("Sell")){
            if (inventoryProduct.getAvailableQuantity()>requestBody.getQuantity()){
                Sales newSale = new Sales();
                newSale.setSalesID(requestBody.getTransactionID());
                newSale.setProduct(product);
                newSale.setInventory(inventory);
                newSale.setDate(requestBody.getDate());
                newSale.setQuantity(requestBody.getQuantity());
                newSale.setUnitPrice(requestBody.getUnitPrice());
                newSale.setTotal(requestBody.getTotal());

                inventoryProduct.setAvailableQuantity(inventoryProduct.getAvailableQuantity() - requestBody.getQuantity());
                inventoryProductRepository.save(inventoryProduct);
                salesRepository.save(newSale);
                return transaction.getTransaction();
            }else{
                System.out.println("Transaction failed due to insufficient inventory");
                return null;
            }

        }
        return null;
    }
}
