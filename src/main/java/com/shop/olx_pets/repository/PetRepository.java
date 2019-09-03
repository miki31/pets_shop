package com.shop.olx_pets.repository;

import com.shop.olx_pets.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
