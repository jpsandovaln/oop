package com.jalasoft.project.model.command;

import com.jalasoft.project.common.exception.InvalidDataException;
import com.jalasoft.project.model.ExecuteCommand;
import com.jalasoft.project.model.exception.CommandException;
import com.jalasoft.project.model.exception.ExecuteException;
import com.jalasoft.project.model.parameter.JavaParameter;
import com.jalasoft.project.model.result.Result;

import java.io.File;

/**
 * @author HP
 * @version 1.1
 */
public class CommandFacade {
    public static Result executeJavaCode(String lang, String javaPath, File javaFile)
            throws InvalidDataException, CommandException, ExecuteException {
        ICommandBuilder<JavaParameter> commandBuilder = CommandFactory.getCommand(lang);
        String command = commandBuilder.buildCommand(new JavaParameter(javaPath, javaFile));
        ExecuteCommand executeCommand = new ExecuteCommand();
        return executeCommand.execute(command);
    }
}
