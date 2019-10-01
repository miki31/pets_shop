package com.shop.olx_pets.service;

import com.shop.olx_pets.model.Advertisement;
import com.shop.olx_pets.repository.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class AdvertisementService {
    @Autowired
    private AdvertisementRepository advertisementRepository;

    public List<Advertisement> findAll(){
        return advertisementRepository.findAll();
    }

    public Optional<Advertisement> getOne(Long id) {
        return advertisementRepository.findById(id);
    }

    public List<Advertisement> getAvailable() {
        List<Advertisement> advertisementList = advertisementRepository.findAll();
//        List<Advertisement> allTaken = advertisementRepository.findNotReturned();
//        advertisementList.removeAll(allTaken);
        return advertisementList;
    }

    public Advertisement randomAd() {
        List<Advertisement> advertisements = advertisementRepository.findAll();
        Random r = new Random();
        Advertisement advertisement = advertisements.get(r.nextInt(advertisements.size()));
        return advertisement;
    }

//    public List<Advertisement> findByUserIdAndByReturnedIsNull(Long id) {
//        return advertisementRepository.findByUsersIdAndReturnedIsNull(id);
//    }
}
