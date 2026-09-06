package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class demoTest {


    public static void main(String[] args) {


        File propFile=new File(System.getProperty("user.dir")+"//config//"+"//QA.properties");
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
        String value=properties.getProperty("MAX_NUMBER_OF_ATTEMPTS");
        System.out.println(value);
        //return value;
    }
}
