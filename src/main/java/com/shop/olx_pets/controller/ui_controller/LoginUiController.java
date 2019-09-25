package com.shop.olx_pets.controller.ui_controller;

import com.shop.olx_pets.model.Role;
import com.shop.olx_pets.model.User;
import com.shop.olx_pets.service.RoleService;
import com.shop.olx_pets.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Controller
public class LoginUiController implements WebMvcConfigurer {

    private static final String EMPTY_FIELD_MESSAGE = "This field can't be empty";
    private static final String EMAIL_ALREADY_USED_MESSAGE ="There is already a user registered with the email provided";
    private static final String NICK_NAME_ALREADY_USED_MESSAGE ="There is already a user registered with the nick provided";
    private static final String SUCCESSFULLY_REGISTERED_MESSAGE = "User has been registered successfully";


    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

    @ModelAttribute("user")
    public User activeUser(Authentication authentication) {
        return new User();
    }

//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }

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

    public String createNewPerson(@Valid User user, BindingResult bindingResult, Model model, String role) {
        // todo: add form validation on empty fields, and use message String

        if (bindingResult.hasErrors() || userExists(user, bindingResult))  {
            return "registration";
        }

        Set<Role> roles = new HashSet<>();
        roles.add(roleService.findByName(role));
        user.setRoles(roles);
        user = userService.createUpdate(user);

        model.addAttribute("successMessage", SUCCESSFULLY_REGISTERED_MESSAGE);
        model.addAttribute("user", user);
        return "home";
    }


    private boolean userExists(User user, BindingResult bindingResult) {
        boolean resultEmail = userService.findUserByEmail(user.getEmail()).isPresent();
        if (resultEmail) {
            bindingResult.rejectValue("email", "error.user", EMAIL_ALREADY_USED_MESSAGE);
        }

        boolean resultNickName = userService.findUserByNickName(user.getNickName()).isPresent();
        if (resultNickName) {
            bindingResult.rejectValue("nickName", "error.user", NICK_NAME_ALREADY_USED_MESSAGE);
        }

        return resultEmail | resultNickName;
    }



}
