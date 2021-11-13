package com.devappron.backendjava.services;

import java.util.List;

import com.devappron.backendjava.shared.EntradaDto;
import com.devappron.backendjava.shared.UsuarioActualizarDto;
import com.devappron.backendjava.shared.UsuarioCrearDto;
import com.devappron.backendjava.shared.UsuarioDto;

import org.springframework.security.core.userdetails.UserDetailsService;


public interface IUsuarioService extends UserDetailsService{

    public UsuarioDto crearUsuario(UsuarioCrearDto usuarioCrearDto);

    public UsuarioDto obtenerUsuario(String userName);

    public List<EntradaDto> obtenerUsuarioEntradas(String userName);

    public UsuarioDto actualizarUsuario(String userId, UsuarioActualizarDto usuarioActualizarDto);

    // public UsuarioDto obtenerUsuarioUsuarios(String userId);
    
}
