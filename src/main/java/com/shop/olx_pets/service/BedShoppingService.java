package com.shop.olx_pets.service;

import com.shop.olx_pets.model.*;
import com.shop.olx_pets.repository.BedShoppingRepository;
import com.shop.olx_pets.repository.LogAdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BedShoppingService {

    @Autowired
    private BedShoppingRepository bedShoppingRepository;

    @Autowired
    private LogAdvertisementRepository logAdvertisementRepository;

    @Autowired
    private AdvertisementService advertisementService;

//    public BedShopping listBuyers(User seller, Logadvertisement logadvertisement) {
//        BedShopping bedShopping = new BedShopping();
//        Advertisement advertisement = logadvertisement.getAdvertisement();
//        bedShopping.setAdvertisement(advertisement);
//        bedShopping.setBuyer(logadvertisement.getBuyer());
//        bedShopping.setSeller(seller);
//
//        List<Logadvertisement> logadvertisements = logAdvertisementRepository.findByAdvertisement(advertisement);
//        for (int i = 0; i < logadvertisements.size(); i++) {
//            if (logadvertisements.get(i).getAdvertisement().getId() == advertisement.getId()) {
//                logAdvertisementRepository.delete(logadvertisements.get(i));
//            }
//        }
//
//        advertisement.setBuyer(logadvertisement.getBuyer());
//        advertisementService.createUpdate(advertisement);
//
//        return bedShoppingRepository.save(bedShopping);
//    }


    public List<Advertisement> getOrderByBuyer(Long id) {
        BedShopping bedShopping = new BedShopping();


        List<Advertisement> advertisements = bedShoppingRepository.findOrderByBuyer(id);
        return advertisements;
    }
}
