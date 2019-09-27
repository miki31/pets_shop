package com.shop.olx_pets.controller.ui_controller;

import com.shop.olx_pets.model.Advertisement;
import com.shop.olx_pets.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/advertisement")
public class AdvertisementUIController {
    @Autowired
    private AdvertisementService advertisementService;

    @Autowired
    @Qualifier("advertisementPhotoPath")
    private String advertPhotoPath;

    @GetMapping("/all")
    public String findAll(Model model) {
        model.addAttribute("ads", advertisementService.findAll());
        return "ads";
    }

    @GetMapping("/create")
    public String createAdvertisement(Model model){
        Advertisement advertisement = new Advertisement();
        model.addAttribute("advertisement", advertisement);
        return "create_advertisement";
    }

    @GetMapping("/card")
    public String getCard(Model model){
        List<Advertisement> advertisements = advertisementService.findAll();
        Random r = new Random();
        Advertisement advert = advertisements.get(r.nextInt(advertisements.size()));
        model.addAttribute("advert", advert);
        return "fragments/card_advertisement";
    }
}
