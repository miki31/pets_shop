package com.shop.olx_pets.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Logadvertisement {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private User buyer;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private Advertisement advertisement;
}