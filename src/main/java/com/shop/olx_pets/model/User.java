package com.shop.olx_pets.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user_olx")
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Must not be blank")
    private String firstName;

    @NotBlank(message = "Must not be blank")
    private String surName;

    @NotBlank(message = "Must not be blank")
//    @Min(message = "Password must be at least 3 characters long", value = 3)
    private String nickName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Must not be blank")
    @Past(message = "You are not yet born))")
    private LocalDate birthday;

    @NotBlank(message = "Must not be blank")
//    @Min(message = "Password must be at least 6 characters long", value = 6)
    private String password;

    @NotBlank(message = "Must not be blank")
    @Email(message = "Must be a valid email address")
    private String email;

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    private String photo;

//    @OneToMany(mappedBy="seller", fetch = FetchType.LAZY)
//    private List<Advertisement> adsForSale;

    @ManyToMany
    @JoinTable(name = "pet_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "pet_id"))
    private List<Pet> pets;

    @ManyToMany
    @JoinTable(name = "advertisement_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "advertisement_id"))
    private List<Advertisement> advertisements;

}
