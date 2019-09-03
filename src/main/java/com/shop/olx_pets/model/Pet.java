package com.shop.olx_pets.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double price;

    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Category category;

    // mappedBy = "pets" must be same as name in User class
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "pets")
    private List<User> users;

}
