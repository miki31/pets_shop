package com.shop.olx_pets.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "category")
@JsonIgnoreProperties(value = { "handler", "hibernateLazyInitializer" })
public class Category {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;

//    @OneToMany(mappedBy = "category")
//    private List<Pet> pets;

}
