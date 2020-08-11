package com.jalasoft.project.common.validation;

import com.jalasoft.project.common.exception.InvalidDataException;

import java.util.Arrays;
import java.util.List;

/**
 * @author HP
 * @version 1.1
 */
public class LanguageValidation implements IValidationStrategy {
    private String lang;
    private final static List<String> LANGUAGE_LIST = Arrays.asList(
        "java",
        "python"
    );

    public LanguageValidation(String lang) {
        this.lang = lang;
    }

    @Override
    public void validate() throws InvalidDataException {
        if (!LANGUAGE_LIST.contains(this.lang)) {
            throw new InvalidDataException("Invalid Language");
        }
    }
}
