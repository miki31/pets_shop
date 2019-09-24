package com.shop.olx_pets.controller.ui_controller;

import com.shop.olx_pets.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ad")
public class AdvertisementController {
    @Autowired
    private AdvertisementService advertisementService;

    @GetMapping("/ad/all")
    public String findAll(Model model) {
        model.addAttribute("ads", advertisementService.findAll());
        return "ads";
    }
}
