package com.shop.olx_pets.model.dto;

import com.shop.olx_pets.model.Category;

public class SearchDTO {

    private Category category;
    private Integer page;
    private Integer sizeList;

    private Long minPrice;
    private Long maxPrice;
    private Long maxPriceInGroup;

    private Boolean sortByPostedDate;

    private Boolean sortByPrice;
    private Boolean sortByPriceFromCheap;

    public Boolean getSortByPrice() {
        return sortByPrice;
    }

    public void setSortByPrice(Boolean sortByPrice) {
        this.sortByPrice = sortByPrice;
    }

    public Boolean getSortByPriceFromCheap() {
        return sortByPriceFromCheap;
    }

    public void setSortByPriceFromCheap(Boolean sortByPriceFromCheap) {
        this.sortByPriceFromCheap = sortByPriceFromCheap;
    }

    private String userName;

    public SearchDTO() {
    }

    public SearchDTO(Category category, Integer page, Integer sizeList, Long minPrice, Long maxPrice, String userName) {
        this.category = category;
        this.page = page;
        this.sizeList = sizeList;

        this.minPrice = minPrice;
        this.maxPrice = maxPrice;

        this.userName = userName;

        this.sortByPostedDate = false;
        this.sortByPrice = false;
        this.sortByPriceFromCheap = false;
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

    public Long getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Long minPrice) {
        this.minPrice = minPrice;
    }

    public Long getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Long maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getSortByPostedDate() {
        return sortByPostedDate;
    }

    public void setSortByPostedDate(Boolean sortByPostedDate) {
        this.sortByPostedDate = sortByPostedDate;
    }

    public Long getMaxPriceInGroup() {
        return maxPriceInGroup;
    }

    public void setMaxPriceInGroup(Long maxPriceInGroup) {
        this.maxPriceInGroup = maxPriceInGroup;
    }
}
