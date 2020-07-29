package com.jalasoft.project.controller.service;

import com.jalasoft.project.controller.component.JavaProperties;
import com.jalasoft.project.controller.exception.FileException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @author HP
 * @version 1.1
 */
@Service
public class FileService {
    @Autowired
    private JavaProperties javaProperties;

    public File store(MultipartFile file) throws FileException {
        try {
            Path path = this.getFilePath(file.getOriginalFilename());
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            return new File(path.toString());
        } catch (IOException ex) {
            throw new FileException("File error.", ex);
        }
    }

    private Path getFilePath(String fileName)throws FileException {
        try {
            Files.createDirectories(Paths.get(this.javaProperties.getProjectFolder()));
            return Paths.get(this.javaProperties.getProjectFolder() + fileName);
        } catch (IOException ex) {
            throw new FileException("Path error", ex);
        }
    }
}
