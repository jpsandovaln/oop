package com.jalasoft.project.controller.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author HP
 * @version 1.1
 */
@Component
@ConfigurationProperties(prefix = "execute")
public class Properties {
    private String projectFolder;
    private String java8Path;

    public String getProjectFolder() {
        return projectFolder;
    }

    public void setProjectFolder(String projectFolder) {
        this.projectFolder = projectFolder;
    }

    public String getJava8Path() {
        return java8Path;
    }

    public void setJava8Path(String java8Path) {
        this.java8Path = java8Path;
    }
}
