package com.shop.olx_pets.controller.ui_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping(value = {"/adminHome"}, method = RequestMethod.GET)
    public String home() {
        System.out.println("hello");
        return "adminHome";
    }
}
