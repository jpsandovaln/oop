package com.jalasoft.project.model.parameter;

import com.jalasoft.project.common.exception.InvalidDataException;
import com.jalasoft.project.common.validation.FileValidation;
import com.jalasoft.project.common.validation.IValidationStrategy;
import com.jalasoft.project.common.validation.LanguageFolderValidation;
import com.jalasoft.project.common.validation.NotNullOrEmptyValidation;
import com.jalasoft.project.common.validation.ValidationContext;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HP
 * @version 1.1
 */
public class PythonParameter extends Parameter {
    private String pythonFolder;

    public PythonParameter(String pythonFolder, File file) {
        super(file);
        this.pythonFolder = pythonFolder;
    }

    public String getPythonFolder() {
        return pythonFolder;
    }

    public void setPythonFolder(String pythonFolder) {
        this.pythonFolder = pythonFolder;
    }

    @Override
    public void validate() throws InvalidDataException {
        List<IValidationStrategy> validationStrategies = new ArrayList<>();
        validationStrategies.add(new NotNullOrEmptyValidation("pythonFolder", this.pythonFolder));
        validationStrategies.add(new LanguageFolderValidation(this.pythonFolder));
        validationStrategies.add(new FileValidation(this.file));

        ValidationContext context = new ValidationContext(validationStrategies);
        context.validation();
    }
}
