package com.jalasoft.project.model.parameter;

import com.jalasoft.project.common.exception.InvalidDataException;
import com.jalasoft.project.common.validation.FileValidation;
import com.jalasoft.project.common.validation.IValidationStrategy;
import com.jalasoft.project.common.validation.LanguageFolderValidation;
import com.jalasoft.project.common.validation.NotNullOrEmptyValidation;
import com.jalasoft.project.common.validation.ValidationContext;
import com.jalasoft.project.model.exception.ParameterInvalidException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HP
 * @version 1.1
 */
public class JavaParameter extends Parameter {
    private String javaFolder;

    public JavaParameter(String javaFolder, File javaFile) {
        super(javaFile);
        this.javaFolder = javaFolder;
    }

    public String getJavaFolder() {
        return javaFolder;
    }

    public void setJavaFolder(String javaFolder) {
        this.javaFolder = javaFolder;
    }

    public void validate() throws InvalidDataException {
        List<IValidationStrategy> validationStrategies = new ArrayList<>();
        validationStrategies.add(new NotNullOrEmptyValidation("javaFolder", this.javaFolder));
        validationStrategies.add(new LanguageFolderValidation(this.javaFolder));
        validationStrategies.add(new FileValidation(this.file));

        ValidationContext context = new ValidationContext(validationStrategies);
        context.validation();
    }
}
