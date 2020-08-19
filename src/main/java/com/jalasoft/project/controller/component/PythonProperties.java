package com.jalasoft.project.controller.component;

import com.jalasoft.project.controller.exception.PropertyException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "execute.python")

public class PythonProperties extends Properties {
    private String version2;
    private String version3;

    private final static  String PYTHON_VERSION2 = "2.7";
    private final static  String PYTHON_VERSION3 = "3.7";

    public String getVersion2() {
        return version2;
    }

    public void setVersion2(String version2) {
        this.version2 = version2;
    }

    public String getVersion3() { return version3; }

    public void setVersion3(String version3) {
        this.version3 = version3;
    }

    public String getLanguageFolder(String version) throws PropertyException {
        switch (version) {
            case PYTHON_VERSION2:
                return this.getVersion2();
            case PYTHON_VERSION3:
                return this.getVersion3();
            default:
                throw new PropertyException("invalid python version");
        }
    }
}
