package com.backend.stadiumservice.controller;

import com.backend.stadiumservice.model.Pitch;
import com.backend.stadiumservice.model.PitchImage;
import com.backend.stadiumservice.repository.PitchImageRepository;
import com.backend.stadiumservice.repository.PitchRepository;
import com.backend.stadiumservice.service.StorageService;
import com.backend.stadiumservice.service.StorageService2;
import com.example.openfeign.storageService.OFStorageController;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/pitches")
@Slf4j
public class PitchController {
    @Autowired
    private PitchRepository pitchRepository;

    @Autowired
    private PitchImageRepository pitchImageRepository;

    @Autowired
    private StorageService2 storageService;

    @GetMapping("")
    public List<Pitch> pitchList() {
        return pitchRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pitch pitch(@PathVariable("id") Long id) {
        return pitchRepository.findFirstById(id);
    }



    @PostMapping(value = "")
    public void addPitch(@RequestParam("data") String data,
                         @RequestParam(name = "dataImages") MultipartFile[] dataImages) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Pitch pitch = objectMapper.readValue(data, Pitch.class);
        pitchRepository.save(pitch);

        log.info(Arrays.toString(dataImages));
        for (MultipartFile image : dataImages) {
            PitchImage pitchImage = pitchImageRepository.save(new PitchImage());
            String imageName = "pitches/pitches-images/" + pitchImage.getId() + "." + image.getContentType().split("/")[1];

            log.info("-------------------------------hrtr------------------------------");

            log.info(imageName);
            pitchImage.setName(imageName);
            pitchImage.setPitch(pitch);
            pitchImageRepository.save(pitchImage);
//            pitch.getImages().add(pitchImage);


            storageService.uploadFile(imageName, image);
        }
//        pitchRepository.save(pitch);

    }

    @PutMapping("")
    public void updatePitch(@RequestParam("user") String data, @RequestParam(name = "image", required = false) MultipartFile image) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Pitch Pitch = objectMapper.readValue(data, Pitch.class);
        pitchRepository.save(Pitch);
    }


    @DeleteMapping("/{id}")
    public List<Pitch> deletePitch(@PathVariable("id") Long id) {
        pitchRepository.deleteById(id);
        return pitchRepository.findAll();
    }

    @DeleteMapping("/all")
    public List<Pitch> deleteAllPitch() {
        pitchRepository.deleteAll();
        return pitchRepository.findAll();
    }

}
