package com.shop.olx_pets.repository;

import com.shop.olx_pets.model.Advertisement;
import com.shop.olx_pets.model.Logadvertisement;
import com.shop.olx_pets.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface LogAdvertisementRepository extends JpaRepository<Logadvertisement, Long> {

    Set<Logadvertisement> findByBuyer(Long id);

    Logadvertisement findByBuyerAndAdvertisement(User buyer, Advertisement advertisement);

//    @Query("SELECT l.advertisement from Logadvertisement l where l.returned is null ")
//    List<Advertisement> findNotReturned();

    @Query("SELECT l.advertisement from Logadvertisement l where l.buyer.id = :buyerId")
    Set<Advertisement> findOrderByUser(Long buyerId);

    @Query("SELECT l.advertisement from Logadvertisement l where l.advertisement.id = :advertisementId")
    List<Advertisement> findOrderByAdvertisement();

    List<Logadvertisement> findByAdvertisement(Advertisement advertisement);
}
