package com.shop.olx_pets.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "pet")
@JsonIgnoreProperties(value = { "handler", "hibernateLazyInitializer" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pet {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double price;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name="category_id", nullable=false)
    private Category category;

    // mappedBy = "pets" must be same as name in User class
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "pets")
    private List<User> users;

}
