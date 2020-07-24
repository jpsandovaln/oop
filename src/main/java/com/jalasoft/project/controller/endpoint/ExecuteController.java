package com.jalasoft.project.controller.endpoint;

import com.jalasoft.project.controller.component.Properties;
import com.jalasoft.project.controller.exception.FileException;
import com.jalasoft.project.controller.exception.RequestParamException;
import com.jalasoft.project.controller.request.RequestParam;
import com.jalasoft.project.controller.response.ErrorResponse;
import com.jalasoft.project.controller.response.OKResponse;
import com.jalasoft.project.controller.response.Response;
import com.jalasoft.project.controller.service.FileService;
import com.jalasoft.project.model.ExecuteCommand;
import com.jalasoft.project.model.command.ICommandBuilder;
import com.jalasoft.project.model.command.JavaCommand;
import com.jalasoft.project.model.exception.CommandException;
import com.jalasoft.project.model.exception.ExecuteException;
import com.jalasoft.project.model.exception.ParameterInvalidException;
import com.jalasoft.project.model.parameter.JavaParameter;
import com.jalasoft.project.model.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

/**
 * @author HP
 * @version 1.1
 */
@RestController
@RequestMapping("/api/v1")
public class ExecuteController {

    @Autowired
    private Properties properties;

    @Autowired
    private FileService fileService;

    @PostMapping("/execute")
    public ResponseEntity<Response> execute(RequestParam param) {
        try {
            param.validate();

            File javaFile = this.fileService.store(param.getFile());
            String javaPath = this.properties.getJava8Path();

            ICommandBuilder commandBuilder = new JavaCommand();

            String command = commandBuilder.buildCommand(new JavaParameter(javaPath, javaFile));
            ExecuteCommand executeCommand = new ExecuteCommand();
            Result result = executeCommand.execute(command);

            return ResponseEntity.ok().body(
                    new OKResponse("200", result.getResultConsole(), result.getPid())
            );
        } catch (RequestParamException ex) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse("400", ex.getMessage())
            );
        } catch (FileException ex) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse("400", ex.getMessage())
            );
        } catch (ParameterInvalidException ex) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse("400", ex.getMessage())
            );
        } catch (CommandException ex) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse("400", ex.getMessage())
            );
        } catch (ExecuteException ex) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse("400", ex.getMessage())
            );
        }
    }
}
