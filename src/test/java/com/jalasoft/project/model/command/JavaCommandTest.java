package com.jalasoft.project.model.command;

import com.jalasoft.project.common.exception.InvalidDataException;
import com.jalasoft.project.model.exception.CommandException;
import com.jalasoft.project.model.parameter.JavaParameter;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class JavaCommandTest {

    private final static String javaFolder8 = "C:/Courses/oopProjectCourses/thirdParty/java/win/jdk1.8.0_251/bin/";
    private final static String javaFolder8Invalid = "D:/POO/oop/thirdParty123/java/win/jdk1.8.0_251/bin/";
    private final static String javaFile = "src/test/resources/javaFolder/HelloWorld.java";

    @Test
    public void buildCommandJava8() throws InvalidDataException, CommandException {
        JavaParameter javaParameter = new JavaParameter(javaFolder8, new File(javaFile));
        JavaCommand command = new JavaCommand();
        String result = command.buildCommand(javaParameter);
        String expected = "C:/Courses/oopProjectCourses/thirdParty/java/win/jdk1.8.0_251/bin/javac C:\\Courses\\" +
                "oopProjectCourses\\src\\test\\resources\\javaFolder\\HelloWorld.java && java -cp src\\test\\resources" +
                "\\javaFolder HelloWorld";
        assertEquals("valid command", expected, result);
    }


    @Test(expected = InvalidDataException.class)
    public void buildCommandJava8NullParameter() throws InvalidDataException, CommandException {
        JavaCommand command = new JavaCommand();
        command.buildCommand(null);
    }

    @Test(expected = InvalidDataException.class)
    public void buildCommandInvalidFolder() throws InvalidDataException, CommandException {
        JavaParameter javaParameter = new JavaParameter(javaFolder8Invalid, new File(javaFile));
        JavaCommand command = new JavaCommand();
        command.buildCommand(javaParameter);
    }

    @Test(expected = InvalidDataException.class)
    public void buildCommandJavaParameter() throws InvalidDataException, CommandException {
        JavaCommand command = new JavaCommand();
        command.buildCommand(new JavaParameter(null, null));
    }
}