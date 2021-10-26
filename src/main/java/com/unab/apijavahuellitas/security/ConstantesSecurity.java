package com.unab.apijavahuellitas.security;

import com.unab.apijavahuellitas.utils.AppPropiedades;
import com.unab.apijavahuellitas.utils.AppContexto;

public class ConstantesSecurity {

    public static String SIGN_UP_URL = "/usuarios";
    public static long EXPIRATION_DATE = 864000000;
    public static String HEADER_STRING = "Authorization";
    public static String TOKEN_PREFIX = "Bearer ";
    // public static String TOKEN_SECRET="q7pKwLcVj1n3MpFp06FS8YA30pxIWejF ";

    public static String getTokenSecret(){
        AppPropiedades appProperties = (AppPropiedades) AppContexto.getBean("AppProperties");
        return appProperties.getTokenSecret();
    }
    
}
