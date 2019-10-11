package com.shop.olx_pets.model.dto;

import com.shop.olx_pets.model.Category;

public class SearchDTO {

    private Category category;
    private Integer page;
    private Integer sizeList;

    private Integer minPrice;
    private Integer maxPrice;

    private String userName;

    public SearchDTO() {
    }

    public SearchDTO(Category category, Integer page, Integer sizeList, Integer minPrice, Integer maxPrice, String userName) {
        this.category = category;
        this.page = page;
        this.sizeList = sizeList;

        this.minPrice = minPrice;
        this.maxPrice = maxPrice;

        this.userName = userName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSizeList() {
        return sizeList;
    }

    public void setSizeList(Integer sizeList) {
        this.sizeList = sizeList;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
