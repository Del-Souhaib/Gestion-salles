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

    @GetMapping("")
    public List<PitchRate> pitchRateList(){
        return pitchRateRepository.findAll();
    }

    @GetMapping("/{id}")
    public PitchRate pitchRate(@PathVariable("id") Long id){
        return pitchRateRepository.getOne(id);
    }

    @PostMapping("")
    public void addPitchRate(@RequestBody PitchRate pitchRate) {
        pitchRateRepository.save(pitchRate);
    }

    @PutMapping("")
    public void updatePitchRate(@RequestBody PitchRate pitchRate) {
        pitchRateRepository.save(pitchRate);
    }


    @DeleteMapping("/{id}")
    public void deletePitchRate(@PathVariable("id") Long id)  {
        pitchRateRepository.deleteById(id);
    }
}
