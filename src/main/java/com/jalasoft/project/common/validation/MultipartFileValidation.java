package com.jalasoft.project.common.validation;

import com.jalasoft.project.common.exception.InvalidDataException;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author HP
 * @version 1.1
 */
public class MultipartFileValidation implements IValidationStrategy {
    private MultipartFile file;

    public MultipartFileValidation(MultipartFile file) {
        this.file = file;
    }

    @Override
    public void validate() throws InvalidDataException {
        if (this.file == null || this.file.isEmpty() || this.file.getOriginalFilename().contains("..")) {
            throw new InvalidDataException("Invalid File");
        }
    }
}
