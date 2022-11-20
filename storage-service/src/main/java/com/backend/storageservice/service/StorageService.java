package com.backend.storageservice.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Service
@AllArgsConstructor
public class StorageService {

    private AmazonS3 amazonS3;
    private ResourceLoader resourceLoader;

    public void upload( String filename, MultipartFile file) {
        TransferManager transferManager = TransferManagerBuilder.standard()
                .withS3Client(this.amazonS3)
                .build();
        transferManager.upload("pitchs-management",filename, (File) file);
    }


    public InputStream download(String file) throws IOException {
        Resource resource = this.resourceLoader.getResource("s3://pitchs-management/"+file);

        InputStream inputStream = resource.getInputStream();
        return inputStream;
        //read file
    }
}
