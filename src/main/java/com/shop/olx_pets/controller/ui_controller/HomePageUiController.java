package com.shop.olx_pets.controller.ui_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomePageUiController {

    @GetMapping
    public String home() {
        return "home";
    }

}
