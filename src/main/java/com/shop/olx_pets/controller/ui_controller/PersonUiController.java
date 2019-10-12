package com.shop.olx_pets.controller.ui_controller;

import com.shop.olx_pets.model.Response;
import com.shop.olx_pets.model.User;
import com.shop.olx_pets.service.AdvertisementService;
import com.shop.olx_pets.service.ResponseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/person")
@Slf4j
public class PersonUiController {
    // Controller for all (user, seller, admin). This class has common methods for all roles

    @Autowired
    private AdvertisementService advertisementService;

    @Autowired
    private ResponseService responseService;

    @GetMapping("info/{id}")
    public String getInfo(@PathVariable Long id, Model model) {
        User seller = advertisementService.getSellerInfo(id);
        model.addAttribute("user", seller);

        List<Response> responses = responseService.findAllByAuthor(seller);
        model.addAttribute("responses", responses);

//        Response response = new Response();
//        model.addAttribute("response", response);

        return "person/info_person";
    }

}
