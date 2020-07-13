package com.jalasoft.project.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.jalasoft.project.model.parameter.JavaParameter;
import org.apache.commons.io.FilenameUtils;

/**
 * @author HP
 * @version 1.1
 */
public class ExecuteJava {

    private static  final String JAVA_COMPILE = "javac ";
    private static final String JAVA_EXECUTE = "java ";
    private static final String JAVA_CP_PARAM = "-cp ";
    private static final String JAVA_AND = " && ";
    private static final String SPACE = " ";

    public String execute(JavaParameter javaParameter) {
        StringBuilder command = new StringBuilder();
        command.append(javaParameter.getJavaFolder())
                .append(JAVA_COMPILE)
                .append(javaParameter.getJavaFile().getAbsolutePath())
                .append(JAVA_AND)
                .append(JAVA_EXECUTE)
                .append(JAVA_CP_PARAM)
                .append(javaParameter.getJavaFile().getParent())
                .append(SPACE)
                .append(FilenameUtils.getBaseName(javaParameter.getJavaFile().getName()));
        try {
            // ProcessBuilder builder = new ProcessBuilder("bash", "-c","\"" + command + "\"");
            ProcessBuilder builder = new ProcessBuilder("cmd", "/c", "\"" + command.toString() + "\"");
            builder.redirectErrorStream(true);

            Process process = builder.start();
            process.waitFor();

            InputStreamReader streamReader = new InputStreamReader(process.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);

            StringBuilder result = new StringBuilder();
            while (reader.ready()) {
                result.append((char) reader.read());
            }

            return result.toString();
        } catch (IOException ex) {
            // throw new Exception("error");
            return ex.getMessage();
        } catch (InterruptedException ex) {
            return ex.getMessage();
        }
    }
}
