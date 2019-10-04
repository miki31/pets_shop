package com.shop.olx_pets.repository;

import com.shop.olx_pets.model.Advertisement;
import com.shop.olx_pets.model.Logadvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogAdvertisementRepository extends JpaRepository<Logadvertisement, Long> {

    List<Logadvertisement> findByBuyer(Long id);

//    @Query("SELECT l.advertisement from Logadvertisement l where l.returned is null ")
//    List<Advertisement> findNotReturned();

    @Query("SELECT l.advertisement from Logadvertisement l where l.buyer.id = :buyerId")
    List<Advertisement> findOrderByUser(Long buyerId);

    @Query("SELECT l.advertisement from Logadvertisement l where l.advertisement.id = :advertisementId")
    List<Advertisement> findOrderByAdvertisement();

}
