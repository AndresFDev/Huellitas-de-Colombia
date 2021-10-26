package com.unab.apijavahuellitas.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import com.unab.apijavahuellitas.models.peticiones.UsuarioRegistrarRequestModel;
import com.unab.apijavahuellitas.models.respuestas.PartidoRestModel;
import com.unab.apijavahuellitas.models.respuestas.UsuarioRestModel;
import com.unab.apijavahuellitas.services.IUsuarioService;
import com.unab.apijavahuellitas.shared.PartidoDTO;
import com.unab.apijavahuellitas.shared.UsuarioCrearDTO;
import com.unab.apijavahuellitas.shared.UsuarioDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    ModelMapper modelmapper;

    @Autowired
    IUsuarioService iUsuarioService;

    @GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UsuarioRestModel obtenerUsuario(){

        Authentication authentication =SecurityContextHolder.getContext().getAuthentication();

        String userName= authentication.getPrincipal().toString();

        UsuarioDTO usuarioDTO= iUsuarioService.obtenerUsuario(userName);

        UsuarioRestModel usuarioRestModel=modelmapper.map(usuarioDTO, UsuarioRestModel.class);

        return usuarioRestModel;
    }

    @PostMapping
    public UsuarioRestModel crearUsuario(@RequestBody @Valid UsuarioRegistrarRequestModel usuarioRegistroRequestModel){
       
        UsuarioCrearDTO usuarioCrearDTO= modelmapper.map(usuarioRegistroRequestModel, UsuarioCrearDTO.class);
        
        UsuarioDTO usuarioDTO= iUsuarioService.crearUsuario(usuarioCrearDTO);

        UsuarioRestModel usuarioRestModel= modelmapper.map(usuarioDTO, UsuarioRestModel.class);

        return usuarioRestModel;
    }

    @GetMapping(path = "/partidos")
    public List<PartidoRestModel> getPartidos(){

        Authentication authentication =SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        List<PartidoDTO> partidoDTOList= iUsuarioService.obtenerUsuarioPartidos(username);

        List<PartidoRestModel> partidoRestModelList= new ArrayList<>();

        for(PartidoDTO partidoDTO : partidoDTOList){
            PartidoRestModel partidoRestModel= modelmapper.map(partidoDTO, PartidoRestModel.class);
            if(partidoRestModel.getFecha().compareTo(new Date(System.currentTimeMillis())) < 0 ){
                partidoRestModel.setJugado(true);
            }
            partidoRestModelList.add(partidoRestModel);
        }

        return partidoRestModelList;
    }
    
}
