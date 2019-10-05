package com.shop.olx_pets.repository;

import com.shop.olx_pets.model.Advertisement;
import com.shop.olx_pets.model.GoodShopping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodShoppingRepository extends JpaRepository<GoodShopping, Long> {

    @Query("SELECT l.advertisement from GoodShopping l where l.seller.id = :sellerId")
    List<Advertisement> findOrderBySeller(Long sellerId);

    @Query("SELECT l.advertisement from GoodShopping l where l.buyer.id = :buyerId")
    List<Advertisement> findOrderByBuyer(Long buyerId);
}
