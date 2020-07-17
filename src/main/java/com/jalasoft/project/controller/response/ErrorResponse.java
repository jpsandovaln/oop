package com.jalasoft.project.controller.response;

/**
 * @author HP
 * @version 1.1
 */
public class ErrorResponse extends Response {
    private String error;

    public ErrorResponse(String status, String error) {
        super(status);
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
