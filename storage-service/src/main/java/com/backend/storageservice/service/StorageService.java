package com.backend.storageservice.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import com.amazonaws.util.IOUtils;
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

    AmazonS3 amazonS3;

    public void uploadFile( String path, MultipartFile file) throws IOException {

        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.addUserMetadata("Content-Type", file.getContentType());
        objectMetadata.addUserMetadata("Content-Length", String.valueOf(file.getSize()));

        amazonS3.putObject(
                String.valueOf("pitchs-management"),
                path,
                file.getInputStream(),
                objectMetadata
        );

    }

    public byte[] downloadFile( String path) {
        S3Object s3object = amazonS3.getObject("pitchs-management", path);
        S3ObjectInputStream inputStream = s3object.getObjectContent();
        try {
            return IOUtils.toByteArray(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
