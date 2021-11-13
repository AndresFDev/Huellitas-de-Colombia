package com.devappron.backendjava.models.peticiones;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class EntradaCrearRequestModel {

    private Date fecha;

    @NotEmpty(message="Debe seleccionar el estado de su mascota")
    private String estatus;

    @NotEmpty(message="Debe seleccionar un tipo de mascota")
    private String tipo;

    @NotEmpty(message="El nombre de la mascota no puede ser vacio")
    private String nombreMascota;

    @NotEmpty(message="La raza de la mascota no puede ser vacio")
    private String raza;

    @NotEmpty(message="La descripción de la mascota no puede ser vacio")
    private String descripcion;

    @NotEmpty(message="La dirección no puede estar vacio")
    private String direccion;

    @NotEmpty(message="El nombre del dueño no puede ser vacio")
    private String nombreDueno;

    @NotEmpty(message="El teléfono no puede ser vacio")
    @Size(min =10, max =10, message="El teléfono debe tener 10 números")
    private String phoneDueno;

    @NotEmpty(message="La ciudad no puede ser vacio")
    private String ciudadCiudades;

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

    public String getCiudadCiudades() {
        return this.ciudadCiudades;
    }

    public void setCiudadCiudades(String ciudadCiudades) {
        this.ciudadCiudades = ciudadCiudades;
    }

}
