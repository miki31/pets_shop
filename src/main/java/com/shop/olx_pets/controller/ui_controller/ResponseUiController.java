package com.shop.olx_pets.controller.ui_controller;

import com.shop.olx_pets.model.Response;
import com.shop.olx_pets.model.User;
import com.shop.olx_pets.service.ResponseService;
import com.shop.olx_pets.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/response")
@Slf4j
public class ResponseUiController {

    @Autowired
    private UserService userService;

    @Autowired
    private ResponseService responseService;

    @ModelAttribute("reviewer")
    public User activeUser(Authentication authentication) {
        return userService.findUserByEmail(authentication.getName()).get();
    }

    // TODO: for testing
    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id,
                           Model model){
        Response response = responseService.findById(id);
        model.addAttribute("response", response);
        return "fragments/card_response";
    }

    @PostMapping("/write")
    public String writeResponse(
            @RequestParam Long idUser,
            @Valid Response response,
            Model model){
        User user = userService.getOne(idUser);
        response.setAuthor(user);

        model.addAttribute("user", user);

        User reviewer = activeUser(SecurityContextHolder.getContext().getAuthentication());
        response.setReviewer(reviewer);

//        model.addAttribute("response", response);

        responseService.createUpdate(response);

        return "redirect:/person/info/?idUser=" + idUser;
    }

}
