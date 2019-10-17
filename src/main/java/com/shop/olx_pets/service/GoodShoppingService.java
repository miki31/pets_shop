package com.shop.olx_pets.service;

import com.shop.olx_pets.model.*;
import com.shop.olx_pets.repository.BedShoppingRepository;
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
    private BedShoppingRepository bedShoppingRepository;

    @Autowired
    private LogAdvertisementRepository logAdvertisementRepository;

    @Autowired
    private AdvertisementService advertisementService;

    public GoodShopping listBuyers(User seller, Logadvertisement logadvertisement) {
        GoodShopping goodShopping = new GoodShopping();

        Advertisement advertisement = logadvertisement.getAdvertisement();

        goodShopping.setAdvertisement(advertisement);
        goodShopping.setBuyer(logadvertisement.getBuyer());
        goodShopping.setSeller(seller);

        List<Logadvertisement> logadvertisements = logAdvertisementRepository.findByAdvertisement(advertisement);

        BedShopping bedShoppings = new BedShopping();

        for (int i = 0; i < logadvertisements.size(); i++) {
            if (logadvertisements.get(i).getAdvertisement().getId() == advertisement.getId()) {
                if (goodShopping.getBuyer().getId() != logadvertisements.get(i).getBuyer().getId()) {
                    bedShoppings.setAdvertisement(logadvertisements.get(i).getAdvertisement());
                    bedShoppings.setBuyer(logadvertisements.get(i).getBuyer());
                    bedShoppings.setSeller(seller);

                    bedShoppingRepository.save(bedShoppings);
                }

                logAdvertisementRepository.delete(logadvertisements.get(i));
            }
        }

        advertisement.setBuyer(logadvertisement.getBuyer());
        advertisementService.createUpdate(advertisement, false);


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

    public GoodShopping findByAd(Advertisement advertisement) {
        GoodShopping goodShopping = goodShoppingRepository.findByAdvertisement(advertisement);
        return goodShopping;
    }
}
