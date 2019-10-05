package com.shop.olx_pets.repository;

import com.shop.olx_pets.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertisementRepository extends JpaRepository <Advertisement, Long> {

    List<Advertisement> findBySeller(Long sellerId);

}
