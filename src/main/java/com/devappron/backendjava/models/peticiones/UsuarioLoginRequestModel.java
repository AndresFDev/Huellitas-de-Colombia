package com.devappron.backendjava.models.peticiones;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UsuarioLoginRequestModel {

    @NotEmpty(message="El nombre de usuario no puede ser vacio")
    private String userName;

    @NotEmpty(message="La contraseña no puede ser vacia")
    @Size(min =8, max =30, message="La contraseña debe tener entre 8 y 30 caracteres")
    private String password;


    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
  
      

    
}


