package com.Alaaapuelsoad.security.service;

import com.Alaaapuelsoad.security.model.Role;
import com.Alaaapuelsoad.security.model.User;
import com.Alaaapuelsoad.security.repository.RoleRepository;
import com.Alaaapuelsoad.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,RoleRepository roleRepository,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User createUser(User user) {
//          plain text password
//        user.setPassword("{noop}" + user.getPassword());

        //BCrypt Password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Correct way to initialize a Set of role names
        Set<String> roleNames = Set.of("customer");

        // Fetch the corresponding roles from the repository
        Set<Role> userRole = roleRepository.findByRoleNameIn(roleNames);

        // Assign roles to the user
        user.setRoles(userRole);

        // Save and return the user with the assigned roles
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public Optional<User> updateUser(long id,User userDetails){
        return userRepository.findById(id).map(user -> {
            user.setUserName(userDetails.getUserName());
            user.setPassword(userDetails.getPassword());
            user.setRoles(userDetails.getRoles());
            return userRepository.save(user);
        });
    }

    @Transactional
    public void deleteUserById(long id){
         userRepository.deleteById(id);
    }


}
