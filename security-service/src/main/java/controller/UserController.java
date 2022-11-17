package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import repository.UserRepository;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public List<User> userList(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User user(@PathVariable("id") Long id){
        return userRepository.getOne(id);
    }

    @GetMapping("/{email}")
    public User userByEmail(@PathVariable("email") String email){
        return userRepository.findFirstByEmail(email);
    }

    @GetMapping("/{location}")
    public List<User> userListByLocation(@PathVariable("location") String location){
        return userRepository.findAllByLocationContains(location);
    }

    @GetMapping("/{role}")
    public List<User> userListByRole(@PathVariable("role") String role){
        return userRepository.findAllByRole_Nom(role);
    }

    @PostMapping("/")
    public void addUser(@RequestParam("user") String data, @RequestParam(name = "image",required = false)MultipartFile image) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        User user=objectMapper.readValue(data,User.class);
        userRepository.save(user);
    }

    @PutMapping("/")
    public void updateUser(@RequestParam("user") String data, @RequestParam(name = "image",required = false)MultipartFile image) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        User user=objectMapper.readValue(data,User.class);
        userRepository.save(user);
    }


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id)  {
        userRepository.deleteById(id);
    }
}
