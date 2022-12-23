package com.backend.storageservice.controller;

import com.backend.storageservice.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/api/storage")
public class StorageController {

    @Autowired
    StorageService storageService;

    @GetMapping("")
    public byte[] getImage(@RequestParam("filePath") String filePath) throws IOException {
        return storageService.downloadFile(filePath);
    }


    @PostMapping(value = "uploadFile")
    public void uploadImage(@RequestParam("filePath") String filePath,
                            @RequestParam("file") MultipartFile file) {
//        System.out.println("here "+bucket+"  +  "+filePath);
        try {
            storageService.uploadFile(filePath, file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
