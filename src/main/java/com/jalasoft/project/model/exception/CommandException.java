package com.jalasoft.project.model.exception;

/**
 * @author HP
 * @version 1.1
 */
public class CommandException extends Exception{
    private static final String MESSAGE = "Malformed command.";

    public CommandException() {
        super(MESSAGE);
    }

    public CommandException(Throwable ex) {
        super(MESSAGE, ex);
    }

    public CommandException(String currantMessage, Throwable ex) {
        super(currantMessage, ex);
    }

    public CommandException(String currentMessage) {
        super(currentMessage);
    }
}
