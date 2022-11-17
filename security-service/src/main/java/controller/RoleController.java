package controller;

import model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.RoleRepository;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    @Autowired
    RoleRepository roleRepository;

    @GetMapping
    public List<Role> roleList(){
        return roleRepository.findAll();
    }

}
