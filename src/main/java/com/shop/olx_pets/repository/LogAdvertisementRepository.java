package com.shop.olx_pets.repository;

import com.shop.olx_pets.model.Logadvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogAdvertisementRepository extends JpaRepository<Logadvertisement, Long> {

    List<Logadvertisement> findByBuyerId(Long id);
}
