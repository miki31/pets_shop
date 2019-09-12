package com.shop.olx_pets.controller.ui_controller;

import com.shop.olx_pets.model.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping("/")
public class HomePageUiController {

    @GetMapping
    public String home() {
        return "home";
    }

    @RequestMapping("/dashboard")
    public String index() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (roles.contains("ADMIN"))
            return "redirect:/admin/adminHome";
        if (roles.contains("MANAGER"))
            return "redirect:/manager/managerHome";
        if (roles.contains("USER"))
            return "redirect:/user/userHome";
        if (roles.contains("SELLER"))
            return "redirect:/seller/sellerHome";
        return "";
    }

//    @GetMapping("/profile")
//    public String getPersonProfile(Model model){
//
//        return "profile";
//    }

}
