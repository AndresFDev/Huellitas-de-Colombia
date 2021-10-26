package com.unab.apijavahuellitas.shared;

import java.io.Serializable;

public class PartidoActualizarDTO implements Serializable {
    
    private static final long serialVersionUID= 1L;

    private String golesLocal;
    private String golesVisitante;
    private String userName;

    public String getGolesLocal() {
        return golesLocal;
    }
    public void setGolesLocal(String golesLocal) {
        this.golesLocal = golesLocal;
    }
    public String getGolesVisitante() {
        return golesVisitante;
    }
    public void setGolesVisitante(String golesVisitante) {
        this.golesVisitante = golesVisitante;
    }
    
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    
}
