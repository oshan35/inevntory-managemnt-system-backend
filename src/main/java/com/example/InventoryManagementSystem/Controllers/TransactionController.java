package com.example.InventoryManagementSystem.Controllers;

import com.example.InventoryManagementSystem.DataTransferObjectClasses.Transaction;
import com.example.InventoryManagementSystem.DataTransferObjectClasses.TransactionDTO;
import com.example.InventoryManagementSystem.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/add-new-transaction")
    public ResponseEntity<TransactionDTO> addNewTransaction(@RequestBody TransactionDTO transactionDTO){
        TransactionDTO response = transactionService.addTransaction(transactionDTO);
        if (response !=null){
            System.out.println("Transaction Saved");
            return ResponseEntity.ok(response);
        }else{
            System.out.println("Failed to save the transaction");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}
