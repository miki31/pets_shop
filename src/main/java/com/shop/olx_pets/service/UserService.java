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
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RoleRepository roleRepository;


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

    public Optional<User> findUserByEmail(String email){
        Optional<User> user = userRepository.findByEmail(email);

        return user;
    }

    public User createUpdate(User user) {
        User toSave = user.getId() == null ? createUser(user) : updateUser(user);
        return userRepository.save(toSave);
    }

    private User createUser(User user) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("user"));
        user.setRoles(roles);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return user;
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
        //TODO: check correct Date birthday

        if (!StringUtils.isEmpty(user.getPassword())){
            origin.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }
        if (!StringUtils.isEmpty(user.getEmail())) {
            origin.setEmail(user.getEmail());
        }
        if (!StringUtils.isEmpty(user.getPhoto())) {
            origin.setPhoto(user.getPhoto());
        }

            Set<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("user"));
            origin.setRoles(roles);

        //TODO: check correct Role

        return origin;
    }


}
