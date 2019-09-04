package com.shop.olx_pets.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String firstName;
    private String surName;
    private String nickName;
    private Date birthday;

    @NotBlank
    private String password;
    private String email;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role = Role.GUEST;


    @ManyToMany
    @JoinTable(name = "pet_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "pet_id"))
    private List<Pet> pets;


}
