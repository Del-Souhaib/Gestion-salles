package com.backend.stadiumservice.controller;

import com.backend.stadiumservice.model.Pitch;
import com.backend.stadiumservice.model.PitchImage;
import com.backend.stadiumservice.repository.PitchImageRepository;
import com.backend.stadiumservice.repository.PitchRepository;
import com.backend.stadiumservice.service.StorageService2;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/pitchesImages")
@Slf4j
public class PitchImagesController {

    @Autowired
    private PitchImageRepository pitchImageRepository;


    @GetMapping("")
    public List<PitchImage> pitchList() {
        return pitchImageRepository.findAll();
    }


    @DeleteMapping("/all")
    public List<PitchImage> deleteAllPitch() {
        pitchImageRepository.deleteAll();
        return pitchImageRepository.findAll();
    }

}
