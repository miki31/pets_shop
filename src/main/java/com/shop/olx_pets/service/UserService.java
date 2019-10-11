package com.shop.olx_pets.service;

import com.shop.olx_pets.model.Role;
import com.shop.olx_pets.model.User;
import com.shop.olx_pets.repository.CategoryRepository;
import com.shop.olx_pets.repository.PetRepository;
import com.shop.olx_pets.repository.RoleRepository;
import com.shop.olx_pets.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User getOne(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void delete(Long id) {
        Optional<User> toDelete = userRepository.findById(id);
        if (toDelete.isPresent()) {
            userRepository.delete(toDelete.get());
        }
    }

    public User save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Optional<User> findUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);

        return user;
    }

    public Optional<User> findUserByNickName(String nickName) {
        Optional<User> user = userRepository.findByNickName(nickName);

        return user;
    }

    public User createUpdate(User user) {
        User toSave = user.getId() == null ? createUser(user) : updateUser(user);

        System.out.println(user.getBirthday());

        return userRepository.save(toSave);
    }

    private User createUser(User user) {
//        Set<Role> roles = new HashSet<>();
//        roles.add(roleService.findByName("USER"));
//        user.setRoles(roles);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        //TODO: problem with save date
        user.setBirthday(updateBirthday(user));

        return user;

//        return userRepository.save(user);
    }


    private User updateUser(User user) {
        User origin = userRepository.findById(user.getId()).get();

        if (!StringUtils.isEmpty(user.getFirstName())) {
            origin.setFirstName(user.getFirstName());
        }
        if (!StringUtils.isEmpty(user.getSurName())) {
            origin.setSurName(user.getSurName());
        }
        if (!StringUtils.isEmpty(user.getNickName())) {
            origin.setNickName(user.getNickName());
        }


        /*TODO: check correct Date birthday
          this is mistake.
          when we save the date it is deducted 1 day
        * */
        if (!StringUtils.isEmpty(user.getBirthday())) {
            origin.setBirthday(updateBirthday(user));
        } else {
            origin.setBirthday(updateBirthday(origin));
        }


        if (!StringUtils.isEmpty(user.getPassword())) {
            origin.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }

        if (!StringUtils.isEmpty(user.getEmail())) {
            origin.setEmail(user.getEmail());
        }

        if (!StringUtils.isEmpty(user.getPhoto())) {
            origin.setPhoto(user.getPhoto());
        }
        if (!StringUtils.isEmpty(user.getRoles())) {
            origin.setRoles(user.getRoles());
        }

//            Set<Role> roles = new HashSet<>();
//            roles.add(roleService.findByName("user"));
//            origin.setRoles(roles);

//            origin = userRepository.save(origin);
        //TODO: check correct Role ?? If rearly need that

        return origin;
    }

    //TODO: WHY???  I can't find another solution to fix this problem
    private LocalDate updateBirthday(User user) {
        LocalDate localDate = user.getBirthday();
        return localDate.plusDays(1);
    }

    public List<User> findAllUsers(Role role) {

        List<User> usersBuyers = userRepository.findByRoles(role);

        return usersBuyers;
    }
}
