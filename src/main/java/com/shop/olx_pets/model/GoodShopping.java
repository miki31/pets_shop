package com.shop.olx_pets.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "goodshopping")
public class GoodShopping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private User buyer;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private Advertisement advertisement;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private User seller;
}


