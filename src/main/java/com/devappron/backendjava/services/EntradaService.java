package com.devappron.backendjava.services;

import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

import com.devappron.backendjava.data.entidades.CiudadEntity;
import com.devappron.backendjava.data.entidades.EntradaEntity;
import com.devappron.backendjava.data.entidades.UsuarioEntity;
import com.devappron.backendjava.data.repositorios.ICiudadRepository;
import com.devappron.backendjava.data.repositorios.IEntradaRepository;
import com.devappron.backendjava.data.repositorios.IUsuarioRepository;
import com.devappron.backendjava.shared.EntradaActualizarDto;
import com.devappron.backendjava.shared.EntradaCrearDto;
import com.devappron.backendjava.shared.EntradaDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntradaService implements IEntradaService{

    @Autowired
    ModelMapper modelmapper;

    @Autowired
    IUsuarioRepository iUsuarioRepository;

    @Autowired
    ICiudadRepository iCiudadRepository;

    @Autowired
    IEntradaRepository iEntradaRepository;

    @Override
    public EntradaDto crearEntrada(EntradaCrearDto entradaCrearDto) {

        UsuarioEntity usuarioEntity = iUsuarioRepository.findByUserName(entradaCrearDto.getUserName());

        CiudadEntity ciudadEntityCiudades = iCiudadRepository.findById(entradaCrearDto.getCiudadCiudades());

        EntradaEntity entradaEntity = new EntradaEntity();
        entradaEntity.setEntradaId(UUID.randomUUID().toString());
        entradaEntity.setFecha(entradaCrearDto.getFecha());
        entradaEntity.setEstatus(entradaCrearDto.getEstatus());
        entradaEntity.setTipo(entradaCrearDto.getTipo());
        entradaEntity.setNombreMascota(entradaCrearDto.getNombreMascota());
        entradaEntity.setRaza(entradaCrearDto.getRaza());
        entradaEntity.setDescripcion(entradaCrearDto.getDescripcion());
        entradaEntity.setDireccion(entradaCrearDto.getDireccion());
        entradaEntity.setNombreDueno(entradaCrearDto.getNombreDueno());
        entradaEntity.setPhoneDueno(entradaCrearDto.getPhoneDueno());
        entradaEntity.setUsuarioEntity(usuarioEntity);
        entradaEntity.setCiudadEntityCiudades(ciudadEntityCiudades);

        EntradaEntity entradaCreado = iEntradaRepository.save(entradaEntity);
     
        EntradaDto entradaDto = modelmapper.map(entradaCreado, EntradaDto.class);            
        
        return entradaDto;
    }

    @Override
    public List<EntradaDto> obtenerUltimos() {
        
        List<EntradaEntity> entradaEntityList = iEntradaRepository.getUltimosEntradas();

        List<EntradaDto> entradaDtoList = new ArrayList<>();

        for(EntradaEntity entradaEntity: entradaEntityList){
            EntradaDto entradaDto = modelmapper.map(entradaEntity, EntradaDto.class);
            entradaDtoList.add(entradaDto);
        }

        return entradaDtoList;
    }

    @Override
    public EntradaDto obtenerEntrada(String id) {

        EntradaEntity entradaEntity = iEntradaRepository.findByEntradaId(id);

        EntradaDto postDto = modelmapper.map(entradaEntity, EntradaDto.class);

        return postDto;
    }

    @Override
    public void eliminarEntrada(String entradaId, long usuarioId) {
       
        EntradaEntity entradaEntity = iEntradaRepository.findByEntradaId(entradaId);

        if(entradaEntity.getUsuarioEntity().getId() != usuarioId){
            throw new  RuntimeException("No se puede realizar esta accion");
        }

        iEntradaRepository.delete(entradaEntity);        
    }

    @Override
    public EntradaDto actualizarEntrada(String entradaId, EntradaActualizarDto entradaActualizarDto) {
        
        EntradaEntity entradaEntity = iEntradaRepository.findByEntradaId(entradaId);

        UsuarioEntity usuarioEntity= iUsuarioRepository.findByUserName(entradaActualizarDto.getUserName());

        if(entradaEntity.getUsuarioEntity().getId() != usuarioEntity.getId()){
            throw new RuntimeException("No se puede realizar esta acccion");
        }

        entradaEntity.setEstatus(entradaActualizarDto.getEstatus());
        entradaEntity.setNombreMascota(entradaActualizarDto.getNombreMascota());
        entradaEntity.setRaza(entradaActualizarDto.getRaza());
        entradaEntity.setDescripcion(entradaActualizarDto.getDescripcion());
        entradaEntity.setDireccion(entradaActualizarDto.getDireccion());
        entradaEntity.setNombreDueno(entradaActualizarDto.getNombreDueno());
        entradaEntity.setPhoneDueno(entradaActualizarDto.getPhoneDueno());

        EntradaEntity entradaEntityActualizado= iEntradaRepository.save(entradaEntity);

        EntradaDto entradaDto = modelmapper.map(entradaEntityActualizado, EntradaDto.class);

        return entradaDto;
    }
    
}
