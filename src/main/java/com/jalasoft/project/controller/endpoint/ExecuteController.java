package com.jalasoft.project.controller.endpoint;

import com.jalasoft.project.model.ExecuteJava;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HP
 * @version 1.1
 */
@RestController
@RequestMapping("/api/v1")
public class ExecuteController {

    @PostMapping("/execute")
    public String execute(@RequestParam(value = "lang") String lang,
                          @RequestParam(value = "version") String version) {
        ExecuteJava executeJava = new ExecuteJava();
        return executeJava.execute();
    }
}
