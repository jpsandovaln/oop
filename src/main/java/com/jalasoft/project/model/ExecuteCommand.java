package com.jalasoft.project.model;

import com.jalasoft.project.model.exception.ExecuteException;
import com.jalasoft.project.model.result.Result;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author HP
 * @version 1.1
 */
public class ExecuteCommand {

    public Result execute(String command) throws ExecuteException {

        try {
            // ProcessBuilder builder = new ProcessBuilder("bash", "-c","\"" + command + "\"");
            ProcessBuilder builder = new ProcessBuilder("cmd", "/c", "\"" + command + "\"");
            builder.redirectErrorStream(true);

            Process process = builder.start();
            process.waitFor();

            if (process.exitValue() != 0) {
                throw new ExecuteException("Error executing command");
            }

            InputStreamReader streamReader = new InputStreamReader(process.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);

            StringBuilder result = new StringBuilder();
            while (reader.ready()) {
                result.append((char) reader.read());
            }

            return new Result(result.toString(), this.getPid(process.toString()));
        } catch (IOException ex) {
            throw new ExecuteException(ex.getMessage());
        } catch (InterruptedException ex) {
            throw new ExecuteException(ex.getMessage());
        }
    }

    private String getPid(String process) {
        return process.substring(
                process.indexOf("=") + 1, process.indexOf(",")
        );
    }
}
