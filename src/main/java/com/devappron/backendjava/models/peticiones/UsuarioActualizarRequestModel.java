package com.devappron.backendjava.models.peticiones;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UsuarioActualizarRequestModel {
       
    @NotEmpty(message="El usuario no puede estar vacio")
    private String userName;

    @NotEmpty(message="El nombre no puede estar vacio")
    private String nombre;

    @NotEmpty(message="El correo no puede estar vacio")
    private String email;

    @NotEmpty(message="El teléfono no puede estar vacio")
    @Size(min =8, max =30, message="La contraseña debe tener entre 8 y 30 caracteres")
    private String phone;

    @NotEmpty(message="La contraseña no puede estar vacia")
    private String encryptedPassword;

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

    public String getEncryptedPassword() {
        return this.encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }
    
}
