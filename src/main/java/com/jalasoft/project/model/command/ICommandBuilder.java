package com.jalasoft.project.model.command;

import com.jalasoft.project.model.parameter.JavaParameter;

public interface ICommandBuilder {
    String buildCommand(JavaParameter javaParameter) throws Exception;
}
