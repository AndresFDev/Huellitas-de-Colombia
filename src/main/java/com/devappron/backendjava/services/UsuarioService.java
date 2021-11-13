package com.devappron.backendjava.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.devappron.backendjava.data.entidades.EntradaEntity;
import com.devappron.backendjava.data.entidades.UsuarioEntity;
import com.devappron.backendjava.data.repositorios.IEntradaRepository;
import com.devappron.backendjava.data.repositorios.IUsuarioRepository;
import com.devappron.backendjava.errors.UsuarioExisteException;
import com.devappron.backendjava.shared.EntradaDto;
import com.devappron.backendjava.shared.UsuarioActualizarDto;
import com.devappron.backendjava.shared.UsuarioCrearDto;
import com.devappron.backendjava.shared.UsuarioDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService{ 

    @Autowired
    ModelMapper modelmapper;

    @Autowired
    IUsuarioRepository iUsuarioRepository; 

    @Autowired
    BCryptPasswordEncoder bcryptPasswordEncoder;

    @Autowired
    IEntradaRepository iEntradaRepository; 


    @Override
    public UsuarioDto crearUsuario(UsuarioCrearDto usuarioCrearDto) {

        if(iUsuarioRepository.findByEmail(usuarioCrearDto.getEmail()) != null){
            throw new UsuarioExisteException("Este correo ya se encuentra registrado");
        }

        if(iUsuarioRepository.findByUserName(usuarioCrearDto.getUserName()) != null){
            throw new UsuarioExisteException("Este nombre de usuario ya esta en uso");
        }
         
         
        UsuarioEntity usuarioEntityDto = modelmapper.map(usuarioCrearDto, UsuarioEntity.class);
        usuarioEntityDto.setEncryptedPassword(bcryptPasswordEncoder.encode(usuarioCrearDto.getPassword()));
        usuarioEntityDto.setUserId(UUID.randomUUID().toString());

        UsuarioEntity usuarioEntitySave = iUsuarioRepository.save(usuarioEntityDto);
        
        UsuarioDto usuarioDto = modelmapper.map(usuarioEntitySave, UsuarioDto.class);
      
        return usuarioDto;
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        
        UsuarioEntity usuarioEntity = iUsuarioRepository.findByUserName(userName);

        if(usuarioEntity==null) {
            throw new UsernameNotFoundException(userName);
        }
        
        return new User(usuarioEntity.getUserName(), usuarioEntity.getEncryptedPassword(), new ArrayList<>());
    }

    @Override
    public UsuarioDto obtenerUsuario(String userName) {

        UsuarioEntity usuarioEntity = iUsuarioRepository.findByUserName(userName);
        
        if(usuarioEntity==null){
            throw new UsernameNotFoundException(userName);
        }

        UsuarioDto usuarioDtoObtenido = modelmapper.map(usuarioEntity, UsuarioDto.class);

        return usuarioDtoObtenido;
    }

    @Override
    public UsuarioDto actualizarUsuario(String userId, UsuarioActualizarDto usuarioActualizarDto) {
        
        UsuarioEntity usuarioEntity = iUsuarioRepository.findByUserId(userId);

        if(usuarioEntity.getUserId() != usuarioEntity.getUserId()){
            throw new RuntimeException("No se puede realizar esta acccion");
        }

        usuarioEntity.setUserName(usuarioActualizarDto.getUserName());
        usuarioEntity.setNombre(usuarioActualizarDto.getNombre());
        usuarioEntity.setEmail(usuarioActualizarDto.getEmail());
        usuarioEntity.setPhone(usuarioActualizarDto.getPhone());

        UsuarioEntity usuarioEntityActualizado = iUsuarioRepository.save(usuarioEntity);

        UsuarioDto usuarioDto = modelmapper.map(usuarioEntityActualizado, UsuarioDto.class);

        return usuarioDto;
    }

    @Override
    public List<EntradaDto> obtenerUsuarioEntradas(String userName) {

        UsuarioEntity usuarioEntity = iUsuarioRepository.findByUserName(userName);
        
        List<EntradaEntity> EntradaEntityList = iEntradaRepository.getByUsuarioEntityIdOrderByCreatedAtDesc(usuarioEntity.getId());

        List<EntradaDto> entradaDtoList = new ArrayList<EntradaDto>();

        for(EntradaEntity entradaEntity : EntradaEntityList){
            EntradaDto entradaDto = modelmapper.map(entradaEntity, EntradaDto.class);
            entradaDtoList.add(entradaDto);
        }

        return entradaDtoList;
    }

    // @Override
    // public UsuarioDto obtenerUsuarioUsuarios(String id) {

    //     UsuarioEntity usuarioEntity = iUsuarioRepository.findByUserId(id);
    
    //     UsuarioDto userDto = modelmapper.map(usuarioEntity, UsuarioDto.class);

    //     return userDto;
    // }
    
}
