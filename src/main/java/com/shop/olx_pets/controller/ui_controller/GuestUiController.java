package com.shop.olx_pets.controller.ui_controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guest")
public class GuestUiController {

    @GetMapping
    public String hello(Model model){
        return "guest";
    }

}
