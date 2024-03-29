package com.shop.olx_pets.service;

import com.shop.olx_pets.model.Advertisement;
import com.shop.olx_pets.model.Category;
import com.shop.olx_pets.model.Logadvertisement;
import com.shop.olx_pets.model.User;
import com.shop.olx_pets.repository.AdvertisementRepository;
import com.shop.olx_pets.repository.LogAdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.*;

@Service
public class AdvertisementService {

    @Autowired
    private AdvertisementRepository advertisementRepository;

    @Autowired
    private LogAdvertisementRepository logAdvertisementRepository;

    public List<Advertisement> findAll() {
        return advertisementRepository.findAll();
    }

    public Long maxPrice(List<Advertisement> advertisements){
        if (advertisements.isEmpty()){
            return (long)0;
        }

        Advertisement max = Collections.max(advertisements, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                if (o1.getPrice() == o2.getPrice()){
                    return 0;
                } else if (o1.getPrice() > o2.getPrice()){
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        return max.getPrice();
    }

    public List<Advertisement> findAll(User seller) {
        return advertisementRepository.findBySeller(seller);
    }

    public List<Advertisement> littleList(int sizeList) {
        List<Advertisement> advertisements = findAll();
        return littleList(sizeList, advertisements);
    }

    public List<Advertisement> littleList(int sizeList, User seller) {
        List<Advertisement> advertisements = findAll(seller);
        return littleList(sizeList, advertisements);
    }

    private List<Advertisement> littleList(int sizeList, List<Advertisement> advertisements) {
        List<Advertisement> returnAdvertisements = new ArrayList<>();

        if (advertisements.size() == 0) {
            return returnAdvertisements;
        }

        Random r = new Random();
        for (int i = 0; i < sizeList; i++) {
            int j = r.nextInt(advertisements.size());
            Advertisement advertisement = advertisements.get(j);
            advertisements.remove(j);
            returnAdvertisements.add(advertisement);
            if (advertisements.size() == 0) {
                break;
            }
        }
        return returnAdvertisements;
    }

    public List<Advertisement> bigList(int page, int sizeList, List<Advertisement> advertisements) {
        return partOfBigList(page, sizeList, advertisements);
    }

    public List<Advertisement> bigList(int page, int sizeList, User seller, List<Advertisement> advertisements) {
        return bigList(page, sizeList, advertisements);
    }

    private List<Advertisement> partOfBigList(int page, int sizeList, List<Advertisement> advertisements) {
        List<Advertisement> returnAdvertisements = new ArrayList<>();

        if (advertisements.size() == 0) {
            return returnAdvertisements;
        }

        for (int i = (page - 1) * sizeList; i < page * sizeList; i++) {
            if (i >= advertisements.size()) {
                break;
            }
            returnAdvertisements.add(advertisements.get(i));
        }
        return returnAdvertisements;
    }

    public List<Advertisement> findAllByCategory(Category category, Boolean sortByPostedDate) {
        List<Advertisement> advertisements = sortByPostedDate ?
                advertisementRepository.findByCategoryAndSortByPosted(category):
                advertisementRepository.findByCategory(category);
        return advertisements;
    }

    public List<Advertisement> findAllByPriceIsBetween(long minPrice,
                                                       long maxPrice,
                                                       Boolean sortByPostedDate,
                                                       Boolean sortByPrice,
                                                       Boolean sortByPriceFromCheap){
        List<Advertisement> advertisements;

        if (!sortByPrice) {
            advertisements = sortByPostedDate ?
                    advertisementRepository.findByPriceIsBetweenOrderByPostedOnDesc(minPrice, maxPrice) :
                    advertisementRepository.findByPriceIsBetween(minPrice, maxPrice);
        } else {
            if (sortByPostedDate){
                advertisements = sortByPriceFromCheap ?
                        advertisementRepository.findByPriceIsBetweenOrderByPostedOnDescPriceAsc(minPrice, maxPrice) :
                        advertisementRepository.findByPriceIsBetweenOrderByPostedOnDescPriceDesc(minPrice, maxPrice);
            } else {
                advertisements = sortByPriceFromCheap ?
                        advertisementRepository.findByPriceIsBetweenOrderByPriceAsc(minPrice, maxPrice) :
                        advertisementRepository.findByPriceIsBetweenOrderByPriceDesc(minPrice, maxPrice);
            }
        }
        return advertisements;
    }

    public List<Advertisement> findAllByCategoryAndPrice(Category category,
                                                         long minPrice,
                                                         long maxPrice,
                                                         Boolean sortByPostedDate,
                                                         Boolean sortByPrice,
                                                         Boolean sortByPriceFromCheap){
        List<Advertisement> advertisements;

        if (!sortByPrice) {
            advertisements = sortByPostedDate ?
                    advertisementRepository.
                            findByCategoryAndPriceIsBetweenOrderByPostedOnDesc(category, minPrice, maxPrice):
                    advertisementRepository.findByCategoryAndPriceIsBetween(category, minPrice, maxPrice);
        } else {
            if (sortByPostedDate){
                advertisements = sortByPriceFromCheap ?
                        advertisementRepository.
                                findByCategoryAndPriceIsBetweenOrderByPostedOnDescPriceAsc(category, minPrice, maxPrice):
                        advertisementRepository.
                                findByCategoryAndPriceIsBetweenOrderByPostedOnDescPriceDesc(category, minPrice, maxPrice);
            } else {
                advertisements = sortByPriceFromCheap ?
                        advertisementRepository.
                                findByCategoryAndPriceIsBetweenOrderByPriceAsc(category, minPrice, maxPrice):
                        advertisementRepository.
                                findByCategoryAndPriceIsBetweenOrderByPriceDesc(category, minPrice, maxPrice);
            }
        }


//        List<Advertisement> advertisements = sortByPostedDate ?
//                advertisementRepository.
//                        findByCategoryAndPriceIsBetweenOrderByPostedOnDesc(category, minPrice, maxPrice) :
//                advertisementRepository.findByCategoryAndPriceIsBetween(category, minPrice, maxPrice);
        return advertisements;
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

    public Set<Advertisement> getOrderByUser(Long buyerId) {
        Set<Advertisement> advertisements = logAdvertisementRepository.findOrderByUser(buyerId);
        return advertisements;
    }


    public List<Advertisement> getOrders() {
        List<Advertisement> advertisements = logAdvertisementRepository.findOrderByAdvertisement();
        return advertisements;
    }

    public Set<Logadvertisement> ordersFromUsers(User seller) {

        List<Advertisement> advertisements = advertisementRepository.findBySeller(seller);

        List<Logadvertisement> logadvertisements = logAdvertisementRepository.findAll();

        List<Advertisement> advertisements1 = new ArrayList<>();

        for (int y = 0; y < logadvertisements.size(); y++) {
            advertisements1.add(logadvertisements.get(y).getAdvertisement());
        }

        List<Advertisement> advertisementsMy = new ArrayList<>(advertisements1);
        advertisementsMy.retainAll(advertisements);

        Set<Logadvertisement> orderMy = new HashSet<>();

        for (int p = 0; p < advertisementsMy.size(); p++) {
            for (int j = 0; j < logadvertisements.size(); j++) {
                if (logadvertisements.get(j).getAdvertisement() == advertisementsMy.get(p)) {
                    orderMy.add(logadvertisements.get(j));
                }
            }
        }

        return orderMy;
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

    public Advertisement createUpdate(Advertisement advertisement) {

        // price not null
        if (advertisement.getPrice() == null){
            advertisement.setPrice((long) 0);
        }

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

        if (!StringUtils.isEmpty(advertisement.getTitle())) {
            origin.setTitle(advertisement.getTitle());
        }

        if (!StringUtils.isEmpty(advertisement.getDescription())) {
            origin.setDescription(advertisement.getDescription());
        }

        if (!StringUtils.isEmpty(advertisement.getPrice())) {
            origin.setPrice(advertisement.getPrice());
        }

        if (!StringUtils.isEmpty(advertisement.getPhoto())) {
            origin.setPhoto(advertisement.getPhoto());
        }

        //TODO: update creating Date or not ???
//        if (!StringUtils.isEmpty(advertisement.getPostedOn())) {
//            origin.setPostedOn(updateDay(advertisement));
//        } else {
//            origin.setPostedOn(updateDay(origin));
//        }
        origin.setPostedOn(updateDay(origin));

        if (!StringUtils.isEmpty(advertisement.getCategory())) {
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
    private LocalDate updateDay(Advertisement advertisement) {
        LocalDate localDate = advertisement.getPostedOn();
        return localDate.plusDays(1);
    }

    public void delete(Long id) {
        Optional<Advertisement> toDelete = advertisementRepository.findById(id);
        if (toDelete.isPresent()) {
            advertisementRepository.delete(toDelete.get());
        }
    }

    public User getSellerInfo(Long id) {
        return advertisementRepository.getOne(id).getSeller();

    }

}
