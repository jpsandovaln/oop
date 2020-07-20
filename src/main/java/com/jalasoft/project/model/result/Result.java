package com.jalasoft.project.model.result;

/**
 * @author HP
 * @version 1.1
 */
public class Result {
    private String resultConsole;
    private String pid;

    public Result(String resultConsole, String pid) {
        this.resultConsole = resultConsole;
        this.pid = pid;
    }

    public String getResultConsole() {
        return resultConsole;
    }

    public void setResultConsole(String resultConsole) {
        this.resultConsole = resultConsole;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
