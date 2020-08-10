package com.jalasoft.project.controller.service;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class FileServiceTest {

    public void testPrivate() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?>[] classArray = new Class<?>[2];
        classArray[0] = String.class;
        classArray[1] = String.class;

        FileService service = new FileService();
        Method fileServicePrivate = FileService.class.getDeclaredMethod("getFilePath", classArray);
        fileServicePrivate.setAccessible(true);

        Path expectedValue = Paths.get("D:\\testprivate\\test.java");
        Path returnValue = (Path) fileServicePrivate.invoke(service, "test.java", "D:/testprivate/");

        assertEquals(expectedValue, returnValue);
    }
}