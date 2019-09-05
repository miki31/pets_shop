package com.shop.olx_pets.controller;

import com.shop.olx_pets.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserUiController {

    @Autowired
    UserService userService;


    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }
}
