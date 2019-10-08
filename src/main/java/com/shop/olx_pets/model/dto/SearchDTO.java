package com.shop.olx_pets.model.dto;

import com.shop.olx_pets.model.Category;

public class SearchDTO {

    private Category category;
    private Integer page;
    private Integer sizeList;

    public SearchDTO() {
    }

    public SearchDTO(Category category, Integer page, Integer sizeList) {
        this.category = category;
        this.page = page;
        this.sizeList = sizeList;
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
}
