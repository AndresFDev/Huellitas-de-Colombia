package com.devappron.backendjava.shared;

import java.io.Serializable;

public class EntradaActualizarDto implements Serializable {
    
    private static final long serialVersionUID= 1L;

    private String estatus;
    private String nombreMascota;
    private String raza;
    private String descripcion;
    private String direccion;
    private String nombreDueno;
    private String phoneDueno;
    private String userName;

    public String getEstatus() {
        return this.estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getNombreMascota() {
        return this.nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getRaza() {
        return this.raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreDueno() {
        return this.nombreDueno;
    }

    public void setNombreDueno(String nombreDueno) {
        this.nombreDueno = nombreDueno;
    }

    public String getPhoneDueno() {
        return this.phoneDueno;
    }

    public void setPhoneDueno(String phoneDueno) {
        this.phoneDueno = phoneDueno;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
}
