package com.shop.olx_pets;

import com.shop.olx_pets.model.Role;
import com.shop.olx_pets.model.User;
import com.shop.olx_pets.repository.RoleRepository;
import com.shop.olx_pets.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class OlxPetsApplication {



    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        SpringApplication.run(OlxPetsApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository userRepository, RoleRepository roleRepository) {
        return (args) -> {
            Role role;
            role = roleRepository.findByName("ADMIN");
            if (role != null){
                return;
            }

            role = new Role();
            role.setName("ADMIN");
            roleRepository.save(role);

            role = new Role();
            role.setName("USER");
            roleRepository.save(role);

            role = new Role();
            role.setName("SELLER");
            roleRepository.save(role);

            User u = new User();

            u.setFirstName("Admin");
            u.setSurName("Admin");
            Set<Role> roles = new HashSet<>();

            role = roleRepository.findByName("ADMIN");
            roles.add(role);

            u.setRoles(roles);
            u.setEmail("admin@gmail.com");
            u.setPassword(passwordEncoder().encode("123"));
            u.setNickName("AaAaAa");
            u.setBirthday(LocalDate.now().minusYears(20));

            userRepository.save(u);
        };
    }
}
