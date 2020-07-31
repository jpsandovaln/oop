package com.jalasoft.project.controller.request;

import com.jalasoft.project.controller.exception.RequestParamException;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

/**
 * @author HP
 * @version 1.1
 */
public class RequestParam {
    private String lang;
    private String version;
    private MultipartFile file;

    private final static List<String> JAVA_VERSION_LIST = Arrays.asList(
            "1.7",
            "1.8"
    );

    public RequestParam(String lang, String version, MultipartFile file) {
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public void validate() throws RequestParamException {
        if (lang == null || lang.isEmpty()) {
            throw new RequestParamException("Invalid lang.");
        }
        if (!"java".equals(lang)) {
            throw new RequestParamException("Invalid lang.");
        }
        if (version.isEmpty()) {
            throw new RequestParamException("Invalid version");
        }
        if (!JAVA_VERSION_LIST.contains(version)) {
            throw new RequestParamException("Invalid version");
        }
        if (file == null || file.isEmpty()) {
            throw new RequestParamException("Invalid File");
        }
    }
}
