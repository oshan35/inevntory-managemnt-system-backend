package com.example.InventoryManagementSystem.Services;

import com.example.InventoryManagementSystem.Models.Inventory;
import com.example.InventoryManagementSystem.Models.Order;
import com.example.InventoryManagementSystem.Models.Sales;
import com.example.InventoryManagementSystem.Models.Transaction;
import com.example.InventoryManagementSystem.Repositories.InventoryProductRepository;
import com.example.InventoryManagementSystem.Repositories.InventoryRepository;
import com.example.InventoryManagementSystem.Repositories.OrdersRepository;
import com.example.InventoryManagementSystem.Repositories.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InventoryService {
    private InventoryRepository inventoryRepository;
    private OrdersRepository ordersRepository;
    private SalesRepository salesRepository;
    private InventoryProductRepository inventoryProductRepository;


    @Autowired
    public InventoryService(InventoryRepository inventoryRepository,OrdersRepository ordersRepository, SalesRepository salesRepository, InventoryProductRepository inventoryProductRepository){

        this.inventoryRepository = inventoryRepository;
        this.salesRepository = salesRepository;
        this.ordersRepository = ordersRepository;
        this.inventoryRepository = inventoryRepository;
    }


    public Inventory createNewInventory(Inventory inventory){
        return inventoryRepository.save(inventory);
    }


    public List<Transaction> getAllTransactions(String inventoryID){
        List<Order> orders = ordersRepository.findAllByInventoryId(inventoryID);
        List<Sales> sales = salesRepository.findAllByInventoryId(inventoryID);
        List<Transaction> transactionsList = new ArrayList<Transaction>();
        for (Order order:orders){
            Transaction transaction = new Transaction(order.getOrderID(),order.getProduct().getProductId(),order.getDate(),order.getQuantity(),order.getUnitPrice(),order.getTotal(),"Buy");
            transactionsList.add(transaction);
        }

        for (Sales sale:sales){
            Transaction transaction = new Transaction(sale.getSalesID(),sale.getProduct().getProductId(),sale.getDate(),sale.getQuantity(),sale.getUnitPrice(),sale.getTotal(),"Sell");
            transactionsList.add(transaction);
        }

        Collections.sort(transactionsList);
        return transactionsList;

    }

    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final double EARTH_RADIUS = 6371;


        // Convert degrees to radians
        lat1 = Math.toRadians(lat1);
        lon1 = Math.toRadians(lon1);
        lat2 = Math.toRadians(lat2);
        lon2 = Math.toRadians(lon2);

        // Apply Haversine formula
        double latDifference = lat2 - lat1;
        double lonDifference = lon2 - lon1;

        double a = Math.pow(Math.sin(latDifference / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(lonDifference / 2),2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        return EARTH_RADIUS * c;
    }

    public ArrayList<Map<String,String>>getNearestInventries(String inventoryID, String productID){
        List<Inventory> availableInventoryList = inventoryRepository.findInventoriesByProductId(productID);
        Inventory currentInventory = inventoryRepository.findInventoryByInventoryId(inventoryID);

        ArrayList<Map<String,String>> inventorySearchResult = new ArrayList<Map<String,String>>();

        for (Inventory inventory:availableInventoryList){
            Map<String,String> inventoryObj = new HashMap<>();
            double distance = calculateDistance(currentInventory.getLatitude(),currentInventory.getLongitude(),inventory.getLatitude(),inventory.getLongitude());
            int quantity = inventoryProductRepository.findQuantityByInventoryAndProductId(inventory.getInventoryId(),productID);
            inventoryObj.put("inventoryId",inventory.getInventoryId());
            inventoryObj.put("productId",productID);
            inventoryObj.put("location",inventory.getOfficialAddress());
            inventoryObj.put("distance",String.valueOf(distance));
            inventoryObj.put("Quantity",String.valueOf(quantity));

            inventorySearchResult.add(inventoryObj);

        }
        return inventorySearchResult;
    }
}
