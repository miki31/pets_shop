package com.shop.olx_pets.controller.ui_controller;

import com.shop.olx_pets.model.Response;
import com.shop.olx_pets.model.User;
import com.shop.olx_pets.model.dto.ResponseDTO;
import com.shop.olx_pets.service.AdvertisementService;
import com.shop.olx_pets.service.ResponseDTOService;
import com.shop.olx_pets.service.ResponseService;
import com.shop.olx_pets.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/person")
@Slf4j
public class PersonUiController {
    // Controller for all (user, seller, admin). This class has common methods for all roles
    @Autowired
    private UserService userService;

    @Autowired
    private AdvertisementService advertisementService;

    @Autowired
    private ResponseService responseService;

    @Autowired
    ResponseDTOService responseDTOService;

    @ModelAttribute("user")
    public User activeUser(Authentication authentication) {
        return userService.findUserByEmail(authentication.getName()).get();
    }

    @GetMapping("info")
    public String getInfo(@RequestParam Long idUser, Model model) {
//        model.addAttribute("id", id);
        User user = activeUser(SecurityContextHolder.getContext().getAuthentication());

        User seller = userService.getOne(idUser);
        model.addAttribute("user", seller);

        Response response = new Response();
        response.setGood(true);
        model.addAttribute("response", response);

//        List<Response> responses = responseService.findByAuthorIdAndSortByPosted(idUser);
//        model.addAttribute("responses", responses);
        List<ResponseDTO> responseDTOList = responseDTOService.findAllByAuthor(seller, user);
        model.addAttribute("responsesDTO", responseDTOList);

//        Response response = new Response();
//        model.addAttribute("response", response);

        return "person/info_person";
    }

    @GetMapping("info/me")
    public String getInfoMe(Model model) {

        User user = activeUser(SecurityContextHolder.getContext().getAuthentication());
        model.addAttribute("user", user);

        Response response = new Response();
        response.setGood(true);
        model.addAttribute("response", response);

//        List<Response> responses = responseService.findByAuthorIdAndSortByPosted(user.getId());
//        model.addAttribute("responses", responses);

        List<ResponseDTO> responseDTOList = responseDTOService.findAllByAuthor(user, user);
        model.addAttribute("responsesDTO", responseDTOList);

//        Response response = new Response();
//        model.addAttribute("response", response);

        return "person/info_person";
    }

}
