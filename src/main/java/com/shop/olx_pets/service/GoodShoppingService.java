package com.shop.olx_pets.service;

import com.shop.olx_pets.model.Advertisement;
import com.shop.olx_pets.model.GoodShopping;
import com.shop.olx_pets.model.Logadvertisement;
import com.shop.olx_pets.model.User;
import com.shop.olx_pets.repository.GoodShoppingRepository;
import com.shop.olx_pets.repository.LogAdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodShoppingService {

    @Autowired
    private GoodShoppingRepository goodShoppingRepository;

    @Autowired
    private LogAdvertisementRepository logAdvertisementRepository;

    public GoodShopping listBuyers(User seller, Logadvertisement logadvertisement) {
        GoodShopping goodShopping = new GoodShopping();
        goodShopping.setAdvertisement(logadvertisement.getAdvertisement());
        goodShopping.setBuyer(logadvertisement.getBuyer());
        goodShopping.setSeller(seller);
        logAdvertisementRepository.delete(logadvertisement);
        return goodShoppingRepository.save(goodShopping);
    }

    public List<Advertisement> getOrderBySeller(Long id) {
        List<Advertisement> advertisements = goodShoppingRepository.findOrderBySeller(id);
        return advertisements;
    }

    public List<Advertisement> getOrderByBuyer(Long id) {
        List<Advertisement> advertisements = goodShoppingRepository.findOrderByBuyer(id);
        return advertisements;
    }
}
