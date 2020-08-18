package com.jalasoft.project.model.parameter;

import com.jalasoft.project.common.exception.InvalidDataException;
import org.junit.Test;

import java.io.File;


public class JavaParameterTest {

    private final static String javaFolder = "C:/Courses/oopProjectCourses/thirdParty/java/win/jdk1.8.0_251/bin/";
    private final static String javaFile = "src/test/resources/javaFolder/HelloWord.java";

    // Validar que los datos folder, file cuando son erroneos lanzan error valido
    @Test(expected = InvalidDataException.class)
    public void validateJavaParameter() throws InvalidDataException {
        Parameter javaParameter = new JavaParameter(javaFolder, new File(javaFile));
        javaParameter.validate();

    }
    // Validar que los datos folder nulos
    @Test(expected = InvalidDataException.class)
    public void validateNullJavaParameter() throws InvalidDataException {
        Parameter javaParameter = new JavaParameter(null, new File(javaFile));
        javaParameter.validate();

    }

    // Validar que los datos folder, file cuando son nulos
    @Test(expected = InvalidDataException.class)
    public void validate() throws InvalidDataException {
        Parameter javaParameter = new JavaParameter(null, null);
        javaParameter.validate();

    }
}