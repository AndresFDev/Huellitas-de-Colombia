package com.devappron.backendjava.shared;

import java.io.Serializable;
import java.util.List;

public class UsuarioDto implements Serializable {

    private static final long serialVersionUID =1L;

    private long id;
    private String userId;
    private String nombre;
    private String email;
    private String userName;
    private String phone;
    private String password;
    private String encryptedPassword;
    private CiudadDto ciudadDtoCiudades;
    private List<EntradaDto> entradaDtoList;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncryptedPassword() {
        return this.encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public CiudadDto getCiudadDtoCiudades() {
        return this.ciudadDtoCiudades;
    }

    public void setCiudadEntityCiudades(CiudadDto ciudadDtoCiudades) {
        this.ciudadDtoCiudades = ciudadDtoCiudades;
    }

    public List<EntradaDto> getEntradaDtoList() {
        return this.entradaDtoList;
    }

    public void setEntradaDtoList(List<EntradaDto> entradaDtoList) {
        this.entradaDtoList = entradaDtoList;
    }
        
}
