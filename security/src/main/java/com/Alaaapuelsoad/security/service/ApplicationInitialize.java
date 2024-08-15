package com.Alaaapuelsoad.security.service;

import com.Alaaapuelsoad.security.model.Role;
import com.Alaaapuelsoad.security.model.User;
import com.Alaaapuelsoad.security.repository.RoleRepository;
import com.Alaaapuelsoad.security.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class ApplicationInitialize {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationInitialize(RoleRepository roleRepository,UserRepository userRepository,PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    @Transactional
    private void initialize(){

        // Create and save roles
        List<String> roleNames = Arrays.asList("admin", "customer");
        roleNames.forEach(roleName -> {
            if (roleRepository.findByRoleName(roleName) == null) {
                Role role = new Role();
                role.setRoleName(roleName);
                roleRepository.save(role);
            }
        });

        if (userRepository.findByUserName("admin") == null){
            Set<String> adminRole = Set.of("admin");
            User user = new User();
            user.setRoles(roleRepository.findByRoleNameIn(adminRole));
            user.setUserName("admin");
            user.setPassword(passwordEncoder.encode("admin123"));

            userRepository.save(user);
        }

    }
}
