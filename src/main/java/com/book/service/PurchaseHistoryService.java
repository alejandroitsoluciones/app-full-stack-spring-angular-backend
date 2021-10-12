package com.book.service;

import com.book.models.PurchaseHistory;
import com.book.repository.projection.PurchaseItemProjection;

import java.util.List;

public interface PurchaseHistoryService {
    PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory);

    List<PurchaseItemProjection> findPurchaseItemsOfUser(Long userId);
}
