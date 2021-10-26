package com.unab.apijavahuellitas.shared;

import java.io.Serializable;
import java.util.List;

public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String userId;
    private String nombre;
    private String email;
    private String userName;
    private String telefono;
    private String password;
    private String encryptedPassword;
    private List<PartidoDTO> partidoDtoList;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEncryptedPassword() {
        return encryptedPassword;
    }
    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }
    public List<PartidoDTO> getPartidoDtoList() {
        return partidoDtoList;
    }
    public void setPartidoDtoList(List<PartidoDTO> partidoDtoList) {
        this.partidoDtoList = partidoDtoList;
    }


}