package com.shop.olx_pets.controller.ui_controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserUIController {

    @RequestMapping(value = {"/user_home"}, method = RequestMethod.GET)
    public String home(Model model) {

        return "user/user_home";
    }

    @RequestMapping(value = {"/available_products"}, method = RequestMethod.GET)
    public String availableProducts(Model model) {
        return "";
    }

}
