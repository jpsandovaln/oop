package com.jalasoft.project.model.command;

import com.jalasoft.project.model.exception.CommandException;
import com.jalasoft.project.model.exception.ParameterInvalidException;

/**
 * @author HP
 * @version 1.1
 */
public class PythonCommand implements ICommandBuilder<PythonCommand> {

    public String buildCommand(PythonCommand pythonParameter) throws ParameterInvalidException, CommandException {
        return "ipconfig";
    }
}
