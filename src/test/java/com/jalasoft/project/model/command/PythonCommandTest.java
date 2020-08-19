package com.jalasoft.project.model.command;

import com.jalasoft.project.common.exception.InvalidDataException;
import com.jalasoft.project.model.exception.CommandException;
import com.jalasoft.project.model.parameter.PythonParameter;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class PythonCommandTest {

    private final static String pythonFolder3 = "C:/Courses/oopProjectCourses/thirdParty/python/Python";
    private final static String pythonFolder3Invalid = "D:/POO/oop/thirdParty123/java/win/python/";
    private final static String pythonFile = "src/test/resources/pythonFolder/test.py";

    @Test
    public void testBuildCommand() throws InvalidDataException, CommandException {
        PythonParameter pythonParameter = new PythonParameter(pythonFolder3, new File(pythonFile));
        PythonCommand command = new PythonCommand();
        String result = command.buildCommand(pythonParameter);
        String expected = "C:/Courses/oopProjectCourses/thirdParty/python/Python/python.exe " +
                "C:\\Courses\\oopProjectCourses\\src\\test\\resources\\pythonFolder\\test.py";
        assertEquals("valid command", expected, result);

    }

    @Test (expected = InvalidDataException.class)
    public void buildCommandInvalidPythonFolder() throws InvalidDataException, CommandException {
        PythonParameter pythonParameter = new PythonParameter(pythonFolder3Invalid, new File(pythonFile));
        PythonCommand command = new PythonCommand();
        command.buildCommand(pythonParameter);
    }

   @Test(expected = InvalidDataException.class)
    public void buildCommandPython3NullParameter() throws InvalidDataException, CommandException {
        PythonCommand command = new PythonCommand();
        command.buildCommand(null);
    }

    @Test(expected = InvalidDataException.class)
    public void buildCommandPythonParameter() throws InvalidDataException, CommandException {
        PythonCommand command = new PythonCommand();
        command.buildCommand(new PythonParameter(null, null));
    }

}