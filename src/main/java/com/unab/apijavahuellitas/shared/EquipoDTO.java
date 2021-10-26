package com.unab.apijavahuellitas.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class EquipoDTO implements Serializable{
    
    private static final long serialVersionUID =1L;

    private long id;    
    private String nombre;
    private List<PartidoDTO> partidoDTOLocalList= new ArrayList<>();
    private List<PartidoDTO> partidoDTOVisitanteList= new ArrayList<>();

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public List<PartidoDTO> getPartidoDTOLocalList() {
        return partidoDTOLocalList;
    }
    public void setPartidoDTOLocalList(List<PartidoDTO> partidoDTOLocalList) {
        this.partidoDTOLocalList = partidoDTOLocalList;
    }
    public List<PartidoDTO> getPartidoDTOVisitanteList() {
        return partidoDTOVisitanteList;
    }
    public void setPartidoDTOVisitanteList(List<PartidoDTO> partidoDTOVisitanteList) {
        this.partidoDTOVisitanteList = partidoDTOVisitanteList;
    }

    
}
