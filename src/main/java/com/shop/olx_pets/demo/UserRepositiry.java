package com.shop.olx_pets.demo;

import com.shop.olx_pets.demo.DemoUser;
import org.springframework.data.repository.CrudRepository;



// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

interface DemoUserRepository extends CrudRepository<DemoUser, Integer> {

}
