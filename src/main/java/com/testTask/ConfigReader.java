package com.testTask;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class ConfigReader {
    String result = "";
    InputStream inputStream;

    public String readPropeties() throws IOException {
        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            Date time = new Date(System.currentTimeMillis());

            // get the property value and print it out
            String unprocessed = prop.getProperty("unprocessed");
            String processed = prop.getProperty("processed");

            result = unprocessed + processed;
            System.out.println(result + "\nProgram Ran on " + time);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        ConfigReader configReader = new ConfigReader();
        configReader.readPropeties();
    }
}

