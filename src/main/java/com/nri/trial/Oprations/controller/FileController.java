package com.nri.trial.Oprations.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nri.trial.Oprations.DTO.FileResponse;
import com.nri.trial.Oprations.services.FileService;

@RestController
@RequestMapping("/api")
public class FileController {
    @Autowired
    private FileService fileService;
    @Value("${project.image}")
    private String path;

    @PostMapping("/upload-img")
    public ResponseEntity<FileResponse> imageUpload(@RequestBody MultipartFile image) throws IOException {
        String fileName = fileService.uploadImage(this.path, image);
        FileResponse resp = new FileResponse(fileName, "File Uploaded");
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}
