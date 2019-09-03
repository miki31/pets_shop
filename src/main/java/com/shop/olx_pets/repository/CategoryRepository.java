package com.shop.olx_pets.repository;

import com.shop.olx_pets.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category, Long> {
}
