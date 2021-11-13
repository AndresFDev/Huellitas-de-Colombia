package com.devappron.backendjava.data.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity(name = "ciudades")
public class CiudadEntity implements Serializable {

    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 20)
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy ="ciudadEntityCiudades")
    private List<EntradaEntity> entradaEntityCiudadesList= new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy ="ciudadEntityCiudades")
    private List<UsuarioEntity> usuarioEntityCiudadesList= new ArrayList<>();

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

    public List<EntradaEntity> getEntradaEntityCiudadesList() {
        return this.entradaEntityCiudadesList;
    }

    public void setEntradaEntityCiudadesList(List<EntradaEntity> entradaEntityCiudadesList) {
        this.entradaEntityCiudadesList = entradaEntityCiudadesList;
    }

    public List<UsuarioEntity> getUsuarioEntityCiudadesList() {
        return this.usuarioEntityCiudadesList;
    }

    public void setUsuarioEntityCiudadesList(List<UsuarioEntity> usuarioEntityCiudadesList) {
        this.usuarioEntityCiudadesList = usuarioEntityCiudadesList;
    }

}
