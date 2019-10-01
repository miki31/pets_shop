package com.shop.olx_pets.controller.ui_controller;

import com.shop.olx_pets.model.Advertisement;
import com.shop.olx_pets.model.User;
import com.shop.olx_pets.service.AdvertisementService;
import com.shop.olx_pets.service.CategoryService;
import com.shop.olx_pets.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Controller
@RequestMapping("/advertisement")
@Slf4j
public class AdvertisementUIController {

    @Autowired
    private AdvertisementService advertisementService;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    @Qualifier("advertisementPhotoPath")
    private String advertPhotoPath;

    @ModelAttribute("seller")
    public User activeUser(Authentication authentication) {
        return userService.findUserByEmail(authentication.getName()).get();
    }

    @GetMapping("/all")
    public String findAll(Model model) {
        model.addAttribute("ads", advertisementService.findAll());
        return "ads";
    }

    @GetMapping("/create")
    public String createAdvertisement(Model model){
        Advertisement advertisement = new Advertisement();
        model.addAttribute("advertisement", advertisement);
        model.addAttribute("categories", categoryService.findAll());
        return "seller/create_advertisement";
    }

    @PostMapping("/create")
    public String createAdvertisement(
            @Valid Advertisement advertisement,
            @ModelAttribute("seller") User seller,
            BindingResult bindingResult,
            Model model){


        //TODO : binding to the seller
        advertisement.setSeller(seller);

        // check data similarly as in registration form
        if (bindingResult.hasErrors())  {
            return "seller/create_advertisement";
        }

        advertisement = advertisementService.createUpdate(advertisement);

        model.addAttribute("advertisement", advertisement);

        return "seller/add_photo_for_advert";
    }

    @PostMapping("/uploadPhoto/{id}")
    public String createAdvertisement(
            @PathVariable("id") Optional<Long> id,
            @RequestParam("advertPhoto") MultipartFile file,
            @Valid Advertisement advertisement

//            @ModelAttribute("seller") User seller,
//            BindingResult bindingResult,
//            Model model
    ){

        //TODO: create a unique name for advert photo
        String uploadPhotoName = file.getOriginalFilename();

        try {
            File transferFile = new File(advertPhotoPath + "/" + uploadPhotoName);
            file.transferTo(transferFile);
            log.info("Saved advertisement photo into {}", transferFile.getPath());
            advertisement.setPhoto(uploadPhotoName);
            advertisement = advertisementService.createUpdate(advertisement);
        } catch (IOException e) {
            log.error("Error saving file", e);
        }

        //TODO : move to details this advert
        return "home";
    }

    // TODO: this method only for testing
    @GetMapping("/card")
    public String getCard(Model model){
//        List<Advertisement> advertisements = advertisementService.findAll();
//        Random r = new Random();
//        Advertisement advert = advertisements.get(r.nextInt(advertisements.size()));
        Advertisement advert = advertisementService.randomAd();
        model.addAttribute("advert", advert);
        return "fragments/card_advertisement";
    }
}
