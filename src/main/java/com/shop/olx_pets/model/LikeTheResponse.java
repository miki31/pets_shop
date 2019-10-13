package com.shop.olx_pets.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class LikeTheResponse {

    @Id
    @GeneratedValue
    private Long id;

    private boolean good;

    @ManyToOne(fetch = FetchType.LAZY,
                cascade = CascadeType.REFRESH)
    @JoinColumn(name = "appraiser_id",
                nullable = false,
                referencedColumnName = "id")
    private User appraiser; // оцінювач

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.REFRESH)
    @JoinColumn(name = "response_id",
            nullable = false,
            referencedColumnName = "id")
    private Response response;
}
