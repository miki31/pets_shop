package com.shop.olx_pets.service;

import com.shop.olx_pets.model.Response;
import com.shop.olx_pets.model.User;
import com.shop.olx_pets.repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ResponseService {

    @Autowired
    ResponseRepository responseRepository;

    public List<Response> findAllByReviewer(User reviewer) {
        List<Response> responses = responseRepository.findByReviewer(reviewer);
        return responses;
    }

    public List<Response> findAllByAuthor(User author) {
        List<Response> responses = responseRepository.findByAuthor(author);
        return responses;
    }

    public Response findById(Long id){
        return responseRepository.findById(id).get();
    }

    public List<Response> findByAuthorIdAndSortByPosted(Long authorId){
        List<Response> responses = responseRepository.findByAuthorIdAndSortByPosted(authorId);
        return responses;
    }

    public Response createUpdate(Response response){
        Response toSave =
                response.getId() == null ?
                        createResponse(response) :
                        updateResponse(response);

        return responseRepository.save(toSave);
    }

    private Response createResponse(Response response){
        response.setPosted(LocalDateTime.now());

        return response;
    }

    private Response updateResponse(Response response){
        return response;
    }

}
