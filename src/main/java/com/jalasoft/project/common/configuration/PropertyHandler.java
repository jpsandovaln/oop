package com.jalasoft.project.common.configuration;

import com.jalasoft.project.common.constant.PropertyConstant;
import com.jalasoft.project.common.exception.InvalidDataException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @author HP
 * @version 1.1
 */
public class PropertyHandler {
    private static PropertyHandler propertyHandler;
    private static Properties properties;
    private final static String CONFIG_FILE= "configuration.properties";
    private final static String SEPARATOR= ",";

    private PropertyHandler() throws InvalidDataException {
        try {
            this.properties = new Properties();
            this.properties.load(getClass().getClassLoader().getResourceAsStream(PropertyConstant.CONFIGURATION_FILE));
            // System.out.println(this.properties.toString());
        } catch (IOException ex) {
            throw new InvalidDataException(ex);
        }
    }

    public static PropertyHandler getInstance() throws InvalidDataException {
        if (propertyHandler == null) {
            propertyHandler = new PropertyHandler();
        }
        return propertyHandler;
    }

    public String getValueAsString(String key) {
        return this.properties.getProperty(key);
    }

    public List<String> getValueAsList(String key) {
        String value = this.getValueAsString(key);
        return new ArrayList<>(Arrays.asList(
                value.split(SEPARATOR)
        ));
    }
}
