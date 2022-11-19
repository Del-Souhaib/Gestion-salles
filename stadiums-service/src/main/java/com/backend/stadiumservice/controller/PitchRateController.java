package com.backend.stadiumservice.controller;


import com.backend.stadiumservice.model.Pitch;
import com.backend.stadiumservice.model.PitchRate;
import com.backend.stadiumservice.repository.PitchRateRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/pitchRates")
public class PitchRateController {

    @Autowired
    private PitchRateRepository pitchRateRepository;

    @GetMapping("/")
    public List<PitchRate> pitchRateList(){
        return pitchRateRepository.findAll();
    }

    @GetMapping("/{id}")
    public PitchRate pitchRate(@PathVariable("id") Long id){
        return pitchRateRepository.getOne(id);
    }

    @PostMapping("/")
    public void addPitchRate(@RequestParam("user") String data, @RequestParam(name = "image",required = false) MultipartFile image) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        PitchRate PitchRate =objectMapper.readValue(data, PitchRate.class);
        pitchRateRepository.save(PitchRate);
    }

    @PutMapping("/")
    public void updatePitchRate(@RequestParam("user") String data, @RequestParam(name = "image",required = false)MultipartFile image) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        PitchRate PitchRate =objectMapper.readValue(data, PitchRate.class);
        pitchRateRepository.save(PitchRate);
    }


    @DeleteMapping("/{id}")
    public void deletePitchRate(@PathVariable("id") Long id)  {
        pitchRateRepository.deleteById(id);
    }
}
