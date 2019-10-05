package com.shop.olx_pets.service;


import com.shop.olx_pets.model.Advertisement;
import com.shop.olx_pets.model.Logadvertisement;
import com.shop.olx_pets.model.User;
import com.shop.olx_pets.repository.LogAdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
public class LogAdvertisementService {

    @Autowired
    private LogAdvertisementRepository logAdvertisementRepository;

    @Autowired
    private UserService userService;

    public Logadvertisement getOne(Long id) {
        return logAdvertisementRepository.findById(id).orElse(null);
    }

    public Logadvertisement order(User buyer, Advertisement advertisement) {
        Logadvertisement logAdvertisement = new Logadvertisement();
        logAdvertisement.setBuyer(buyer);
        logAdvertisement.setAdvertisement(advertisement);
        return logAdvertisementRepository.save(logAdvertisement);
    }

    public List<Logadvertisement> findByBuyerId(Long id) {
        return logAdvertisementRepository.findByBuyer(id);
    }
}
