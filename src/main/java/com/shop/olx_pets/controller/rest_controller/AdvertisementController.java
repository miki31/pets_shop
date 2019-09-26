package com.shop.olx_pets.controller.rest_controller;

import com.shop.olx_pets.model.Advertisement;
import com.shop.olx_pets.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/v1/ad")
public class AdvertisementController {
    @Autowired
    AdvertisementService advertisementService;

    @GetMapping("/all")
    public List<Advertisement> findAll(){
        return advertisementService.findAll();
    }

}

