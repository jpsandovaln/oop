package com.jalasoft.project.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HP
 * @version 1.1
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @PostMapping
    public String sayHello(@RequestParam(value = "name") String name,
                           @RequestParam(value = "lastName") String lastName) {
        return "Hello " + name + " " + lastName;
    }
}
