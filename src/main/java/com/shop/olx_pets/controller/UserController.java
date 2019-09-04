package com.shop.olx_pets.controller;

import com.shop.olx_pets.model.Role;
import com.shop.olx_pets.model.User;
import com.shop.olx_pets.repository.UserRepository;
import com.shop.olx_pets.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("{id}")
    public User getOne(@PathVariable Long id) {
        return userService.getOne(id);
    }

    @GetMapping("all")
    public List<User> findAll() {
        return userService.findAll();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @PostMapping()
    public User save(@RequestBody User user) {
        String r = Role.USER.getRole();
        if (user.getRole()!=null) {
            for (Role role : Role.values()) {
                if (user.getRole().equals(role.name())) {
                    r = role.getRole();
                    break;
                }
            }
        }
        user.setRole(r);
        return userRepository.save(user);
    }


}
