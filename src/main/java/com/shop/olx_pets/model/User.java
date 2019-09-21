package com.shop.olx_pets.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String firstName;
    private String surName;
    private String nickName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @NotBlank
    private String password;
    private String email;

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    private String photo;


    @ManyToMany
    @JoinTable(name = "pet_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "pet_id"))
    private List<Pet> pets;


}
