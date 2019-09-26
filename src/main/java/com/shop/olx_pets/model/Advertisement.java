package com.shop.olx_pets.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "advertisement")
@JsonIgnoreProperties(value = { "handler", "hibernateLazyInitializer" })
public class Advertisement {

    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private Double price;
    private String photo;
    private LocalDate postedOn;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name="category_id", nullable=false)
    private Category category;






}
