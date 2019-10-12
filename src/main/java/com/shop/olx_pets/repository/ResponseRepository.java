package com.shop.olx_pets.repository;

import com.shop.olx_pets.model.Response;
import com.shop.olx_pets.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Long> {

    List<Response> findByReviewer(User reviewer);

    List<Response> findByAuthor(User author);

}
