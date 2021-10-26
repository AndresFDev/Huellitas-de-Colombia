package com.unab.apijavahuellitas.shared;

import java.io.Serializable;
import java.util.Date;

public class PartidoCrearDTO implements Serializable {
    
    private static final long serialVersionUID= 1L;
    
    private Date fecha;
    private long equipoLocal;
    private long equipoVisitante;
    private String userName;
    
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public long getEquipoLocal() {
        return equipoLocal;
    }
    public void setEquipoLocal(long equipoLocal) {
        this.equipoLocal = equipoLocal;
    }
    public long getEquipoVisitante() {
        return equipoVisitante;
    }
    public void setEquipoVisitante(long equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
}
