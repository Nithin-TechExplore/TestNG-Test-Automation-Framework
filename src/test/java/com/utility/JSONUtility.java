package com.utility;
import com.constants.Env;
import com.google.gson.*;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JSONUtility {

    public static String readJSON(Env env) {
        Gson gson=new Gson();
        FileReader fileReader=null;
        File jsonFile=new File(System.getProperty("user.dir")+"//config//config.json");
        try {
            fileReader=new FileReader(jsonFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Config config=gson.fromJson(fileReader, Config.class);
        Environment environment=config.getEnvironments().get(env);
        System.out.println(environment.getUrl());
        return environment.getUrl();


    }
}
