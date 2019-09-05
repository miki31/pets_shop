package com.shop.olx_pets.controller.ui_controller;


import com.shop.olx_pets.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pet")
public class PetUiController {

    @Autowired
    private PetService petService;

    @GetMapping("/all")
    public String findAll(Model model){
        model.addAttribute("pets", petService.findAll());
        return "pets";
    }

}
