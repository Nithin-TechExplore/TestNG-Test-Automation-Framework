package com.utility;

import com.constants.Env;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {


    public static String readProperty(Env env, String propertyName)
    {
        File propFile=new File(System.getProperty("user.dir")+"//config//"+env+".properties");

        System.out.println(System.getProperty("user.dir")+"//config//"+env+".properties");
        FileReader fileReader=null;
        try {
            fileReader=new FileReader(propFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Properties properties=new Properties();
        try {
            properties.load(fileReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String value=properties.getProperty(propertyName);
        System.out.println(value);
        return value;



    }
}
