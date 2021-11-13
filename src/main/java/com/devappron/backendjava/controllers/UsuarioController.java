package com.devappron.backendjava.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import com.devappron.backendjava.models.peticiones.UsuarioActualizarRequestModel;
import com.devappron.backendjava.models.peticiones.UsuarioRegistrarRequestModel;
import com.devappron.backendjava.models.respuestas.EntradaRestModel;
import com.devappron.backendjava.models.respuestas.UsuarioRestModel;
import com.devappron.backendjava.services.IUsuarioService;
import com.devappron.backendjava.shared.EntradaDto;
import com.devappron.backendjava.shared.UsuarioActualizarDto;
import com.devappron.backendjava.shared.UsuarioCrearDto;
import com.devappron.backendjava.shared.UsuarioDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios") 
public class UsuarioController {

    @Autowired
    ModelMapper modelmapper;

    @Autowired
    IUsuarioService iUsuarioServicio;

    @GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UsuarioRestModel obtenerUsuario(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String userName = authentication.getPrincipal().toString();

        UsuarioDto usuarioDto = iUsuarioServicio.obtenerUsuario(userName);

        UsuarioRestModel usuarioRestModel = modelmapper.map(usuarioDto, UsuarioRestModel.class);

        return usuarioRestModel;
    }

    @PostMapping
    public UsuarioRestModel crearUsuario(@RequestBody @Valid UsuarioRegistrarRequestModel usuarioRegistroRequestModel){
       
        UsuarioCrearDto usuarioCrearDto = modelmapper.map(usuarioRegistroRequestModel, UsuarioCrearDto.class);
        
        UsuarioDto usuarioDto = iUsuarioServicio.crearUsuario(usuarioCrearDto);

        UsuarioRestModel usuarioRestModel = modelmapper.map(usuarioDto, UsuarioRestModel.class);

        return usuarioRestModel;
    }

    @PutMapping(path = "/{id}")
    public UsuarioRestModel actualizarUsuario(@RequestBody @Valid UsuarioActualizarRequestModel usuarioActualizarRequestModel, @PathVariable String id){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String userName = authentication.getPrincipal().toString();

        UsuarioActualizarDto usuarioActualizarDto = modelmapper.map(usuarioActualizarRequestModel, UsuarioActualizarDto.class);
        usuarioActualizarDto.setUserName(userName);

        UsuarioDto usuarioDto = iUsuarioServicio.actualizarUsuario(id, usuarioActualizarDto);

        UsuarioRestModel usuarioRestModel = modelmapper.map(usuarioDto, UsuarioRestModel.class);

        return usuarioRestModel;

    }

    @GetMapping(path = "/entradas")
    public List<EntradaRestModel> getEntradas(){

        Authentication authentication =SecurityContextHolder.getContext().getAuthentication();

        String userName = authentication.getPrincipal().toString();

        List<EntradaDto> entradaDtoList= iUsuarioServicio.obtenerUsuarioEntradas(userName);

        List<EntradaRestModel> entradaRestModelList= new ArrayList<>();

        for(EntradaDto entradaDto : entradaDtoList){
            EntradaRestModel entradaRestModel= modelmapper.map(entradaDto, EntradaRestModel.class);
            if(entradaRestModel.getFecha().compareTo(new Date(System.currentTimeMillis())) < 0 ){
                entradaRestModel.setJugado(true);
            }
            entradaRestModelList.add(entradaRestModel);
        }

        return entradaRestModelList;
    }
    
}
