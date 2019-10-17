package com.shop.olx_pets.controller.ui_controller;

import com.shop.olx_pets.model.Category;
import com.shop.olx_pets.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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

    @GetMapping("create")
    public String create(Model model){
        Category category = new Category();
        model.addAttribute("category", category);
        return "create_category";
    }

    @PostMapping("create")
    public String createCategory(
            @Valid Category category,
            BindingResult bindingResult
    ){
        if (category.getName().length() > 3) {
            categoryService.save(category);
        }

        return "redirect:/category/create";
    }
}
