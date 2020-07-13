package com.jalasoft.project.model.parameter;

import java.io.File;

/**
 * @author HP
 * @version 1.1
 */
public class JavaParameter {
    private String javaFolder;
    private File javaFile;

    public JavaParameter(String javaFolder, File javaFile) {
        this.javaFolder = javaFolder;
        this.javaFile = javaFile;
    }

    public String getJavaFolder() {
        return javaFolder;
    }

    public void setJavaFolder(String javaFolder) {
        this.javaFolder = javaFolder;
    }

    public File getJavaFile() {
        return javaFile;
    }

    public void setJavaFile(File javaFile) {
        this.javaFile = javaFile;
    }

    public void validate() throws Exception {
        throw new Exception("Invalid Params");
    }
}
