package com.jalasoft.project.common.validation;

import com.jalasoft.project.common.exception.InvalidDataException;

public interface IValidationStrategy {
    void validate() throws InvalidDataException;
}
