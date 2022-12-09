package com.backend.securityservice.controller;

import com.backend.securityservice.model.MyUser;
import com.backend.securityservice.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public List<MyUser> userList(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public MyUser user(@PathVariable("id") Long id){
        return userRepository.getOne(id);
    }

    @GetMapping("/{email}")
    public MyUser userByEmail(@PathVariable("email") String email){
        return userRepository.findFirstByEmail(email);
    }

    @GetMapping("/{location}")
    public List<MyUser> userListByLocation(@PathVariable("location") String location){
        return userRepository.findAllByLocationContains(location);
    }

//    @GetMapping("/{role}")
//    public List<MyUser> userListByRole(@PathVariable("role") String role){
//        return userRepository.findAllByRole_Nom(role);
//    }

    @PostMapping("")
    public void addUser(@RequestBody MyUser myUser)  {
        userRepository.save(myUser);
    }

    @PutMapping("")
    public void updateUser(@RequestParam("user") String data, @RequestParam(name = "image",required = false)MultipartFile image) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        MyUser myUser =objectMapper.readValue(data, MyUser.class);
        userRepository.save(myUser);
    }


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id)  {
        userRepository.deleteById(id);
    }
}
