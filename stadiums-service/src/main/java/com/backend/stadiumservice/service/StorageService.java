package com.backend.stadiumservice.service;

import com.example.openfeign.storageService.OFStorageController;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
public class StorageService {
    private final OFStorageController storageController;

    public synchronized void Store(String imageName, MultipartFile image){
        storageController.uploadImage(imageName, image);
    }
}
