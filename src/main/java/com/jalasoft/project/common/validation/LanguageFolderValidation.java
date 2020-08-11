package com.jalasoft.project.common.validation;

import com.jalasoft.project.common.exception.InvalidDataException;

import java.io.File;

/**
 * @author HP
 * @version 1.1
 */
public class LanguageFolderValidation implements IValidationStrategy {
    private String langFolder;

    public  LanguageFolderValidation(String langFolder) {
        this.langFolder = langFolder;
    }

    @Override
    public void validate() throws InvalidDataException {
        File javaFolderPath = new File(this.langFolder);
        if (!javaFolderPath.isDirectory() || javaFolderPath.isHidden()) {
            throw new InvalidDataException("Invalid javaFolder");
        }
    }
}
