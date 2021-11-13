package com.devappron.backendjava.shared;

import java.io.Serializable;
import java.util.Date;

public class EntradaCrearDto implements Serializable {
    
    private static final long serialVersionUID= 1L;
    
    private Date fecha;
    private String estatus;
    private String tipo;
    private String nombreMascota;
    private String raza;
    private String descripcion;
    private String direccion;
    private String nombreDueno;
    private String phoneDueno;
    private long ciudadCiudades;
    private String userName;

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstatus() {
        return this.estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public long getCiudadCiudades() {
        return this.ciudadCiudades;
    }

    public void setCiudadCiudades(long ciudadCiudades) {
        this.ciudadCiudades = ciudadCiudades;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
}
