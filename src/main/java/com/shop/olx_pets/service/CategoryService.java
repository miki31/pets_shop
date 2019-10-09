package com.shop.olx_pets.service;

import com.shop.olx_pets.model.Category;
import com.shop.olx_pets.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findByName(String name){
        Optional<Category> category =
                categoryRepository.findByName(name);
        return category.get();
    }

}
