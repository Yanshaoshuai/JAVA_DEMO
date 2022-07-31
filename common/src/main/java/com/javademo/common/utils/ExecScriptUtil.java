package com.javademo.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExecScriptUtil {
    private ExecScriptUtil() {
    }

    private final static Logger LOG = LoggerFactory.getLogger(ExecScriptUtil.class);

    public static String execWindows(String script) throws IOException {
        ProcessBuilder builder = new ProcessBuilder();
        builder.command("cmd.exe", "/c", script);
        return exec(script, builder);
    }

    public static String execLinux(String script) throws IOException {
        ProcessBuilder builder = new ProcessBuilder();
        builder.command("bash", "-c", script);
        return exec(script, builder);
    }

    private static String exec(String script, ProcessBuilder builder) throws IOException {
        BufferedReader reader = null;
        StringBuffer result = new StringBuffer();
        try {
            Process process = builder.start();
            int code = process.waitFor();
            if (code == 0) {
                reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                result.append("SUCCESS\n");
            } else {
                reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                result.append("FAILED\n");
            }
            String line = null;
            while ((line = reader.readLine()) != null) {
                result.append(line);
                result.append("\n");
            }
        } catch (Exception e) {
            result.append("EXCEPTION\n");
            LOG.error("exec script {} failed {}", script, e);
        } finally {
            reader.close();
        }

        return result.toString();
    }
}
