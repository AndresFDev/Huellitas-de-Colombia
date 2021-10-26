package com.unab.apijavahuellitas.models.respuestas;

import java.util.Date;
import java.util.Map;

public class ValidacionErrores {

    private Map<String, String> errores;
    private Date timestamp;
    
    public ValidacionErrores(Map<String, String> errores, Date timestamp) {
        this.errores = errores;
        this.timestamp = timestamp;
    }


    public Map<String, String> getErrores() {
        return errores;
    }


    public void setErrores(Map<String, String> errores) {
        this.errores = errores;
    }


    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
       
}