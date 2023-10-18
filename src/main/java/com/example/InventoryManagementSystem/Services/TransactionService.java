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


    public TransactionDTO addTransaction(TransactionDTO transaction){
        Product product = productRepository.findProductByProductId(transaction.getProductID());
        InventoryProduct inventoryProduct = inventoryProductRepository.findInventoryProduct(transaction.getProductID(),transaction.getInventoryId());
        Inventory inventory = inventoryRepository.findInventoryByInventoryId(transaction.getInventoryId());
        if (transaction.getType().equals("Buy")){
            Order newOrder = new Order();
            newOrder.setOrderID(transaction.getTransactionID());
            newOrder.setProduct(product);
            newOrder.setInventory(inventory);
            newOrder.setDate(transaction.getDate());
            newOrder.setQuantity(transaction.getQuantity());
            newOrder.setUnitPrice(transaction.getUnitPrice());
            newOrder.setTotal(transaction.getTotal());

            inventoryProduct.setAvailableQuantity(inventoryProduct.getAvailableQuantity()+transaction.getQuantity());
            inventoryProductRepository.save(inventoryProduct);
            ordersRepository.save(newOrder);

            return transaction;
        }else if (transaction.getType().equals("Sell")){
            if (inventoryProduct.getAvailableQuantity()>transaction.getQuantity()){
                Sales newSale = new Sales();
                newSale.setSalesID(transaction.getTransactionID());
                newSale.setProduct(product);
                newSale.setInventory(inventory);
                newSale.setDate(transaction.getDate());
                newSale.setQuantity(transaction.getQuantity());
                newSale.setUnitPrice(transaction.getUnitPrice());
                newSale.setTotal(transaction.getTotal());

                inventoryProduct.setAvailableQuantity(inventoryProduct.getAvailableQuantity() - transaction.getQuantity());
                inventoryProductRepository.save(inventoryProduct);
                salesRepository.save(newSale);
                return transaction;
            }else{
                System.out.println("Transaction failed due to insufficient inventory");
                return null;
            }

        }
        return null;
    }
}
