package com.fleetManagement.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    //1 create object of properties
    private static Properties properties= new Properties();

    static {
        //2 We need to open the file in the java memory

        //3 Load properties file in the properties object
        try {
            FileInputStream file= new FileInputStream("configurations.properties");
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //create a utility method to use the object to read
    //4 use the "properties" object to read value from the file

    public static  String getProperty(String keyWord){
        return properties.getProperty(keyWord);
    }

}
