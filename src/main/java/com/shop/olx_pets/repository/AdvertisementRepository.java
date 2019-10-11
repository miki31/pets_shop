package com.shop.olx_pets.repository;

import com.shop.olx_pets.model.Advertisement;
import com.shop.olx_pets.model.Category;
import com.shop.olx_pets.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.List;

@Repository
public interface AdvertisementRepository extends JpaRepository <Advertisement, Long> {
    /*
      TODO: Use this method for paging and sort
      https://www.baeldung.com/spring-data-jpa-pagination-sorting
     */

    List<Advertisement> findBySeller(User seller);

    List<Advertisement> findByCategory(Category category);

//    @Query("SELECT ad FROM Advertisement ad WHERE ad.price BETWEEN :minPrice AND :maxPrice ORDER BY ad.price")
    List<Advertisement> findByPriceIsBetween(long minPrice, long maxPrice);

//    @Query("SELECT ad FROM Advertisement ad WHERE ad.price BETWEEN :minPrice AND :maxPrice ORDER BY ad.price")
    List<Advertisement> findByCategoryAndPriceIsBetween(Category category, long minPrice, long maxPrice);



//    List<Advertisement> findByCategoryAndPriceIsBetween

}
