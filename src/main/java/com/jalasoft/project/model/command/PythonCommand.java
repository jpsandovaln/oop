package com.jalasoft.project.model.command;

import com.jalasoft.project.model.exception.CommandException;
import com.jalasoft.project.model.exception.ParameterInvalidException;
import com.jalasoft.project.model.parameter.Parameter;

/**
 * @author HP
 * @version 1.1
 */
public class PythonCommand implements ICommandBuilder {

    public String buildCommand(Parameter javaParameter) throws ParameterInvalidException, CommandException {
        return "ipconfig";
    }
}
