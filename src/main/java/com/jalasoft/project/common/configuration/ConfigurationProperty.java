package com.jalasoft.project.common.configuration;

import com.jalasoft.project.common.constant.PropertyConstant;
import com.jalasoft.project.common.exception.InvalidDataException;

import java.util.List;

/**
 * @author HP
 * @version 1.1
 */
public class ConfigurationProperty {
    public static List<String> getLanguages() throws InvalidDataException {
        return PropertyHandler.getInstance().getValueAsList(PropertyConstant.EXECUTE_LANGUAGES);
    }

    public  static  String  getOS() throws InvalidDataException {
        return PropertyHandler.getInstance().getValueAsString(PropertyConstant.EXECUTE_OPERATING_SYSTEM);
    }
}
