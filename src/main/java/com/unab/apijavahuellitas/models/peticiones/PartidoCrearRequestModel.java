package com.unab.apijavahuellitas.models.peticiones;

import java.util.Date;

import javax.validation.constraints.NotEmpty;


public class PartidoCrearRequestModel {
       
    private Date fecha;

    @NotEmpty(message="El nombre del equipo local no puede ser vacio")
    private String equipoLocal;

    @NotEmpty(message="El nombre del equipo rival no puede ser vacio")
    private String equipoVisitante;

    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getEquipoLocal() {
        return equipoLocal;
    }
    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }
    public String getEquipoVisitante() {
        return equipoVisitante;
    }
    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }


   

    
    
}
