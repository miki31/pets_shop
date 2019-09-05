package com.shop.olx_pets.controller.rest_controller;

import com.shop.olx_pets.model.Pet;
import com.shop.olx_pets.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/v1/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping("all")
    public List<Pet> findAll(){
        return petService.findAll();
    }

}
