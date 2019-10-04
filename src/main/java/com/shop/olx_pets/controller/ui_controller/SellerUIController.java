package com.shop.olx_pets.controller.ui_controller;

import com.shop.olx_pets.model.User;
import com.shop.olx_pets.service.AdvertisementService;
import com.shop.olx_pets.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
        model.addAttribute("allAdvert", advertisementService.littleList(33));

        User seller = activeUser(SecurityContextHolder.getContext().getAuthentication());
        model.addAttribute("myAdvert", advertisementService.littleList(33, seller));
        return "seller/seller_home";
    }
}
