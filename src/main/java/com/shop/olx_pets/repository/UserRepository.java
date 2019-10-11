package com.shop.olx_pets.repository;

import com.shop.olx_pets.model.Role;
import com.shop.olx_pets.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByNickName(String email);

    List<User> findByRoles(Role role);
}
