package com.devappron.backendjava.models.respuestas;

import java.util.List;

public class UsuarioRestModel {

    private String userId; 
    private String nombre;
    private String email;
    private String userName;
    private String phone;
    private CiudadRestModel ciudadRestModelCiudades;
    private List<EntradaRestModel> entradaRestModelList;

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CiudadRestModel getCiudadRestModelCiudades() {
        return this.ciudadRestModelCiudades;
    }

    public void setCiudadDtoCiudades(CiudadRestModel ciudadRestModelCiudades) {
        this.ciudadRestModelCiudades = ciudadRestModelCiudades;
    }

    public List<EntradaRestModel> getEntradaRestModelList() {
        return this.entradaRestModelList;
    }

    public void setEntradaRestModelList(List<EntradaRestModel> entradaRestModelList) {
        this.entradaRestModelList = entradaRestModelList;
    }
}
