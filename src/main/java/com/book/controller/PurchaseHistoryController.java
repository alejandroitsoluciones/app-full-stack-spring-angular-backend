package com.book.controller;

import com.book.models.PurchaseHistory;
import com.book.security.UserDetailsImpl;
import com.book.service.PurchaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PurchaseHistoryController {

    @Autowired
    private PurchaseHistoryService purchaseHistoryService;

    @PostMapping("/purchase-history")
    public ResponseEntity<?> savePurchaseHistory(@RequestBody PurchaseHistory purchaseHistory){
        return new ResponseEntity<>(purchaseHistoryService.savePurchaseHistory(purchaseHistory), HttpStatus.CREATED);
    }

    @GetMapping("/purchase-history")
    public ResponseEntity<?> getAllPurchasesOfUser(@AuthenticationPrincipal UserDetailsImpl userDetails){
        return ResponseEntity.ok(purchaseHistoryService.findPurchaseItemsOfUser(userDetails.getId()));
    }

}
