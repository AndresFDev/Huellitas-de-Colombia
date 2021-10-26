package com.unab.apijavahuellitas.models.respuestas;

import java.util.List;

public class UsuarioRestModel {
    
    private String userId;
    private String nombre;
    private String email;
    private String userName;
    private String telefono;
    private List<PartidoRestModel> partidoRestModelList;

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<PartidoRestModel> getPartidoRestModelList() {
        return partidoRestModelList;
    }
    public void setPartidoRestModelList(List<PartidoRestModel> partidoRestModelList) {
        this.partidoRestModelList = partidoRestModelList;
    }
}
