package com.shop.olx_pets.repository;

import com.shop.olx_pets.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<User, Long> {
}