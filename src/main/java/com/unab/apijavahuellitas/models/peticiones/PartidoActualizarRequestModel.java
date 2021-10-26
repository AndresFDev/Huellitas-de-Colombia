package com.unab.apijavahuellitas.models.peticiones;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class PartidoActualizarRequestModel {
       
    @NotEmpty(message="Los goles del equipo local no puede ser vacio")
    @Pattern(regexp="(\\d)", 
    message="Los goles del equipo local deben ser numeros.")
    private String golesLocal;

    @NotEmpty(message="Los goles del equipo visitante no puede ser vacio")
    @Pattern(regexp="(\\d)", 
    message="Los goles del equipo visitante deben ser numeros.")
    private String golesVisitante;

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

    
}
