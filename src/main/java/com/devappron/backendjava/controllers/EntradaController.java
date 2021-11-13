package com.devappron.backendjava.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.devappron.backendjava.models.peticiones.EntradaActualizarRequestModel;
import com.devappron.backendjava.models.peticiones.EntradaCrearRequestModel;
import com.devappron.backendjava.models.respuestas.MensajeOperacionModel;
import com.devappron.backendjava.models.respuestas.EntradaRestModel;
import com.devappron.backendjava.services.IEntradaService;
import com.devappron.backendjava.services.IUsuarioService;
import com.devappron.backendjava.shared.EntradaActualizarDto;
import com.devappron.backendjava.shared.EntradaCrearDto;
import com.devappron.backendjava.shared.EntradaDto;
import com.devappron.backendjava.shared.UsuarioDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entradas")
public class EntradaController {

    @Autowired
    ModelMapper modelmapper;

    @Autowired
    IEntradaService iEntradaService;

    @Autowired
    IUsuarioService iUsuarioService;

    
    @PostMapping
    public EntradaRestModel crearEntrada(@RequestBody @Valid EntradaCrearRequestModel entradaCrearRequestModel){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String userName = authentication.getPrincipal().toString();

        EntradaCrearDto entradaCrearDto = modelmapper.map(entradaCrearRequestModel, EntradaCrearDto.class);
        entradaCrearDto.setUserName(userName);

        EntradaDto entradaDto = iEntradaService.crearEntrada(entradaCrearDto);

        EntradaRestModel entradaRestModel = modelmapper.map(entradaDto, EntradaRestModel.class);

        // if(partidoRestModel.getFecha().compareTo(new Date(System.currentTimeMillis())) < 0 ){
        //     partidoRestModel.setJugado(true);
        // }

        return entradaRestModel;
    }

    @GetMapping(path="/ultimos")
    public List<EntradaRestModel> ultimosEntrada(){
        
        List<EntradaDto> entradaDtoList=iEntradaService.obtenerUltimos();

        List<EntradaRestModel> entradaRestModelList = new ArrayList<>();

        for(EntradaDto entradaDto : entradaDtoList){
            EntradaRestModel entradaRestModel= modelmapper.map(entradaDto, EntradaRestModel.class);
            entradaRestModelList.add(entradaRestModel);
        }

        return entradaRestModelList;
    }

    @GetMapping(path="/{id}")
    public EntradaRestModel obtenerEntrada(@PathVariable String id){

        EntradaDto entradaDto = iEntradaService.obtenerEntrada(id);

        EntradaRestModel entradaRestModel = modelmapper.map(entradaDto, EntradaRestModel.class);

        // if(partidoRestModel.getFecha().compareTo(new Date(System.currentTimeMillis())) < 0 ){
        //     partidoRestModel.setJugado(true);
        // }

        return entradaRestModel;
    }

    @DeleteMapping(path="/{id}")
    public MensajeOperacionModel eliminarEntrada(@PathVariable String id){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        UsuarioDto usuarioDto = iUsuarioService.obtenerUsuario(username);

        MensajeOperacionModel mensajeOperacionModel= new MensajeOperacionModel();
        mensajeOperacionModel.setNombre("Eliminar");

        iEntradaService.eliminarEntrada(id, usuarioDto.getId());

        mensajeOperacionModel.setResultado("Exitoso");

        return mensajeOperacionModel;
    }

    @PutMapping(path = "/{id}")
    public EntradaRestModel actualizarEntrada(@RequestBody @Valid EntradaActualizarRequestModel entradaActualizarRequestModel, @PathVariable String id){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String userName = authentication.getPrincipal().toString();

        EntradaActualizarDto entradaActualizarDto = modelmapper.map(entradaActualizarRequestModel, EntradaActualizarDto.class);
        entradaActualizarDto.setUserName(userName);

        EntradaDto entradaDto= iEntradaService.actualizarEntrada(id, entradaActualizarDto);

        EntradaRestModel entradaRestModel = modelmapper.map(entradaDto, EntradaRestModel.class);

        return entradaRestModel;

    }

}

