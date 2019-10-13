package com.shop.olx_pets.service;

import com.shop.olx_pets.model.LikeTheResponse;
import com.shop.olx_pets.model.Response;
import com.shop.olx_pets.repository.LikeTheResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeTheResponseService {

    @Autowired
    private LikeTheResponseRepository likeTheResponseRepository;

    public List<LikeTheResponse> findByResponse(Response response){
        List<LikeTheResponse> likeTheResponses =
                likeTheResponseRepository.findByResponse(response);
        return likeTheResponses;
    }

}
