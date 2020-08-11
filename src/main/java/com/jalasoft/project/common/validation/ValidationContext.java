package com.jalasoft.project.common.validation;

import com.jalasoft.project.common.exception.InvalidDataException;

import java.util.List;

/**
 * @author HP
 * @version 1.1
 */
public class ValidationContext {
    private List<IValidationStrategy> validationStrategies;

    public ValidationContext(List<IValidationStrategy> validationStrategies) {
        this.validationStrategies = validationStrategies;
    }

    public void validation() throws InvalidDataException {
        for (IValidationStrategy strategy : this.validationStrategies) {
            strategy.validate();
        }
    }
}
