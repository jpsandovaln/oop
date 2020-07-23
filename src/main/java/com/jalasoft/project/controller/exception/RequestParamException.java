package com.jalasoft.project.controller.exception;

/**
 * @author HP
 * @version 1.1
 */
public class RequestParamException extends Exception {
    private static final String MESSAGE = "Invalid Param.";

    public RequestParamException() {
        super(MESSAGE);
    }

    public RequestParamException(Throwable ex) {
        super(MESSAGE, ex);
    }

    public RequestParamException(String currantMessage, Throwable ex) {
        super(currantMessage, ex);
    }

    public RequestParamException(String currentMessage) {
        super(currentMessage);
    }
}
