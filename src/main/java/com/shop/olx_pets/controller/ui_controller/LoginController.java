package com.shop.olx_pets.controller.ui_controller;

import com.shop.olx_pets.model.Role;
import com.shop.olx_pets.model.User;
import com.shop.olx_pets.service.RoleService;
import com.shop.olx_pets.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Controller
public class LoginController {

    private static final String EMPTY_FIELD_MESSAGE = "This field can't be empty";
    private static final String EMAIL_ALREADY_USED_MESSAGE ="There is already a user registered with the email provided";
    private static final String SUCCESSFULLY_REGISTERED_MESSAGE = "User has been registered successfully";


    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping(value={"/login"})
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("roles", roleService.findAll());
        return "registration";
    }

    @PostMapping("/registration/user")
    public String createNewUser(@Valid User user, BindingResult bindingResult, Model model) {

        System.out.println(user.getBirthday());
        return createNewPerson(user, bindingResult, model, "USER");
    }

    @PostMapping("/registration/seller")
    public String createNewSeller(@Valid User user, BindingResult bindingResult, Model model) {
        return createNewPerson(user, bindingResult, model, "SELLER");
    }

    public String createNewPerson(@Valid User user, BindingResult bindingResult, Model model, String r) {
        // todo: add form validation on empty fields, and use message String
        Optional<User> userExists = userService.findUserByEmail(user.getEmail());

        if (userExists.isPresent()) {
            bindingResult.rejectValue("email", "error.user", EMAIL_ALREADY_USED_MESSAGE);
            return "registration";
        }
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.findByName(r));
        user.setRoles(roles);
        user = userService.createUpdate(user);
        model.addAttribute("successMessage", SUCCESSFULLY_REGISTERED_MESSAGE);
        model.addAttribute("user", user);
        return "home";
    }



}
