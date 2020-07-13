package com.jalasoft.project.controller.endpoint;

import com.jalasoft.project.model.ExecuteJava;
import com.jalasoft.project.model.parameter.JavaParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
@RestController
@RequestMapping("/api/v1")
public class ExecuteController {

    @PostMapping("/execute")
    public String execute(@RequestParam(value = "lang") String lang,
                          @RequestParam(value = "version") String version,
                          @RequestParam(value = "file") MultipartFile file) {

        if (lang == null || lang.isEmpty()) {
            return "Invalid lang.";
        }
        if (!"java".equals(lang)) {
            return "Invalid lang.";
        }
        if (version.isEmpty()) {
            return "Invalid version";
        }
        if (!"1.8".equals(version)) {
            return "Invalid version";
        }
        if (file == null || file.isEmpty()) {
            return "Invalid File";
        }
        try {
            Files.createDirectories(Paths.get("javaProject/"));
            Path path = Paths.get("javaProject/" + file.getOriginalFilename());
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            File javaFile = new File(path.toString());
            String javaPath = "D:\\POO\\oop\\thirdParty\\java\\win\\jdk1.8.0_251\\bin\\";
            ExecuteJava executeJava = new ExecuteJava();
            return executeJava.execute(new JavaParameter(javaPath, javaFile));
        } catch (IOException ex) {
            return ex.getMessage();
        }
    }
}
