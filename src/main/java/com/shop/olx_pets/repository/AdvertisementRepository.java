package com.shop.olx_pets.repository;

import com.shop.olx_pets.model.Advertisement;
import com.shop.olx_pets.model.Category;
import com.shop.olx_pets.model.Response;
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

//    @Query("SELECT r FROM Response r WHERE r.author.id = :authorId ORDER BY r.posted DESC")
//    List<Response> findByAuthorIdAndSortByPosted(Long authorId);

    @Query("SELECT ad FROM Advertisement ad WHERE ad.category = :category ORDER BY ad.postedOn DESC")
    List<Advertisement> findByCategoryAndSortByPosted(Category category);

//    @Query("SELECT ad FROM Advertisement ad WHERE ad.price BETWEEN :minPrice AND :maxPrice ORDER BY ad.price")
    List<Advertisement> findByPriceIsBetween(long minPrice, long maxPrice);

//    @Query("SELECT ad FROM Advertisement ad WHERE ad.price BETWEEN :minPrice AND :maxPrice ORDER BY ad.price")
    List<Advertisement> findByPriceIsBetweenOrderByPostedOnDesc(long minPrice, long maxPrice);

//    @Query("SELECT ad FROM Advertisement ad WHERE ad.price BETWEEN :minPrice AND :maxPrice ORDER BY ad.price")
    List<Advertisement> findByCategoryAndPriceIsBetween(Category category, long minPrice, long maxPrice);

    List<Advertisement> findByCategoryAndPriceIsBetweenOrderByPostedOnDesc(Category category, long minPrice, long maxPrice);

    List<Advertisement> findByCategoryAndPriceIsBetweenOrderByPostedOnDescPriceDesc(Category category, long minPrice, long maxPrice);

    List<Advertisement> findByCategoryAndPriceIsBetweenOrderByPostedOnDescPriceAsc(Category category, long minPrice, long maxPrice);

    List<Advertisement> findByCategoryAndPriceIsBetweenOrderByPriceDesc(Category category, long minPrice, long maxPrice);

    List<Advertisement> findByCategoryAndPriceIsBetweenOrderByPriceAsc(Category category, long minPrice, long maxPrice);

    List<Advertisement> findByPriceIsBetweenOrderByPostedOnDescPriceDesc(long minPrice, long maxPrice);

    List<Advertisement> findByPriceIsBetweenOrderByPostedOnDescPriceAsc(long minPrice, long maxPrice);

    List<Advertisement> findByPriceIsBetweenOrderByPriceDesc(long minPrice, long maxPrice);

    List<Advertisement> findByPriceIsBetweenOrderByPriceAsc(long minPrice, long maxPrice);


//    List<Advertisement> findByCategoryAndPriceIsBetween

}
