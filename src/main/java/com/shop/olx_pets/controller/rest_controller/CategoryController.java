package com.shop.olx_pets.controller.rest_controller;

import com.shop.olx_pets.model.Category;
import com.shop.olx_pets.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/v1/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("all")
    public List<Category> findAll(){
        return categoryService.findAll();
    }

}
