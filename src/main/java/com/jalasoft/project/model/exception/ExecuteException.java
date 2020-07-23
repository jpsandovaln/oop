package com.jalasoft.project.model.exception;

/**
 * @author HP
 * @version 1.1
 */
public class ExecuteException extends Exception {
    private static final String MESSAGE = "Error executing code.";

    public ExecuteException() {
        super(MESSAGE);
    }

    public ExecuteException(Throwable ex) {
        super(MESSAGE, ex);
    }

    public ExecuteException(String currantMessage, Throwable ex) {
        super(currantMessage, ex);
    }

    public ExecuteException(String currentMessage) {
        super(currentMessage);
    }
}
