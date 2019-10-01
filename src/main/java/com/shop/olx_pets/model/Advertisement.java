package com.shop.olx_pets.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "advertisement")
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer"})
public class Advertisement {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "seller_id", nullable = false, referencedColumnName = "id")
    private User seller;

    private String title;   // name
    private String description;
    private Double price;
    private String photo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "posted_on")
    private LocalDate postedOn;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

//    TODO: create this field in future
//    private Subcategory subcategory;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "advertisements")
    private List<User> users;


}
