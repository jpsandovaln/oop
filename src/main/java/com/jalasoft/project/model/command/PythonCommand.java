package com.jalasoft.project.model.command;

import com.jalasoft.project.model.exception.CommandException;
import com.jalasoft.project.model.exception.ParameterInvalidException;
import com.jalasoft.project.model.parameter.PythonParameter;

/**
 * @author HP
 * @version 1.1
 */
public class PythonCommand implements ICommandBuilder<PythonParameter> {

    public String buildCommand(PythonParameter pythonParameter) throws ParameterInvalidException, CommandException {
        return "ipconfig";
    }
}
