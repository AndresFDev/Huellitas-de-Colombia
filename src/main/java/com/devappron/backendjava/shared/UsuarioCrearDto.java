package com.devappron.backendjava.shared;

import java.io.Serializable;


public class UsuarioCrearDto implements Serializable {

    private static final long serialVersionUID =1L;

    private String nombre;
    private String email;
    private String userName;
    private String phone;
    private String password;
    private long ciudadCiudades;

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

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getCiudadCiudades() {
        return this.ciudadCiudades;
    }

    public void setCiudadCiudades(long ciudadCiudades) {
        this.ciudadCiudades = ciudadCiudades;
    }

}
