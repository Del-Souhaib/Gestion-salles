package com.backend.stadiumservice.controller;

import com.backend.stadiumservice.model.Pitch;
import com.backend.stadiumservice.repository.PitchRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/pitches")
public class PitchController {
    @Autowired
    private PitchRepository pitchRepository;

    @GetMapping("")
    public List<Pitch> pitchList(){
        return pitchRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pitch pitch(@PathVariable("id") Long id){
        return pitchRepository.getOne(id);
    }




    @PostMapping("")
    public void addPitch(@RequestParam("user") String data, @RequestParam(name = "image",required = false) MultipartFile image) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        Pitch Pitch =objectMapper.readValue(data, Pitch.class);
        pitchRepository.save(Pitch);
    }

    @PutMapping("")
    public void updatePitch(@RequestParam("user") String data, @RequestParam(name = "image",required = false)MultipartFile image) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        Pitch Pitch =objectMapper.readValue(data, Pitch.class);
        pitchRepository.save(Pitch);
    }


    @DeleteMapping("/{id}")
    public void deletePitch(@PathVariable("id") Long id)  {
        pitchRepository.deleteById(id);
    }
}
