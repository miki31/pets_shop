package com.shop.olx_pets.service;

import com.shop.olx_pets.model.LikeTheResponse;
import com.shop.olx_pets.model.Response;
import com.shop.olx_pets.model.User;
import com.shop.olx_pets.model.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResponseDTOService {

    @Autowired
    private ResponseService responseService;

    @Autowired
    private LikeTheResponseService likeTheResponseService;

    public List<ResponseDTO> findAllByAuthor(User author, User appraiser){
        List<Response> responses = responseService.findAllByAuthor(author);

        List<ResponseDTO> responseDTOS = new ArrayList<>();
        for (Response r :
                responses) {
            ResponseDTO rDTO = new ResponseDTO(r);

            List<LikeTheResponse> likeTheResponseList =
                    likeTheResponseService.findByResponse(r);

            int likes = 0;
            int dislikes = 0;

            if (!likeTheResponseList.isEmpty()){

                for (LikeTheResponse like :
                        likeTheResponseList) {
                    if (like.isGood()){
                        likes++;
                    } else {
                        dislikes++;
                    }

                    if (like.getAppraiser().getId() == appraiser.getId()){
                        if (like.isGood())
                        {
                            rDTO.setChoiceLike(true);
                        } else {
                            rDTO.setChoiceDislike(true);
                        }
                    }
                }
            }

            // if show responses about oneself user cannot put like or dislike
            // or if it review this user wrote
            if (author.getId() == appraiser.getId() ||
                    r.getReviewer().getId() == appraiser.getId()
            ){
                rDTO.setChoiceLike(true);
                rDTO.setChoiceDislike(true);
            }

            rDTO.setLikes(likes);
            rDTO.setDislikes(dislikes);

            responseDTOS.add(rDTO);
        }

        return responseDTOS;
    }

}
