package com.devappron.backendjava.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class CiudadDto implements Serializable{
    
    private static final long serialVersionUID =1L;

    private long id;    
    private String nombre;
    private List<EntradaDto> entradaDtoCiudadesList = new ArrayList<>();
    private List<UsuarioDto> usuarioDtoCiudadesList = new ArrayList<>();

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<EntradaDto> getEntradaDtoCiudadesList() {
        return this.entradaDtoCiudadesList;
    }

    public void setEntradaDtoCiudadesList(List<EntradaDto> entradaDtoCiudadesList) {
        this.entradaDtoCiudadesList = entradaDtoCiudadesList;
    }

    public List<UsuarioDto> getUsuarioDtoCiudadesList() {
        return this.usuarioDtoCiudadesList;
    }

    public void setUsuarioDtoCiudadesList(List<UsuarioDto> usuarioDtoCiudadesList) {
        this.usuarioDtoCiudadesList = usuarioDtoCiudadesList;
    }
    
}
