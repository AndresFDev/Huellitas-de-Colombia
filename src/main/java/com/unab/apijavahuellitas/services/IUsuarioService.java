package com.unab.apijavahuellitas.services;

import java.util.List;

import com.unab.apijavahuellitas.shared.PartidoDTO;
import com.unab.apijavahuellitas.shared.UsuarioCrearDTO;
import com.unab.apijavahuellitas.shared.UsuarioDTO;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUsuarioService extends UserDetailsService{

    public UsuarioDTO crearUsuario(UsuarioCrearDTO usuarioCrearDto);
    public UsuarioDTO obtenerUsuario(String userName);
    public List<PartidoDTO> obtenerUsuarioPartidos(String userName);
    
}
