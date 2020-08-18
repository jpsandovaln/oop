package com.jalasoft.project.common.validation;

import com.jalasoft.project.common.exception.InvalidDataException;

import java.util.Arrays;
import java.util.List;

public class PythonVersionValidation implements IValidationStrategy {
    private String version;
    private final static List<String> VERSION_LIST = Arrays.asList(
            "3.7",
            "2.7"
    );

    public PythonVersionValidation(String version) {
        this.version = version;
    }

    @Override
    public void validate() throws InvalidDataException {
        if (!VERSION_LIST.contains(this.version)){
            throw new InvalidDataException("Invalid version");
        }
    }
}

