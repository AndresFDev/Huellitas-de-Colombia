package com.devappron.backendjava.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component 
public class AppPropiedades {
    
    
    @Autowired
    private Environment environment;

    public String getTokenSecret() {
        return environment.getProperty("tokenSecret");
    }    
}


