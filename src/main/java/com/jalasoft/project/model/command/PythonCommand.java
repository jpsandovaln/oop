package com.jalasoft.project.model.command;

import com.jalasoft.project.common.exception.InvalidDataException;
import com.jalasoft.project.model.exception.CommandException;
import com.jalasoft.project.model.parameter.PythonParameter;
import org.apache.commons.io.FilenameUtils;

//python.exe test.py
public class PythonCommand implements ICommandBuilder<PythonParameter> {
    private static  final String PYTHON_EXECUTE = "/python.exe ";

    public String buildCommand(PythonParameter pythonParameter) throws InvalidDataException, CommandException {
        if (pythonParameter == null) {
            throw new InvalidDataException();
        }
        pythonParameter.validate();
        StringBuilder command = new StringBuilder();
        command.append(pythonParameter.getPythonFolder())
                .append(PYTHON_EXECUTE)
                .append(pythonParameter.getFile().getAbsolutePath());

        if (command.toString().isEmpty()) {
            throw new CommandException();
        }
        return command.toString();
    }
}
