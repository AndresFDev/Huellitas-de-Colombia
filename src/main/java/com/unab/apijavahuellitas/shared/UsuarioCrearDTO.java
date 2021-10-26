package com.unab.apijavahuellitas.shared;

import java.io.Serializable;

public class UsuarioCrearDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombre;
    private String email;
    private String userName;
    private String telefono;
    private String password;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return email;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
}
