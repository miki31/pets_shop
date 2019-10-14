package com.shop.olx_pets.service;

import com.shop.olx_pets.model.LikeTheResponse;
import com.shop.olx_pets.model.Response;
import com.shop.olx_pets.model.User;
import com.shop.olx_pets.repository.LikeTheResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeTheResponseService {

    @Autowired
    private LikeTheResponseRepository likeTheResponseRepository;

    @Autowired
    private ResponseService responseService;

    public List<LikeTheResponse> findByResponse(Response response){
        List<LikeTheResponse> likeTheResponses =
                likeTheResponseRepository.findByResponse(response);
        return likeTheResponses;
    }

    public LikeTheResponse findByResponseAndAppraiser(
            Response response, User appraiser){
        LikeTheResponse likeTheResponse =
                likeTheResponseRepository.findByResponseAndAndAppraiser(
                        response, appraiser
                );
        return likeTheResponse;
    }

    public LikeTheResponse createUpdate(LikeTheResponse likeTheResponse) {
        LikeTheResponse likeFromDB =
                findByResponseAndAppraiser(
                        likeTheResponse.getResponse(),
                        likeTheResponse.getAppraiser()
                );

        if (likeFromDB != null){
            likeTheResponse.setId(likeFromDB.getId());
        }

        LikeTheResponse toSave =
                likeTheResponse.getId() == null ?
                        createLikeDislike(likeTheResponse) :
                        updateLikeDislike(likeTheResponse);

        return likeTheResponseRepository.save(toSave);

    }

    private LikeTheResponse createLikeDislike(LikeTheResponse likeTheResponse) {
        return likeTheResponse;
    }

    private LikeTheResponse updateLikeDislike(LikeTheResponse likeTheResponse) {
        return likeTheResponse;
    }

    public void deleteLikeDislike(Long idResponse, User appraiser){
        Response response = responseService.findById(idResponse);

        LikeTheResponse toDelete =
                findByResponseAndAppraiser(response, appraiser);

        likeTheResponseRepository.delete(toDelete);
    }
}
