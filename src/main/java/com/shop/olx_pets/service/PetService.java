package com.shop.olx_pets.service;

import com.shop.olx_pets.model.Pet;
import com.shop.olx_pets.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public List<Pet> findAll(){
        return petRepository.findAll();
    }

}
