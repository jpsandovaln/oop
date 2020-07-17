package com.jalasoft.project.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author HP
 * @version 1.1
 */
public class ExecuteCommand {

    public String execute(String command) throws Exception {

        try {
            // ProcessBuilder builder = new ProcessBuilder("bash", "-c","\"" + command + "\"");
            ProcessBuilder builder = new ProcessBuilder("cmd", "/c", "\"" + command + "\"");
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
            return ex.getMessage();
        } catch (InterruptedException ex) {
            return ex.getMessage();
        }
    }
}
