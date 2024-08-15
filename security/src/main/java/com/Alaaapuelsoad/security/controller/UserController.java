package com.Alaaapuelsoad.security.controller;

import com.Alaaapuelsoad.security.model.User;
import com.Alaaapuelsoad.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public User createRole(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }
    @PutMapping("/users/{id}")
    public Optional<User> updateUser(@PathVariable long id, User user){
        return userService.updateUser(id,user);
    }
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable long id){
        userService.deleteUserById(id);
        return "user with id - "+id+" Deleted successfully";
    }
}
