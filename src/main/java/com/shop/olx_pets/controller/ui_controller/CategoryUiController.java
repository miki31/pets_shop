package com.shop.olx_pets.controller.ui_controller;

import com.shop.olx_pets.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryUiController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public String findAll(Model model){
        model.addAttribute("categories", categoryService.findAll());
        return "categories";
    }

}
