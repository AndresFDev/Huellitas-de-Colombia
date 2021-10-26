package com.unab.apijavahuellitas.models.respuestas;

import java.util.Date;

public class MensajeErrorModel {


    private Date timestamp;
    private String mensaje;

    public MensajeErrorModel() {
    }

    public MensajeErrorModel(Date timestamp, String mensaje) {
        this.timestamp = timestamp;
        this.mensaje = mensaje;
    }
 

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
      
    
}
