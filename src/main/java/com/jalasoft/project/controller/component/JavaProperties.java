package com.jalasoft.project.controller.component;

import com.jalasoft.project.controller.exception.PropertyException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author HP
 * @version 1.1
 */
@Component
@ConfigurationProperties(prefix = "execute.java")
public class JavaProperties {
    private String projectFolder;
    private String version7;
    private String version8;

    private final static  String JAVA_VERSION7 = "1.7";
    private final static  String JAVA_VERSION8 = "1.8";

    public String getProjectFolder() {
        return projectFolder;
    }

    public void setProjectFolder(String projectFolder) {
        this.projectFolder = projectFolder;
    }

    public String getVersion7() {
        return version7;
    }

    public void setVersion7(String version7) {
        this.version7 = version7;
    }

    public String getVersion8() {
        return version8;
    }

    public void setVersion8(String version8) {
        this.version8 = version8;
    }

    public String getLanguageFolder(String version) throws PropertyException {
        switch (version) {
            case JAVA_VERSION7:
                return this.getVersion7();
            case JAVA_VERSION8:
                return this.getVersion8();
            default:
                throw new PropertyException("invalid java version");
        }
    }
}
