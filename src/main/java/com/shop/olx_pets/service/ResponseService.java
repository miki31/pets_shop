package com.shop.olx_pets.service;

import com.shop.olx_pets.model.Response;
import com.shop.olx_pets.model.User;
import com.shop.olx_pets.repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseService {

    @Autowired
    ResponseRepository responseRepository;

    public List<Response> findAllByReviewer(User reviewer) {
        List<Response> responses = responseRepository.findByReviewer(reviewer);
        return responses;
    }

    public Response findById(Long id){
        return responseRepository.findById(id).get();
    }

}
