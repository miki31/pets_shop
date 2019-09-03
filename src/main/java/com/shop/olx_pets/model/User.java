package com.shop.olx_pets.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String firstName;
    private String surName;
    private String nickName;

    @NotBlank
    private String password;
    private String email;

    @NotBlank
    private String role;


    @ManyToMany
    @JoinTable(name = "pet_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "pet_id"))
    private List<Pet> pets;


}
