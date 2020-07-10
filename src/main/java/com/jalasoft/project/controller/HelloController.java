package com.jalasoft.project.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author HP
 * @version 1.1
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @PostMapping
    public String sayHello(@RequestParam(value = "name") String name,
                           @RequestParam(value = "lastName") String lastName,
                           @RequestParam(value = "file")MultipartFile file) throws IOException {

                File dest = new File("c://uploads//testFile1.txt");
                file.transferTo(dest);

        return "Hello " + name + " " + lastName + " your file " + file.getOriginalFilename() + " was saved at C:/uploads folder" ;
    }
}
