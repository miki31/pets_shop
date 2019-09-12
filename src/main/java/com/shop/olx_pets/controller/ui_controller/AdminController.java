package com.shop.olx_pets.controller.ui_controller;

import com.shop.olx_pets.model.User;
import com.shop.olx_pets.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/adminHome"}, method = RequestMethod.GET)
    public String home() {
        return "adminHome";
    }

    @RequestMapping(value = {"/deleteUser"}, method = RequestMethod.GET)
    public String pageAdminDeleteUser(Model model) {
        List<User> allUsers = userService.findAll();
        model.addAttribute("users", allUsers);
        return "deleteUser";
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return "adminHome";
    }

    @RequestMapping(path = {"/changeUser/{id}"})
    public String editUserById(Model model, @PathVariable("id") Optional<Long> id) {
        if (id.isPresent()) {
            User user = userService.getOne(id.get());
            model.addAttribute("user", user);
        } else {
            model.addAttribute("user", new User());
        }
        return "editUser";
    }


}
