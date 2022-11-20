package com.backend.storageservice.controller;

import com.backend.storageservice.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/api/pitches")
public class StorageController {

    @Autowired
    StorageService storageService;

    @GetMapping("")
    public InputStream GetImage(@RequestParam String file) throws IOException {
        return storageService.download(file);
    }

    @PostMapping("")
    public void StorageImage(@RequestParam String fileName, @RequestParam MultipartFile file) {
        storageService.upload(fileName, file);
    }
}
