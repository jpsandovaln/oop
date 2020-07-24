package com.jalasoft.project.model.exception;

/**
 * @author HP
 * @version 1.1
 */
public class ParameterInvalidException extends Exception {
    private static final String GENERAL_MESSAGE = "Invalid Parameter.";
    private static final String  FIELD_MESSAGE = "Invalid value = %s, in field = %s";

    public ParameterInvalidException() {
        super(GENERAL_MESSAGE);
    }

    public ParameterInvalidException(String currentMessage) {
        super(currentMessage);
    }

    public ParameterInvalidException(Throwable ex) {
        super(GENERAL_MESSAGE, ex);
    }

    public ParameterInvalidException(String currentMessage, Throwable ex) {
        super(currentMessage, ex);
    }

    public ParameterInvalidException(String field, String value) {
        super(String.format(FIELD_MESSAGE, value, field));
    }
}
