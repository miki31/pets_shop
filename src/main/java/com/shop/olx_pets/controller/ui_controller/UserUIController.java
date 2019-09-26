package com.shop.olx_pets.controller.ui_controller;

import com.shop.olx_pets.service.AdvertisementService;
import com.shop.olx_pets.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserUIController {

    @Autowired
    private AdvertisementService advertisementService;

    @GetMapping(value = {"/user_home"})
    public String home() {
        return "user/user_home";
    }

    @RequestMapping(value = {"/available_pet"}, method = RequestMethod.GET)
    public String availableProducts(Model model) {
        model.addAttribute("pets", advertisementService.findAll());
        return "user/available_pet";
    }

}
