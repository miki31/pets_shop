package com.shop.olx_pets.repository;

import com.shop.olx_pets.model.Advertisement;
import com.shop.olx_pets.model.BedShopping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BedShoppingRepository extends JpaRepository<BedShopping, Long> {

    @Query("SELECT l.advertisement from BedShopping l where l.buyer.id = :buyerId")
    List<Advertisement> findOrderByBuyer(Long buyerId);

}
