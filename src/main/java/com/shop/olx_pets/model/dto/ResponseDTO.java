package com.shop.olx_pets.model.dto;

import com.shop.olx_pets.model.Response;
import com.shop.olx_pets.model.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

public class ResponseDTO {

    private Long id;
    // The one who leaves the review
    private User reviewer;

    // The one about whom the review was written
    private User author;

    private String responseText;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime posted;

    boolean good;

    private int likes;

    private int dislikes;

    private Boolean choiceLike;

    private Boolean choiceDislike;

    public ResponseDTO() {
        this.likes = 0;
        this.dislikes = 0;
        this.choiceLike = false;
        this.choiceDislike = false;
    }

    public ResponseDTO(Response response) {
        this.id = response.getId();
        this.reviewer = response.getReviewer();
        this.author = response.getAuthor();
        this.responseText = response.getResponseText();
        this.posted = response.getPosted();
        this.good = response.isGood();

        this.likes = 0;
        this.dislikes = 0;
        this.choiceLike = false;
        this.choiceDislike = false;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public LocalDateTime getPosted() {
        return posted;
    }

    public void setPosted(LocalDateTime posted) {
        this.posted = posted;
    }

    public boolean isGood() {
        return good;
    }

    public void setGood(boolean good) {
        this.good = good;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public Boolean getChoiceLike() {
        return choiceLike;
    }

    public void setChoiceLike(Boolean choiceLike) {
        this.choiceLike = choiceLike;
    }

    public Boolean getChoiceDislike() {
        return choiceDislike;
    }

    public void setChoiceDislike(Boolean choiceDislike) {
        this.choiceDislike = choiceDislike;
    }
}
