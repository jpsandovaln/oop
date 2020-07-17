package com.jalasoft.project.model.command;

import com.jalasoft.project.model.parameter.JavaParameter;

/**
 * @author HP
 * @version 1.1
 */
public class PythonCommand implements ICommandBuilder {

    public String buildCommand(JavaParameter javaParameter) throws Exception {
        return "ipconfig";
    }
}
