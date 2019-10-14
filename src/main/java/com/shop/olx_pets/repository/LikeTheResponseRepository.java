package com.shop.olx_pets.repository;

import com.shop.olx_pets.model.LikeTheResponse;
import com.shop.olx_pets.model.Response;
import com.shop.olx_pets.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeTheResponseRepository
        extends JpaRepository<LikeTheResponse, Long> {

    List<LikeTheResponse> findByResponse(Response response);

    LikeTheResponse findByResponseAndAndAppraiser(Response response, User appraiser);

}
