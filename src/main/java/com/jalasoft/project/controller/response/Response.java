package com.jalasoft.project.controller.response;

/**
 * @author HP
 * @version 1.1
 */
public abstract class Response {
    private String status;

    public Response(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
