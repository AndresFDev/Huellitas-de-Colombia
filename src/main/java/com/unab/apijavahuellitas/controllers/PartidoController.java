package com.unab.apijavahuellitas.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.unab.apijavahuellitas.models.peticiones.PartidoActualizarRequestModel;
import com.unab.apijavahuellitas.models.peticiones.PartidoCrearRequestModel;
import com.unab.apijavahuellitas.models.respuestas.MensajeOperacionModel;
import com.unab.apijavahuellitas.models.respuestas.PartidoRestModel;
import com.unab.apijavahuellitas.services.IPartidoService;
import com.unab.apijavahuellitas.services.IUsuarioService;
import com.unab.apijavahuellitas.shared.PartidoActualizarDTO;
import com.unab.apijavahuellitas.shared.PartidoCrearDTO;
import com.unab.apijavahuellitas.shared.PartidoDTO;
import com.unab.apijavahuellitas.shared.UsuarioDTO;

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
@RequestMapping("/partidos")
public class PartidoController {

    @Autowired
    ModelMapper modelmapper;

    @Autowired
    IPartidoService iPartidoService;

    @Autowired
    IUsuarioService iUsuarioService;

    
    @PostMapping
    public PartidoRestModel crearPartido(@RequestBody @Valid PartidoCrearRequestModel partidoCrearRequestModel){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        PartidoCrearDTO partidoCrearDTO = modelmapper.map(partidoCrearRequestModel, PartidoCrearDTO.class);
        partidoCrearDTO.setUserName(username);

        PartidoDTO partidoDTO = iPartidoService.crearPartido(partidoCrearDTO);

        PartidoRestModel partidoRestModel= modelmapper.map(partidoDTO, PartidoRestModel.class);

        // if(partidoRestModel.getFecha().compareTo(new Date(System.currentTimeMillis())) < 0 ){
        //     partidoRestModel.setJugado(true);
        // }

        return partidoRestModel;
    }

    @GetMapping(path="/ultimos")
    public List<PartidoRestModel> ultimosPartidos(){
        
        List<PartidoDTO> patidoDtoList=iPartidoService.obtenerUltimos();

        List<PartidoRestModel> partidoRestModelList=new ArrayList<>();

        for(PartidoDTO partidoDTO : patidoDtoList){
            PartidoRestModel partidoRestModel= modelmapper.map(partidoDTO, PartidoRestModel.class);
            partidoRestModelList.add(partidoRestModel);
        }

        return partidoRestModelList;
    }

    @GetMapping(path="/{id}")
    public PartidoRestModel obtenerPartido(@PathVariable String id){

        PartidoDTO partidoDTO= iPartidoService.obtenerPartido(id);

        PartidoRestModel partidoRestModel = modelmapper.map(partidoDTO, PartidoRestModel.class);

        // if(partidoRestModel.getFecha().compareTo(new Date(System.currentTimeMillis())) < 0 ){
        //     partidoRestModel.setJugado(true);
        // }

        return partidoRestModel;
    }

    @DeleteMapping(path="/{id}")
    public MensajeOperacionModel eliminarPartido(@PathVariable String id){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        UsuarioDTO usuarioDTO= iUsuarioService.obtenerUsuario(username);

        MensajeOperacionModel mensajeOperacionModel= new MensajeOperacionModel();
        mensajeOperacionModel.setNombre("Eliminar");

        iPartidoService.eliminarPartido(id, usuarioDTO.getId());

        mensajeOperacionModel.setResultado("Exitoso");

        return mensajeOperacionModel;
    }

    @PutMapping(path = "/{id}")
    public PartidoRestModel actualizarPartido(@RequestBody @Valid PartidoActualizarRequestModel partidoActualizarRequestModel, @PathVariable String id){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        PartidoActualizarDTO partidoActualizarDTO = modelmapper.map(partidoActualizarRequestModel, PartidoActualizarDTO.class);
        partidoActualizarDTO.setUserName(username);

        PartidoDTO partidoDTO = iPartidoService.actualizarPartido(id, partidoActualizarDTO);

        PartidoRestModel partidoRestModel = modelmapper.map(partidoDTO, PartidoRestModel.class);

        return partidoRestModel;

    }

}

