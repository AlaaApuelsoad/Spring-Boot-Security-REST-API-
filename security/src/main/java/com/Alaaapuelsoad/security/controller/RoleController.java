package com.Alaaapuelsoad.security.controller;

import com.Alaaapuelsoad.security.model.Role;
import com.Alaaapuelsoad.security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {


    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/roles")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }
    @PostMapping("/roles")
    public Role createRole(@RequestBody Role role){
        return roleService.createRole(role);
    }
}
