package com.shop.olx_pets.service;

import com.shop.olx_pets.model.Advertisement;
import com.shop.olx_pets.model.User;
import com.shop.olx_pets.repository.AdvertisementRepository;
import com.shop.olx_pets.repository.LogAdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class AdvertisementService {
    @Autowired
    private AdvertisementRepository advertisementRepository;

    @Autowired
    private LogAdvertisementRepository logAdvertisementRepository;

    public List<Advertisement> findAll(){
        return advertisementRepository.findAll();
    }

    public Advertisement getOne(Long id) {
        return advertisementRepository.findById(id).orElse(null);
    }
//      TODO: change methot getOne like next method. User custom Exception
//    public Book getOne(Long id) {
//        return bookRepository.findById(id).orElseThrow(() -> {
//            BookNotFoundException e = new BookNotFoundException(id);
//            log.error("Book Not Found", e);
//            return e;
//        });
//    }

    public List<Advertisement> getAvailable() {
        List<Advertisement> advertisementList = advertisementRepository.findAll();
//        List<Advertisement> allTaken = advertisementRepository.findNotReturned();
//        advertisementList.removeAll(allTaken);
        return advertisementList;
    }

    public List<Advertisement> getOrderByUser(Long buyerId) {
        List<Advertisement> advertisements= logAdvertisementRepository.findOrderByUser(buyerId);
        return advertisements;
    }

    public Advertisement randomAd() {
        List<Advertisement> advertisements = findAll();
        Random r = new Random();
        Advertisement advertisement = advertisements.get(r.nextInt(advertisements.size()));
        return advertisement;
    }

//    public List<Advertisement> findByUserIdAndByReturnedIsNull(Long id) {
//        return advertisementRepository.findByUsersIdAndReturnedIsNull(id);
//    }

    public Advertisement createUpdate(Advertisement advertisement){
        Advertisement toSave =
                advertisement.getId() == null ?
                        createAdvertisement(advertisement) :
                        updateAdvertisement(advertisement);

        return advertisementRepository.save(toSave);
    }

    private Advertisement updateAdvertisement(Advertisement advertisement) {
        Advertisement origin = advertisementRepository.findById(advertisement.getId()).get();

        /* TODO: The check here should be whether the fields are even.
         *  For example, the ability to cancel a price for a product
         */

        if (!StringUtils.isEmpty(advertisement.getTitle())){
            origin.setTitle(advertisement.getTitle());
        }

        if (!StringUtils.isEmpty(advertisement.getDescription())){
            origin.setDescription(advertisement.getDescription());
        }

        if (!StringUtils.isEmpty(advertisement.getPrice())){
            origin.setPrice(advertisement.getPrice());
        }

        if (!StringUtils.isEmpty(advertisement.getPhoto())){
            origin.setPhoto(advertisement.getPhoto());
        }

        //TODO: update creating Date or not ???
//        if (!StringUtils.isEmpty(advertisement.getPostedOn())) {
//            origin.setPostedOn(updateDay(advertisement));
//        } else {
//            origin.setPostedOn(updateDay(origin));
//        }
        origin.setPostedOn(updateDay(origin));

        if (!StringUtils.isEmpty(advertisement.getCategory())){
            origin.setCategory(advertisement.getCategory());
        }

        return origin;
    }

    private Advertisement createAdvertisement(Advertisement advertisement) {
        advertisement.setPostedOn(LocalDate.now());

        advertisement.setPostedOn(updateDay(advertisement));

        return advertisement;
    }


    //TODO: WHY???  I can't find another solution to fix this problem
    private LocalDate updateDay(Advertisement advertisement){
        LocalDate localDate = advertisement.getPostedOn();
        return localDate.plusDays(1);
    }

    public void delete(Long id) {
        Optional<Advertisement> toDelete = advertisementRepository.findById(id);
        if (toDelete.isPresent()) {
            advertisementRepository.delete(toDelete.get());
        }
    }
}
