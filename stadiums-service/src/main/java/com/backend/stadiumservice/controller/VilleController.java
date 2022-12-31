package com.backend.stadiumservice.controller;

import com.backend.stadiumservice.model.Ville;
import com.backend.stadiumservice.repository.VilleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/villes")
@Slf4j
public class VilleController {

    @Autowired
    private VilleRepository villeRepository;


    @GetMapping("")
    public List<Ville> villeList() {
        return villeRepository.findAll();
    }


    @GetMapping("/{id}")
    public Ville ville(@PathVariable("id") Long id) {
        return villeRepository.findFirstById(id);
    }


    @PostMapping(value = "")
    public void addVille(@RequestBody Ville ville)  {
        villeRepository.save(ville);
    }

    @PutMapping("")
    public void updateVille(@RequestBody Ville ville)  {
        villeRepository.save(ville);
    }

    @DeleteMapping("/{id}")
    public List<Ville> deleteVille(@PathVariable("id") Long id) {
        villeRepository.deleteById(id);
        return villeRepository.findAll();
    }

}
