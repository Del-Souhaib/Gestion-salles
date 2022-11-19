package com.backend.securityservice.controller;


import com.backend.securityservice.model.PlayerRate;
import com.backend.securityservice.repository.PlayerRateRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/playerRates")
public class PlayerRateController {

    @Autowired
    private PlayerRateRepository playerRateRepository;

    @GetMapping("/")
    public List<PlayerRate> PlayerRateList(){
        return playerRateRepository.findAll();
    }

    @GetMapping("/{id}")
    public PlayerRate PlayerRate(@PathVariable("id") Long id){
        return playerRateRepository.getOne(id);
    }

    @PostMapping("/")
    public void addPitchRate(@RequestParam("user") String data, @RequestParam(name = "image",required = false) MultipartFile image) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        PlayerRate PlayerRate =objectMapper.readValue(data, PlayerRate.class);
        playerRateRepository.save(PlayerRate);
    }

    @PutMapping("/")
    public void updatePlayerRate(@RequestParam("user") String data, @RequestParam(name = "image",required = false)MultipartFile image) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        PlayerRate PlayerRate =objectMapper.readValue(data, PlayerRate.class);
        playerRateRepository.save(PlayerRate);
    }


    @DeleteMapping("/{id}")
    public void deletePlayerRate(@PathVariable("id") Long id)  {
        playerRateRepository.deleteById(id);
    }
}
