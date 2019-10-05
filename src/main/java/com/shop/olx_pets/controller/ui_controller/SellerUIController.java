package com.shop.olx_pets.controller.ui_controller;

import com.shop.olx_pets.model.User;
import com.shop.olx_pets.service.AdvertisementService;
import com.shop.olx_pets.service.GoodShoppingService;
import com.shop.olx_pets.service.LogAdvertisementService;
import com.shop.olx_pets.service.UserService;
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
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/seller")
@Slf4j
public class SellerUIController {

    @Autowired
    private AdvertisementService advertisementService;

    @Autowired
    private UserService userService;

    @Autowired
    private LogAdvertisementService logAdvertisementService;

    @Autowired
    private GoodShoppingService goodShoppingService;


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

//    @GetMapping("/all")

    @GetMapping("/ordersFromUsers")
    public String getTaken(@ModelAttribute("seller") User seller,
                           Model model
    ) {
        model.addAttribute("adlogs", advertisementService.ordersFromUsers(seller.getId()));

        return "seller/order";
    }

    @GetMapping(value = "/request")
    public String request(@RequestParam Long id) {
        User seller = activeUser(SecurityContextHolder.getContext().getAuthentication());
        goodShoppingService.listBuyers(seller, logAdvertisementService.getOne(id));
        return "redirect:/seller/seller_home";
    }

    @GetMapping(value = "/myGoodShopping")
    public String goodShopping(@ModelAttribute("seller") User seller,
                               Model model
    ) {
        model.addAttribute("adlogs", goodShoppingService.getOrderBySeller(seller.getId()));

        return "user/my_orders";
    }
}
