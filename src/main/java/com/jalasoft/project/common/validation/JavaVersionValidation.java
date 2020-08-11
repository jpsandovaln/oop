package com.jalasoft.project.common.validation;

import com.jalasoft.project.common.exception.InvalidDataException;

import java.util.Arrays;
import java.util.List;

/**
 * @author HP
 * @version 1.1
 */
public class JavaVersionValidation implements IValidationStrategy {
    private String version;
    private final static List<String> VERSION_LIST = Arrays.asList(
            "1.8",
            "1.7"
    );

    public JavaVersionValidation(String version) {
        this.version = version;
    }

    @Override
    public void validate() throws InvalidDataException {
        if (!VERSION_LIST.contains(this.version)){
            throw new InvalidDataException("Invalid version");
        }
    }
}
