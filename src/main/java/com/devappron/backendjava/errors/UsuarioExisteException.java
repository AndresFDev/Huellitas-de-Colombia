package com.devappron.backendjava.errors;

public class UsuarioExisteException extends RuntimeException {

    private static final long serialVersionUID =1L;

    public UsuarioExisteException(String mensaje) {
        super(mensaje);
    }
    
}