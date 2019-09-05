package com.shop.olx_pets.controller.rest_controller;

import com.shop.olx_pets.model.Role;
import com.shop.olx_pets.model.User;
import com.shop.olx_pets.repository.UserRepository;
import com.shop.olx_pets.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

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
        return userService.save(user);
    }


}
