package com.shop.olx_pets.controller.ui_controller;

import com.shop.olx_pets.model.Advertisement;
import com.shop.olx_pets.model.User;
import com.shop.olx_pets.service.AdvertisementService;
import com.shop.olx_pets.service.PetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserUIController {

    @Autowired
    private AdvertisementService advertisementService;

    @GetMapping(value = {"/user_home"})
    public String home() {
        return "user/user_home";
    }

    @RequestMapping(value = {"/all_pet"}, method = RequestMethod.GET)
    public String availableProducts(Model model) {
        model.addAttribute("pets", advertisementService.findAll());
        return "user/all_pet";
    }

//    @GetMapping("/available")
//    public String getAvailable(Model model) {
//        model.addAttribute("advertisements", advertisementService.getAvailable());
//        return "pets";
//    }

//
//    @GetMapping("/taken")
//    public String getTaken(@ModelAttribute("user") User user,
//                           Model model) {
////        model.addAttribute("advertisement", advertisementService.findByUserIdAndByReturnedIsNull(user.getId()));
//        return "taken";
//    }

}
