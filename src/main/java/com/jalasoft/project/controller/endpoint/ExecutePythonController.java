package com.jalasoft.project.controller.endpoint;

import com.jalasoft.project.common.exception.InvalidDataException;
import com.jalasoft.project.controller.component.PythonProperties;
import com.jalasoft.project.controller.exception.FileException;
import com.jalasoft.project.controller.exception.PropertyException;
import com.jalasoft.project.controller.request.RequestPythonParam;
import com.jalasoft.project.controller.response.ErrorResponse;
import com.jalasoft.project.controller.response.OKResponse;
import com.jalasoft.project.controller.response.Response;
import com.jalasoft.project.controller.service.FileService;
import com.jalasoft.project.model.command.CommandFacade;
import com.jalasoft.project.model.exception.CommandException;
import com.jalasoft.project.model.exception.ExecuteException;
import com.jalasoft.project.model.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;


@RestController
@RequestMapping("/api/v1")
public class ExecutePythonController {

    @Autowired
    private PythonProperties pythonProperties;

    @Autowired
    private FileService fileService;

    @PostMapping("/execute-python")
    public ResponseEntity<Response> execute(RequestPythonParam param) {

            try {
                param.validate();

                File pythonFile = this.fileService.store(param.getFile(), this.pythonProperties.getProjectFolder());
                String pythonPath = this.pythonProperties.getLanguageFolder(param.getVersion());

                Result result = CommandFacade.executePythonCode(param.getLang(), pythonPath, pythonFile);

                return ResponseEntity.ok().body(
                        new OKResponse<Integer>(HttpServletResponse.SC_OK, result.getResultConsole(), result.getPid())
                );
            } catch (InvalidDataException | FileException | PropertyException ex) {
                return ResponseEntity.badRequest().body(
                        new ErrorResponse<Integer>(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage())
                );
            } catch (CommandException | ExecuteException ex) {
                return ResponseEntity.badRequest().body(
                        new ErrorResponse<Integer>(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage())
                );
            }
    }
}

