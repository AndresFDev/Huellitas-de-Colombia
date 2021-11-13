package com.devappron.backendjava.models.respuestas;

import java.util.Date;


public class EntradaRestModel {
    
    private String entradaId;
    private Date fecha;
    private String estatus;
    private String tipo;
    private String nombreMascota;
    private String raza;
    private String descripcion;
    private String direccion;
    private String nombreDueno;
    private String phoneDueno;
    private Date createdAt;  
    private boolean jugado = false;
    private UsuarioRestModel usuarioRestModel;
    private CiudadRestModel ciudadRestModelCiudades;

    public String getEntradaId() {
        return this.entradaId;
    }

    public void setEntradaId(String entradaId) {
        this.entradaId = entradaId;
    }

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

    public Date getCreatedAt() {
        return this.createdAt;
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
        return this.usuarioRestModel;
    }

    public void setUsuarioDto(UsuarioRestModel usuarioRestModel) {
        this.usuarioRestModel = usuarioRestModel;
    }

    public CiudadRestModel getCiudadRestModelCiudades() {
        return this.ciudadRestModelCiudades;
    }

    public void setCiudadDtoCiudades(CiudadRestModel ciudadRestModelCiudades) {
        this.ciudadRestModelCiudades = ciudadRestModelCiudades;
    }

}
