package com.jalasoft.project.model.command;

import com.jalasoft.project.model.exception.CommandException;
import com.jalasoft.project.model.exception.ParameterInvalidException;
import com.jalasoft.project.model.parameter.JavaParameter;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class JavaCommandTest {

    private final static String javaFolder8 = "D:/POO/oop/thirdParty/java/win/jdk1.8.0_251/bin/";
    private final static String javaFolder8Invalid = "D:/POO/oop/thirdParty123/java/win/jdk1.8.0_251/bin/";

    private final static String javaFolder7 = "D:/POO/oop/thirdParty/java/win/jdk1.7.0_80/bin/";
    private final static String javaFile = "src/test/resources/javaFolder/HelloWorld.java";

    @Test
    public void buildCommandJava8() throws ParameterInvalidException, CommandException {
        JavaParameter javaParameter = new JavaParameter(javaFolder8, new File(javaFile));

        JavaCommand command = new JavaCommand();
        String result = command.buildCommand(javaParameter);
        String expected = "D:/POO/oop/thirdParty/java/win/jdk1.8.0_251/bin/javac D:\\POO\\oop\\src\\test\\resources\\" +
                "javaFolder\\HelloWorld.java && java -cp src\\test\\resources\\javaFolder HelloWorld";
        assertEquals("valid command", expected, result);
    }

    @Test
    public void buildCommandJava7() throws ParameterInvalidException, CommandException {
        JavaParameter javaParameter = new JavaParameter(javaFolder7, new File(javaFile));
        JavaCommand command = new JavaCommand();
        String result = command.buildCommand(javaParameter);
        String expected = "D:/POO/oop/thirdParty/java/win/jdk1.7.0_80/bin/javac D:\\POO\\oop\\src\\test\\resources\\" +
                "javaFolder\\HelloWorld.java && java -cp src\\test\\resources\\javaFolder HelloWorld";
        assertEquals("valid command", expected, result);
    }

    @Test(expected = ParameterInvalidException.class)
    public void buildCommandJava8NullParameter() throws ParameterInvalidException, CommandException {
        JavaCommand command = new JavaCommand();
        command.buildCommand(null);
    }

    @Test(expected = ParameterInvalidException.class)
    public void buildCommandInvalidFolder() throws ParameterInvalidException, CommandException {
        JavaParameter javaParameter = new JavaParameter(javaFolder8Invalid, new File(javaFile));
        JavaCommand command = new JavaCommand();
        command.buildCommand(javaParameter);
    }

    @Test(expected = ParameterInvalidException.class)
    public void buildCommandJavaParameter() throws ParameterInvalidException, CommandException {
        JavaCommand command = new JavaCommand();
        command.buildCommand(new JavaParameter(null, null));
    }
}