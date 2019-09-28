package com.shop.olx_pets.controller.ui_controller;

import com.shop.olx_pets.service.AdvertisementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/seller")
@Slf4j
public class SellerUIController {

    @Autowired
    private AdvertisementService advertisementService;

    @GetMapping(value = {"/seller_home"})
    public String home() {
        return "seller/seller_home";
    }
}
