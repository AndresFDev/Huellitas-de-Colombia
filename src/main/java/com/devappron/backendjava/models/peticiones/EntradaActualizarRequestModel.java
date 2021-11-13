package com.devappron.backendjava.models.peticiones;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class EntradaActualizarRequestModel {

    @NotEmpty(message="Debe seleccionar un estado")
    private String estatus;

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
    @Size(min =10, max =10, message="La teléfono debe tener 10 números")
    private String phoneDueno;

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
    
}
