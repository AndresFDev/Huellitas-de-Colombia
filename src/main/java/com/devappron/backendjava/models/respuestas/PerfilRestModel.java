package com.devappron.backendjava.models.respuestas;

public class PerfilRestModel {
    
    private UsuarioRestModel usuarioRestModel;

    public UsuarioRestModel getUsuarioRestModel() {
        return usuarioRestModel;
    }

    public void setUsuarioDto(UsuarioRestModel usuarioRestModel) {
        this.usuarioRestModel = usuarioRestModel;
    }

}
