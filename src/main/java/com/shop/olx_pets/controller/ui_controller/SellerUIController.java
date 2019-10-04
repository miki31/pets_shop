package com.shop.olx_pets.controller.ui_controller;

import com.shop.olx_pets.model.User;
import com.shop.olx_pets.service.AdvertisementService;
import com.shop.olx_pets.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/seller")
@Slf4j
public class SellerUIController {

    @Autowired
    private AdvertisementService advertisementService;

    @Autowired
    private UserService userService;

    @ModelAttribute("seller")
    public User activeUser(Authentication authentication) {
        return userService.findUserByEmail(authentication.getName()).get();
    }


    @GetMapping(value = {"/seller_home"})
    public String home(Model model) {
//        List<Advertisement> advertisements = new ArrayList<>();
//        advertisements.add(advertisementService.randomAd());

        model.addAttribute("advert", advertisementService.randomAd());
        return "seller/seller_home";
    }

    @GetMapping("/ordersFromUsers")
    public String getTaken(@ModelAttribute("seller") User seller,
                           Model model
    ) {
        model.addAttribute("adlogs", advertisementService.ordersFromUsers(seller.getId()));

        return "seller/order";
    }

}
