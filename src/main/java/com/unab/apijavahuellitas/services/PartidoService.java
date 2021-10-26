package com.unab.apijavahuellitas.services;

import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

import com.unab.apijavahuellitas.data.entidades.EquipoEntity;
import com.unab.apijavahuellitas.data.entidades.PartidoEntity;
import com.unab.apijavahuellitas.data.entidades.UsuarioEntity;
import com.unab.apijavahuellitas.data.repositorios.IEquipoRepository;
import com.unab.apijavahuellitas.data.repositorios.IPartidoRepository;
import com.unab.apijavahuellitas.data.repositorios.IUsuarioRepository;
import com.unab.apijavahuellitas.shared.PartidoActualizarDTO;
import com.unab.apijavahuellitas.shared.PartidoCrearDTO;
import com.unab.apijavahuellitas.shared.PartidoDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartidoService implements IPartidoService{

    @Autowired
    ModelMapper modelmapper;

    @Autowired
    IUsuarioRepository iUsuarioRepository;

    @Autowired
    IEquipoRepository iEquipoRepository;

    @Autowired
    IPartidoRepository iPartidoRepository;

    @Override
    public PartidoDTO crearPartido(PartidoCrearDTO partidoCrearDto) {

        UsuarioEntity usuarioEntity = iUsuarioRepository.findByUserName(partidoCrearDto.getUserName());

        EquipoEntity equipoEntityLocal= iEquipoRepository.findById(partidoCrearDto.getEquipoLocal());

        EquipoEntity equipoEntityVisitante= iEquipoRepository.findById(partidoCrearDto.getEquipoVisitante());

        PartidoEntity partidoEntity= new PartidoEntity();
        partidoEntity.setPartidoId(UUID.randomUUID().toString());
        partidoEntity.setFecha(partidoCrearDto.getFecha());
        partidoEntity.setGolesLocal("0");
        partidoEntity.setGolesVisitante("0");
        partidoEntity.setUsuarioEntity(usuarioEntity);
        partidoEntity.setEquipoEntityLocal(equipoEntityLocal);
        partidoEntity.setEquipoEntityVisitante(equipoEntityVisitante);

        PartidoEntity partidoCreado= iPartidoRepository.save(partidoEntity);
     
        PartidoDTO partidoDto= modelmapper.map(partidoCreado, PartidoDTO.class);            
        
        return partidoDto;
    }

    @Override
    public List<PartidoDTO> obtenerUltimos() {
        
        List<PartidoEntity> partidoEntityList= iPartidoRepository.getUltimosPartidos();

        List<PartidoDTO> partidoDtoList=new ArrayList<>();

        for(PartidoEntity partidoEntity: partidoEntityList){
            PartidoDTO partidoDto=modelmapper.map(partidoEntity, PartidoDTO.class);
            partidoDtoList.add(partidoDto);
        }

        return partidoDtoList;
    }

    @Override
    public PartidoDTO obtenerPartido(String id) {

        PartidoEntity partidoEntity= iPartidoRepository.findByPartidoId(id);

        PartidoDTO postDto= modelmapper.map(partidoEntity, PartidoDTO.class);

        return postDto;
    }

    @Override
    public void eliminarPartido(String partidoId, long usuarioId) {
       
        PartidoEntity partidoEntity= iPartidoRepository.findByPartidoId(partidoId);

        if(partidoEntity.getUsuarioEntity().getId() != usuarioId){
            throw new  RuntimeException("No se puede realizar esta accion");
        }

        iPartidoRepository.delete(partidoEntity);        
    }

    @Override
    public PartidoDTO actualizarPartido(String partidoId, PartidoActualizarDTO partidoActualizarDto) {
        
        PartidoEntity partidoEntity = iPartidoRepository.findByPartidoId(partidoId);

        UsuarioEntity usuarioEntity= iUsuarioRepository.findByUserName(partidoActualizarDto.getUserName());

        if(partidoEntity.getUsuarioEntity().getId() != usuarioEntity.getId()){
            throw new RuntimeException("No se puede realizar esta acccion");
        }

        partidoEntity.setGolesLocal(partidoActualizarDto.getGolesLocal());
        partidoEntity.setGolesVisitante(partidoActualizarDto.getGolesVisitante());

        PartidoEntity partidoEntityActualizado= iPartidoRepository.save(partidoEntity);

        PartidoDTO partidoDto=modelmapper.map(partidoEntityActualizado, PartidoDTO.class);

        return partidoDto;
    }
    
}
