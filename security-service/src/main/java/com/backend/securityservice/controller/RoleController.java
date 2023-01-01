package com.backend.securityservice.controller;

import com.backend.securityservice.model.Role;
import com.backend.securityservice.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping
    public List<Role> roleList(){
        return roleRepository.findAll();
    }

    @PostMapping
    public void addList(@RequestBody Role role){
         roleRepository.save(role);
    }

}
