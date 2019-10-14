package com.shop.olx_pets.controller.ui_controller;

import com.shop.olx_pets.model.LikeTheResponse;
import com.shop.olx_pets.model.Response;
import com.shop.olx_pets.model.User;
import com.shop.olx_pets.service.LikeTheResponseService;
import com.shop.olx_pets.service.ResponseService;
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
@RequestMapping("/like-dislike")
@Slf4j
public class LikeTheResponseUiController {

    @Autowired
    private LikeTheResponseService likeTheResponseService;

    @Autowired
    private UserService userService;

    @Autowired
    private ResponseService responseService;

    @ModelAttribute("reviewer")
    public User activeUser(Authentication authentication) {
        return userService.findUserByEmail(authentication.getName()).get();
    }

    // create saving likes
    @GetMapping("/put")
    public String putLike(@RequestParam Long idUser,
                          @RequestParam Long idResponse,
                          @RequestParam Boolean good,
                          Model model
                          ){
        User user = userService.getOne(idUser);
        model.addAttribute("user", user);

        LikeTheResponse likeTheResponse = new LikeTheResponse();

        likeTheResponse.setGood(good);
        User appraiser = activeUser(
                SecurityContextHolder.getContext().getAuthentication()
        );
        likeTheResponse.setAppraiser(appraiser);

        Response response = responseService.findById(idResponse);
        likeTheResponse.setResponse(response);

        likeTheResponseService.createUpdate(likeTheResponse);

        return "redirect:/person/info/?idUser=" + idUser;
    }

}
