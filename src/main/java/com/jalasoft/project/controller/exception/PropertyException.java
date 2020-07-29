package com.jalasoft.project.controller.exception;

/**
 * @author HP
 * @version 1.1
 */
public class PropertyException extends Exception {
    private static final String MESSAGE = "Error.";

    public PropertyException() {
        super(MESSAGE);
    }

    public PropertyException(Throwable ex) {
        super(MESSAGE, ex);
    }

    public PropertyException(String currantMessage, Throwable ex) {
        super(currantMessage, ex);
    }

    public PropertyException(String currentMessage) {
        super(currentMessage);
    }
}
