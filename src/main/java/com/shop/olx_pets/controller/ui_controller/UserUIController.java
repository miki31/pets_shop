package com.shop.olx_pets.controller.ui_controller;

import com.shop.olx_pets.model.Response;
import com.shop.olx_pets.model.User;
import com.shop.olx_pets.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserUIController {

    @Autowired
    private AdvertisementService advertisementService;

    @Autowired
    private UserService userService;

    @Autowired
    private LogAdvertisementService logAdvertisementService;

    @Autowired
    private GoodShoppingService goodShoppingService;

    @ModelAttribute("buyer")
    public User activeUser(Authentication authentication) {
        return userService.findUserByEmail(authentication.getName()).get();
    }

    @GetMapping(value = {"/user_home"})
    public String home(Model model) {
        model.addAttribute("allAdvert", advertisementService.littleList(33));
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


    @GetMapping("/order")
    public String order(@RequestParam Long adId,
                        @ModelAttribute("buyer") User buyer) {
        logAdvertisementService.order(buyer, advertisementService.getOne(adId));
        return "redirect:/user/user_home";
    }


    @GetMapping("/canselOrder")
    public String canselOrder(@RequestParam Long adId,
                              @ModelAttribute("buyer") User buyer) {
        logAdvertisementService.canselOrder(buyer, advertisementService.getOne(adId));
        return "redirect:/user/user_home";
    }

    @GetMapping("/myOrders")
    public String getTaken(@ModelAttribute("buyer") User buyer,
                           Model model
    ) {
//        model.addAttribute("adlogs", logAdvertisementService.
//                findByBuyerId(buyer.getId()));
        model.addAttribute("adlogs", advertisementService.getOrderByUser(buyer.getId()));

        return "user/my_orders";
    }

    @GetMapping(value = "/myGoodShopping")
    public String goodShopping(@ModelAttribute("buyer") User buyer,
                               Model model
    ) {
        model.addAttribute("adlogs", goodShoppingService.getOrderByBuyer(buyer.getId()));

        return "user/my_orders";
    }
}
