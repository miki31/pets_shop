package com.shop.olx_pets.repository;

import com.shop.olx_pets.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisementRepository extends JpaRepository <Advertisement, Long> {
}
