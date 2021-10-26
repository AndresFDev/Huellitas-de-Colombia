package com.unab.apijavahuellitas.shared;

import java.io.Serializable;
import java.util.Date;


public class PartidoDTO implements Serializable {

    private static final long serialVersionUID= 1L;
    
    private long id;
    private String partidoId;
    private Date fecha;
    private String golesLocal;
    private String golesVisitante;
    private Date createdAt;
    private UsuarioDTO usuarioDTO;
    private EquipoDTO equipoDTOLocal;
    private EquipoDTO equipoDTOVisitante;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }

    public void setUsuarioEntity(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }

    public EquipoDTO getEquipoDTOLocal() {
        return equipoDTOLocal;
    }

    public void setEquipoEntityLocal(EquipoDTO equipoDTOLocal) {
        this.equipoDTOLocal = equipoDTOLocal;
    }

    public EquipoDTO getEquipoDTOVisitante() {
        return equipoDTOVisitante;
    }

    public void setEquipoEntityVisitante(EquipoDTO equipoDTOVisitante) {
        this.equipoDTOVisitante = equipoDTOVisitante;
    }

}