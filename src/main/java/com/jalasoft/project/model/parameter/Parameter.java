package com.jalasoft.project.model.parameter;

import com.jalasoft.project.common.exception.InvalidDataException;
import com.jalasoft.project.model.exception.ParameterInvalidException;

import java.io.File;

/**
 * @author HP
 * @version 1.1
 */
public abstract class Parameter {
    protected File file;

    public Parameter(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public abstract void validate() throws InvalidDataException;
}
