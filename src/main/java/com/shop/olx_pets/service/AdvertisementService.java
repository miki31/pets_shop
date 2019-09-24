package com.shop.olx_pets.service;

import com.shop.olx_pets.model.Advertisement;
import com.shop.olx_pets.repository.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementService {
    @Autowired
    private AdvertisementRepository advertisementRepository;

    public List<Advertisement> findAll(){
        return advertisementRepository.findAll();
    }
}
