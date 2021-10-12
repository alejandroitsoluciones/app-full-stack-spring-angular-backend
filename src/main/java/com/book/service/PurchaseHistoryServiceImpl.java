package com.book.service;

import com.book.models.PurchaseHistory;
import com.book.repository.PurchaseHistoryRepository;

import com.book.repository.projection.PurchaseItemProjection;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseHistoryServiceImpl implements PurchaseHistoryService{

    private final PurchaseHistoryRepository purchaseHistoryRepository;


    public PurchaseHistoryServiceImpl(PurchaseHistoryRepository purchaseHistoryRepository) {
        this.purchaseHistoryRepository = purchaseHistoryRepository;
    }

    @Override
    public PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory){
        purchaseHistory.setPurchaseTime(LocalDateTime.now());
        return purchaseHistoryRepository.save(purchaseHistory);
    }

    @Override
    public List<PurchaseItemProjection> findPurchaseItemsOfUser(Long userId){
        return purchaseHistoryRepository.findAllPurchasesOfUser(userId);
    }


}
