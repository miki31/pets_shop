package com.shop.olx_pets.service;


import com.shop.olx_pets.model.Advertisement;
import com.shop.olx_pets.model.Logadvertisement;
import com.shop.olx_pets.model.User;
import com.shop.olx_pets.repository.LogAdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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

    public void canselOrder(User buyer, Advertisement advertisement) {
        List<Logadvertisement> logAdvertisement = logAdvertisementRepository.findAll();
        Logadvertisement logadvertisementFind = logAdvertisementRepository.findByBuyerAndAdvertisement(buyer, advertisement);
        logAdvertisementRepository.delete(logadvertisementFind);
    }

    public Set<Logadvertisement> findByBuyerId(Long id) {
        return logAdvertisementRepository.findByBuyer(id);
    }

    public Logadvertisement findOrder(User buyer, Advertisement advertisement) {
        return logAdvertisementRepository.findByBuyerAndAdvertisement(buyer, advertisement);
    }
}
