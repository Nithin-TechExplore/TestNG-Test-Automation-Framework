package com.ui.pojo;

import com.constants.Env;

import java.util.Map;

public class Config {

    public Map<Env, Environment> getEnvironments() {
        return environments;
    }

    public void setEnvironments(Map<Env, Environment> environments) {
        this.environments = environments;
    }

    Map<Env, Environment> environments;
}
