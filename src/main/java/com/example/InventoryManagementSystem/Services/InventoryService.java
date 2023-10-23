package com.example.InventoryManagementSystem.Services;

import com.example.InventoryManagementSystem.DataTransferObjectClasses.ChartRevenueCostDTO;
import com.example.InventoryManagementSystem.DataTransferObjectClasses.NearestAvailableInventoryDTO;
import com.example.InventoryManagementSystem.Models.Inventory;
import com.example.InventoryManagementSystem.Models.Order;
import com.example.InventoryManagementSystem.Models.Sales;
import com.example.InventoryManagementSystem.DataTransferObjectClasses.Transaction;
import com.example.InventoryManagementSystem.Repositories.InventoryProductRepository;
import com.example.InventoryManagementSystem.Repositories.InventoryRepository;
import com.example.InventoryManagementSystem.Repositories.OrdersRepository;
import com.example.InventoryManagementSystem.Repositories.SalesRepository;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
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
        this.salesRepository = salesRepository;
        this.ordersRepository = ordersRepository;
        this.inventoryRepository = inventoryRepository;
        this.inventoryProductRepository = inventoryProductRepository;
    }


    public Inventory createNewInventory(Inventory inventory){
        return inventoryRepository.save(inventory);
    }

    public Pair<String, Boolean> authenticateLogin(String userName, String password){
        Optional<Inventory> inventoryOpt = inventoryRepository.findInventoryByUserNameAndPassword(userName,password);
        String inventoryId = inventoryRepository.findInventory(userName,password);

        Pair<String, Boolean> res = new ImmutablePair<>(inventoryId,inventoryOpt.isPresent());
        return res;

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

        lat1 = Math.toRadians(lat1);
        lon1 = Math.toRadians(lon1);
        lat2 = Math.toRadians(lat2);
        lon2 = Math.toRadians(lon2);

        double latDifference = lat2 - lat1;
        double lonDifference = lon2 - lon1;

        double a = Math.pow(Math.sin(latDifference / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(lonDifference / 2),2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double val = Math.round(EARTH_RADIUS * c)/100.0;
        return val;
    }

    public List<NearestAvailableInventoryDTO> getNearestInventries(String inventoryID, String productID){
        List<Inventory> availableInventoryList = inventoryRepository.findInventoriesByProductId(productID);
        Inventory currentInventory = inventoryRepository.findInventoryByInventoryId(inventoryID);

        List<NearestAvailableInventoryDTO> nearestAvailableInventoryDTOList = new ArrayList<>();

        for (Inventory inventory:availableInventoryList){

            double distance = calculateDistance(currentInventory.getLatitude(),currentInventory.getLongitude(),inventory.getLatitude(),inventory.getLongitude());
            int quantity = inventoryProductRepository.findQuantityByInventoryAndProductId(productID,inventory.getInventoryId());
            NearestAvailableInventoryDTO newDTO = new NearestAvailableInventoryDTO(inventory.getInventoryId(),productID,inventory.getOfficialAddress(),distance,quantity);

            nearestAvailableInventoryDTOList.add(newDTO);

        }
        return nearestAvailableInventoryDTOList;
    }

    public List<ChartRevenueCostDTO> getCostRevenueChartData(String inventoryID){
        List<Object[]> costListGroupedByMonth = ordersRepository.findTotalOrderByMonthForInventory(inventoryID);
        List<Object[]> salesListGroupedByMonth = salesRepository.findTotalSalesByMonthForInventory(inventoryID);

        List<ChartRevenueCostDTO> costRevaue = new ArrayList<ChartRevenueCostDTO>();

        List<Double> costList = new ArrayList<>();
        List<Double> salesList = new ArrayList<>();

        for (Object[] cost:costListGroupedByMonth){
            costList.add((Double) cost[0]);
        }

        for (Object[] sales:salesListGroupedByMonth){
            salesList.add((Double) sales[0]);
        }

        ChartRevenueCostDTO cost = new ChartRevenueCostDTO("Cost","column",costList);

        ChartRevenueCostDTO sales = new ChartRevenueCostDTO("Revenue","column",salesList);

        costRevaue.add(sales);
        costRevaue.add(cost);

        return costRevaue;
    }
}
