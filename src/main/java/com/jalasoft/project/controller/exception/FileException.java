package com.jalasoft.project.controller.exception;

/**
 * @author HP
 * @version 1.1
 */
public class FileException extends Exception {
    private static final String MESSAGE = "Error.";

    public FileException() {
        super(MESSAGE);
    }

    public FileException(Throwable ex) {
        super(MESSAGE, ex);
    }

    public FileException(String currantMessage, Throwable ex) {
        super(currantMessage, ex);
    }

    public FileException(String currentMessage) {
        super(currentMessage);
    }
}
