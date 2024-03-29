package com.shop.olx_pets.controller.ui_controller;

import com.shop.olx_pets.model.User;
import com.shop.olx_pets.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/profile")
@Slf4j
public class ProfileUiController {

    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("basePath")
    private String basePath;

    @ModelAttribute("user")
    public User activeUser(Authentication authentication) {
        return userService.findUserByEmail(authentication.getName()).get();
    }


    //TODO: create UI for all users role

    @GetMapping
    public String userProfile(Model model) {
        return "user-profile";
    }

    @PostMapping("uploadPhoto")
    public String uploadPhoto(@RequestParam("file") MultipartFile file,
                              @ModelAttribute("user") User user
    ) {
        String uploadName = file.getOriginalFilename();

        try {
            File transferFile = new File(basePath + "/" + uploadName);
            file.transferTo(transferFile);
            log.info("Saved into {}", transferFile.getPath());
            user.setPhoto(uploadName);
            userService.createUpdate(user);
        } catch (IOException e) {
            log.error("Error saving file", e);
        }

        return "redirect:/profile";
    }

    @RequestMapping(path = {"/changeUser/{id}"})
    public String editUserById(Model model, @PathVariable("id") Optional<Long> id) {
        if (id.isPresent()) {
            User user = userService.getOne(id.get());
            model.addAttribute("user", user);
        } else {
            model.addAttribute("user", new User());
        }
        return "admin/edit_user";
    }

    @RequestMapping(path = "/updateUser", method = RequestMethod.POST)
    public String UpdateUser(User user) {
        userService.createUpdate(user);
        return "redirect:/profile";
    }

}
