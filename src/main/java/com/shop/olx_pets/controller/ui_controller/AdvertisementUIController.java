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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Id;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public String findAll(Model model,
                          @RequestParam Integer page,
                          @RequestParam Integer sizeList
                          ) {
        List<Advertisement> advertisements = advertisementService.findAll();
        model.addAttribute("advertisements", advertisementService.bigList(page,sizeList, advertisements));

        Integer pages = advertisements.size()%sizeList == 0 ?
                advertisements.size()/sizeList :
                advertisements.size()/sizeList + 1;

        List<Integer> pagesList = new ArrayList<>();

        // CODE for "Previous" page
        pagesList.add(0);

        for (int i = 1; i <= pages; i++) {
            // # for page with some advertisements
            pagesList.add(i);
        }

        // CODE for "Next" page
        pagesList.add(-1);

        model.addAttribute("pagesList", pagesList);
        model.addAttribute("pages", pages);
        model.addAttribute("sizeList", sizeList);
        model.addAttribute("page", page);

        return "seller/seller_list_all_advertisements";
    }

    @GetMapping("/create")
    public String createAdvertisement(Model model) {
        Advertisement advertisement = new Advertisement();
        model.addAttribute("advertisement", advertisement);
        model.addAttribute("categories", categoryService.findAll());
        return "seller/create_advertisement";
    }

    @PostMapping("/create")
    public String createAdvertisement(
            @Valid Advertisement advertisement,
            BindingResult bindingResult,
            Model model) {

        User seller = activeUser(SecurityContextHolder.getContext().getAuthentication());

        // Binding the advert to the seller
        advertisement.setSeller(seller);

        // check data similarly as in registration form
        if (bindingResult.hasErrors()) {
            return "seller/create_advertisement";
        }

        advertisement = advertisementService.createUpdate(advertisement);

        model.addAttribute("advertisement", advertisement);

        return "seller/add_photo_for_advert";
    }

    @PostMapping("/uploadPhoto/{id}")
    public String createAdvertisementPhoto(
            @PathVariable("id") Optional<Long> id,
            @RequestParam("advertPhoto") MultipartFile file,
            @Valid Advertisement advertisement

//            @ModelAttribute("seller") User seller,
//            BindingResult bindingResult,
//            Model model
    ) {

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

    @GetMapping("/editAdvert")
    public String editAdvertisement(
            @RequestParam Long adId,
            Model model
    ) {
        Advertisement advertisement = advertisementService.getOne(adId);

        model.addAttribute("advertisement", advertisement);
        model.addAttribute("categories", categoryService.findAll());

        return "seller/edit_advertisement";
    }

    @GetMapping("/deleteAdvert")
    public String deleteAdvertisement(@RequestParam Long adId) {
        advertisementService.delete(adId);
        return "redirect:/";
    }

    // TODO: this method only for testing
    @GetMapping("/card")
    public String getCard(Model model) {
//        List<Advertisement> advertisements = advertisementService.findAll();
//        Random r = new Random();
//        Advertisement advert = advertisements.get(r.nextInt(advertisements.size()));
        Advertisement advert = advertisementService.randomAd();
        model.addAttribute("advert", advert);
        return "fragments/card_advertisement";
    }


    @GetMapping("description/{id}")
    public String getDescription(@PathVariable Long id, Model model) {
        Advertisement advertisement = advertisementService.getOne(id);
        model.addAttribute("advertisement", advertisement);
        return "description_card";
    }

}
