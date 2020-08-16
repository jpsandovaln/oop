package com.jalasoft.project.model.command;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HP
 * @version 1.1
 */
public class CommandFactory {
    public final static String JAVA = "java";
    public final static String PYTHON = "python";
    public final static String JAVA_PROXY = "javaProxy";

    private final static Map<String, ICommandBuilder> COMMAND = new HashMap<String, ICommandBuilder>() {
        {
            put(JAVA, new JavaCommand());
            put(PYTHON, new PythonCommand());
            put(JAVA_PROXY, new JavaCommandProxy());
        }
    };

    public static  ICommandBuilder getCommand(String lang) {
        return COMMAND.get(lang);
    }
}
