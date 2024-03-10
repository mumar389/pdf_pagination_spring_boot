package com.nri.trial.Oprations.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

    public String uploadImage(String path, MultipartFile file) throws IOException {

        // get file name
        String name = file.getOriginalFilename();

        // random File Name
        String randomId = UUID.randomUUID().toString();
        String fileName = randomId.concat(name.substring(name.lastIndexOf(".")));

        // make the path file--full path
        String filePath = path + File.separator + fileName;

        // create images folder if not created
        File cfile = new File(path);
        if (!cfile.exists()) {
            cfile.mkdir();
        }

        // file copy
        Files.copy(file.getInputStream(), Paths.get(filePath));

        return fileName;
    }
}
