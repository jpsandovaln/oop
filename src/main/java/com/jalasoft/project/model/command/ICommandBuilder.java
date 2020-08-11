package com.jalasoft.project.model.command;

import com.jalasoft.project.common.exception.InvalidDataException;
import com.jalasoft.project.model.exception.CommandException;
import com.jalasoft.project.model.parameter.Parameter;

public interface ICommandBuilder<T extends Parameter> {
    String buildCommand(T parameter) throws InvalidDataException, CommandException;
}
