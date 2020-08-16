package com.jalasoft.project.model.command;

import com.jalasoft.project.common.exception.InvalidDataException;
import com.jalasoft.project.model.exception.CommandException;
import com.jalasoft.project.model.parameter.JavaParameter;
import com.jalasoft.project.model.parameter.Parameter;

import java.util.Calendar;

/**
 * @author HP
 * @version 1.1
 */
public class JavaCommandProxy implements ICommandBuilder<JavaParameter> {
    private JavaCommand javaCommand;
    private final static int HOUR = 16;

    public JavaCommandProxy() {
        this.javaCommand = new JavaCommand();
    }

    @Override
    public String buildCommand(JavaParameter parameter) throws InvalidDataException, CommandException {
        Calendar now = Calendar.getInstance();
        int currentHours = now.get(Calendar.HOUR_OF_DAY);
        System.out.println(currentHours);
        if (HOUR <= currentHours) {
            throw new InvalidDataException("Invalid hour");
        }
        return this.javaCommand.buildCommand(parameter);
    }
}
