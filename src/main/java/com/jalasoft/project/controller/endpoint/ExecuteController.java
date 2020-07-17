package com.jalasoft.project.controller.endpoint;

import com.jalasoft.project.controller.component.Properties;
import com.jalasoft.project.controller.request.RequestParam;
import com.jalasoft.project.controller.response.ErrorResponse;
import com.jalasoft.project.controller.response.OKResponse;
import com.jalasoft.project.controller.response.Response;
import com.jalasoft.project.model.ExecuteCommand;
import com.jalasoft.project.model.command.ICommandBuilder;
import com.jalasoft.project.model.command.JavaCommand;
import com.jalasoft.project.model.parameter.JavaParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    private Properties properties;

    @PostMapping("/execute")
    public ResponseEntity<Response> execute(RequestParam param) {
        try {
            param.validate();
            Files.createDirectories(Paths.get(this.properties.getProjectFolder()));
            Path path = Paths.get(this.properties.getProjectFolder() + param.getFile().getOriginalFilename());
            Files.copy(param.getFile().getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            File javaFile = new File(path.toString());
            String javaPath = this.properties.getJava8Path();

            ICommandBuilder commandBuilder = new JavaCommand();

            String command = commandBuilder.buildCommand(new JavaParameter(javaPath, javaFile));
            ExecuteCommand executeCommand = new ExecuteCommand();
            String result = executeCommand.execute(command);

            return ResponseEntity.ok().body(
                    new OKResponse("200", result, "0")
            );
        } catch (IOException ex) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse("400", ex.getMessage())
            );
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse("440", ex.getMessage())
            );
        }
    }
}
