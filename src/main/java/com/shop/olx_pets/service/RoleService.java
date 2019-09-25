package com.shop.olx_pets.service;

import com.shop.olx_pets.model.Role;
import com.shop.olx_pets.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> findAll(){
        return roleRepository.findAll();
    }

    public Role findByName(String name){
        return roleRepository.findByName(name);
    }

}
