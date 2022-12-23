package com.example.openfeign.storageService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@FeignClient("storage-service")
public interface OFStorageController {

    @GetMapping("/api/storage/imageUrl")
    byte[] getImage(@RequestParam("filePath") String filePath);

    @PostMapping( value = "/api/storage/uploadFile",consumes = "multipart/form-data")
    void uploadImage(@RequestParam("filePath") String filePath,
                     @RequestParam("file") MultipartFile file);

}
