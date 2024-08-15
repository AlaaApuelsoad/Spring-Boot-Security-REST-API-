package com.Alaaapuelsoad.security.service;

import com.Alaaapuelsoad.security.model.Role;
import com.Alaaapuelsoad.security.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleService {


    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional
    public Role createRole(Role role){
        return roleRepository.save(role);
    }
    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }
}
