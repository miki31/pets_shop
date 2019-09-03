package com.shop.olx_pets.controller;

import com.shop.olx_pets.model.User;
import com.shop.olx_pets.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("{id}")
    public User getOne(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @GetMapping("all")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @PostMapping()
    public User save(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("{id}")
    public User delete(@PathVariable Long id) {
        User toDelete = userRepository.findById(id).orElse(null);
        if (toDelete != null) {
            userRepository.delete(toDelete);
        }
        return toDelete;
    }

}