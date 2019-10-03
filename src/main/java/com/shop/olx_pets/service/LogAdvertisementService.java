package com.shop.olx_pets.service;


import com.shop.olx_pets.model.Advertisement;
import com.shop.olx_pets.model.Logadvertisement;
import com.shop.olx_pets.model.User;
import com.shop.olx_pets.repository.LogAdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LogAdvertisementService {

    @Autowired
    private LogAdvertisementRepository logAdvertisementRepository;


    public Logadvertisement order(User buyer, Advertisement advertisement) {
        Logadvertisement logAdvertisement = new Logadvertisement();
        logAdvertisement.setBuyer(buyer);
        logAdvertisement.setAdvertisement(advertisement);
        return logAdvertisementRepository.save(logAdvertisement);
    }

}
