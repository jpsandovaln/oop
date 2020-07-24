package com.jalasoft.project.model.parameter;

import com.jalasoft.project.model.exception.ParameterInvalidException;

import java.io.File;

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
    public void validate() throws ParameterInvalidException {
        if (this.pythonFolder == null || this.pythonFolder.isEmpty()) {
            throw new ParameterInvalidException("pythonFolder", this.pythonFolder);
        }
        File javaFolderPath = new File(this.pythonFolder);
        if (!javaFolderPath.isDirectory() || javaFolderPath.isHidden()) {
            throw new ParameterInvalidException("Invalid pythonFolder");
        }
        if (this.file == null || !this.file.isFile() || this.file.isHidden()) {
            throw new ParameterInvalidException("Invalid pythonFile");
        }
    }
}
