package com.jalasoft.project.common.validation;

import com.jalasoft.project.common.configuration.ConfigurationProperty;
import com.jalasoft.project.common.exception.InvalidDataException;

import java.util.List;

/**
 * @author HP
 * @version 1.1
 */
public class LanguageValidation implements IValidationStrategy {
    private String lang;
    private List<String> LANGUAGE_LIST;

    public LanguageValidation(String lang) throws InvalidDataException{
        this.lang = lang;
        this.LANGUAGE_LIST = ConfigurationProperty.getLanguages();
        System.out.println(this.LANGUAGE_LIST.toString());
    }

    @Override
    public void validate() throws InvalidDataException {
        if (!LANGUAGE_LIST.contains(this.lang)) {
            throw new InvalidDataException("Invalid Language");
        }
    }
}
