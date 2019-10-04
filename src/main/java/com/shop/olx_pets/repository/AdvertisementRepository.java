package com.shop.olx_pets.repository;

import com.shop.olx_pets.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdvertisementRepository extends JpaRepository <Advertisement, Long> {

    List<Advertisement> findBySeller(Long sellerId);

}
