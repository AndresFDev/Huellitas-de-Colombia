package com.unab.apijavahuellitas.models.respuestas;

import java.util.Date;


public class PartidoRestModel {
    
    private String partidoId;
    private Date fecha;
    private String golesLocal;
    private String golesVisitante;
    private Date createdAt;    
    private boolean jugado = false;
    private UsuarioRestModel usuarioRestModel;
    private EquipoRestModel equipoRestModelLocal;
    private EquipoRestModel equipoRestModelVisitante;


    public String getPartidoId() {
        return partidoId;
    }

    public void setPartidoId(String partidoId) {
        this.partidoId = partidoId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    
    public boolean isJugado() {
        jugado=getFecha().compareTo(new Date(System.currentTimeMillis())) < 0;
        return jugado;
    }

    public void setJugado(boolean jugado) {
        this.jugado = jugado;
    }

    public UsuarioRestModel getUsuarioRestModel() {
        return usuarioRestModel;
    }

    public void setUsuarioDto(UsuarioRestModel usuarioRestModel) {
        this.usuarioRestModel = usuarioRestModel;
    }

    public EquipoRestModel getEquipoRestModelLocal() {
        return equipoRestModelLocal;
    }

    public void setEquipoDtoLocal(EquipoRestModel equipoRestModelLocal) {
        this.equipoRestModelLocal = equipoRestModelLocal;
    }

    public EquipoRestModel getEquipoRestModelVisitante() {
        return equipoRestModelVisitante;
    }

    public void setEquipoDtoVisitante(EquipoRestModel equipoRestModelVisitante) {
        this.equipoRestModelVisitante = equipoRestModelVisitante;
    }

}
