package com.devappron.backendjava.shared;

import java.io.Serializable;

public class UsuarioActualizarDto implements Serializable {
    
    private static final long serialVersionUID= 1L;

    private String userName;
    private String nombre;
    private String email;
    private String phone;

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
