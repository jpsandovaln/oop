package com.jalasoft.project.model.command;

import com.jalasoft.project.common.exception.InvalidDataException;
import com.jalasoft.project.model.exception.CommandException;
import com.jalasoft.project.model.parameter.JavaParameter;
import org.apache.commons.io.FilenameUtils;

/**
 * @author HP
 * @version 1.1
 */
public class JavaCommand implements ICommandBuilder<JavaParameter> {
    private static  final String JAVA_COMPILE = "javac ";
    private static final String JAVA_EXECUTE = "java ";
    private static final String JAVA_CP_PARAM = "-cp ";
    private static final String JAVA_AND = " && ";
    private static final String SPACE = " ";
    private static final String CMD = "cmd";
    /**
     * Builds java command for all versions.
     * <h1>hi </h1>
     *
     * @param javaParameter
     * @return
     * @throws InvalidDataException
     * @throws CommandException
     */
    public String buildCommand(JavaParameter javaParameter) throws InvalidDataException, CommandException {
        if (javaParameter == null) {
            throw new InvalidDataException();
        }
        javaParameter.validate();
        StringBuilder command = new StringBuilder();
        command.append(javaParameter.getJavaFolder())
                .append(JAVA_COMPILE)
                .append(javaParameter.getFile().getAbsolutePath())
                .append(JAVA_AND)
                .append(JAVA_EXECUTE)
                .append(JAVA_CP_PARAM)
                .append(javaParameter.getFile().getParent())
                .append(SPACE)
                .append(FilenameUtils.getBaseName(javaParameter.getFile().getName()));
        if (command.toString().isEmpty()) {
            throw new CommandException();
        }
        return command.toString();
    }
}
