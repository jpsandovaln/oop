package com.jalasoft.project.controller.endpoint;

import com.jalasoft.project.common.exception.InvalidDataException;
import com.jalasoft.project.controller.component.JavaProperties;
import com.jalasoft.project.controller.exception.FileException;
import com.jalasoft.project.controller.exception.PropertyException;
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
import com.jalasoft.project.model.parameter.Parameter;
import com.jalasoft.project.model.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * @author HP
 * @version 1.1
 */
@RestController
@RequestMapping("/api/v1")
public class ExecuteController {

    @Autowired
    private JavaProperties javaProperties;

    @Autowired
    private FileService fileService;

    @PostMapping("/execute-java")
    public ResponseEntity<Response> execute(RequestParam param) {
        try {
            param.validate();

            File javaFile = this.fileService.store(param.getFile(), this.javaProperties.getProjectFolder());
            String javaPath = this.javaProperties.getLanguageFolder(param.getVersion());

            ICommandBuilder<JavaParameter> commandBuilder = new JavaCommand();

            String command = commandBuilder.buildCommand(new JavaParameter(javaPath, javaFile));
            ExecuteCommand executeCommand = new ExecuteCommand();
            Result result = executeCommand.execute(command);

            return ResponseEntity.ok().body(
                    new OKResponse<Integer>(HttpServletResponse.SC_OK, result.getResultConsole(), result.getPid())
            );
        } catch (InvalidDataException | FileException | PropertyException ex) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse<Integer>(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage())
            );
        } catch (ParameterInvalidException | CommandException | ExecuteException ex) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse<Integer>(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage())
            );
        }
    }
}
