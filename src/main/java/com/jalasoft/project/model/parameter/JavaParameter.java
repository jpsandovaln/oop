package com.jalasoft.project.model.parameter;

import java.io.File;

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

    public void validate() throws Exception {
        if (this.javaFolder == null || this.javaFolder.isEmpty()) {
            throw new Exception("Invalid javaFolder");
        }
        File javaFolderPath = new File(this.javaFolder);
        if (!javaFolderPath.isDirectory() || javaFolderPath.isHidden()) {
            throw new Exception("Invalid javaFolder");
        }
        if (this.file == null || !this.file.isFile() || this.file.isHidden()) {
            throw new Exception("Invalid javaFile");
        }
    }
}
