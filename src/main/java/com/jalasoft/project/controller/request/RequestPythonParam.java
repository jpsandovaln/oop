package com.jalasoft.project.controller.request;

import com.jalasoft.project.common.exception.InvalidDataException;
import com.jalasoft.project.common.validation.*;
import com.jalasoft.project.controller.exception.RequestParamException;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author HP
 * @version 1.1
 */
public class RequestPythonParam {
    private String lang;
    private String version;
    private MultipartFile file;

    private final static List<String> PYTHON_VERSION_LIST = Arrays.asList(
            "2.7",
            "3.7"
    );

    public RequestPythonParam(String lang, String version, MultipartFile file) {
        this.lang = lang;
        this.version = version;
        this.file = file;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getVersion() { return version; }

    public void setVersion(String version) {
        this.version = version;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public void validate() throws InvalidDataException {
        List<IValidationStrategy> validationStrategies = new ArrayList<>();
        validationStrategies.add(new NotNullOrEmptyValidation("lang", this.lang));
        validationStrategies.add(new NotNullOrEmptyValidation("version", this.version));
        validationStrategies.add(new MultipartFileValidation(this.file));
        validationStrategies.add(new LanguageValidation(this.lang));

        validationStrategies.add(new PythonVersionValidation(this.version));

        ValidationContext context = new ValidationContext(validationStrategies);
        context.validation();
    }
}
