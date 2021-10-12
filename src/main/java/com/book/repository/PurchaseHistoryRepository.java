package com.book.repository;

import com.book.models.PurchaseHistory;
import com.book.repository.projection.PurchaseItemProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseHistoryRepository extends JpaRepository<PurchaseHistory, Long> {

    @Query("SELECT b.title AS title, "
            + "ph.price AS price, "
            + "ph.purchaseTime AS purchaseTime "
            + "FROM PurchaseHistory ph LEFT JOIN Book b ON b.id = ph.bookId "
            + "WHERE ph.userId = :userId")
    List<PurchaseItemProjection> findAllPurchasesOfUser(@Param("userId") Long userId);

}
