package com.shop.olx_pets.controller.ui_controller;

import com.shop.olx_pets.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserUiController {

    @Autowired
    private UserService userService;


    @GetMapping("/all")
    public String findAll(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }
}
