package com.jalasoft.project.controller.component;

import com.jalasoft.project.controller.exception.PropertyException;

/**
 * @author HP
 * @version 1.1
 */
public abstract class Properties {
    private String projectFolder;

    public String getProjectFolder() {
        return projectFolder;
    }

    public void setProjectFolder(String projectFolder) {
        this.projectFolder = projectFolder;
    }

    public abstract String getLanguageFolder(String version) throws PropertyException;
}
