package com.jalasoft.project.model.command;

import com.jalasoft.project.model.exception.CommandException;
import com.jalasoft.project.model.exception.ParameterInvalidException;
import com.jalasoft.project.model.parameter.Parameter;

public interface ICommandBuilder {
    String buildCommand(Parameter parameter) throws ParameterInvalidException, CommandException;
}
