package com.unab.apijavahuellitas.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.unab.apijavahuellitas.data.entidades.PartidoEntity;
import com.unab.apijavahuellitas.data.entidades.UsuarioEntity;
import com.unab.apijavahuellitas.data.repositorios.IPartidoRepository;
import com.unab.apijavahuellitas.data.repositorios.IUsuarioRepository;
import com.unab.apijavahuellitas.shared.PartidoDTO;
import com.unab.apijavahuellitas.shared.UsuarioCrearDTO;
import com.unab.apijavahuellitas.shared.UsuarioDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    ModelMapper modelmapper;

    @Autowired
    IUsuarioRepository iUsuarioRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    IPartidoRepository iPartidoRepository;

    @Override
    public UsuarioDTO crearUsuario(UsuarioCrearDTO usuarioCrearDTO) {

        if(iUsuarioRepository.findByEmail(usuarioCrearDTO.getEmail()) != null){

            throw new RuntimeException("¡Este correo ya se encuentra registrado! Por favor suministre un correo diferente o inicia sesion");

        }
        
        if(iUsuarioRepository.findByUserName(usuarioCrearDTO.getUserName()) != null){

            throw new RuntimeException("¡Este usuario ya se encuentra registrado! Por favor suministre un correo diferente o inicia sesion");

        }

        UsuarioEntity usuarioEntityDTO = modelmapper.map(usuarioCrearDTO, UsuarioEntity.class);
        usuarioEntityDTO.setUserId(UUID.randomUUID().toString());
        usuarioEntityDTO.setEncryptedPassword(bCryptPasswordEncoder.encode(usuarioCrearDTO.getPassword()));

        UsuarioEntity usuarioEntitySave = iUsuarioRepository.save(usuarioEntityDTO);

        UsuarioDTO usuarioDTO = modelmapper.map(usuarioEntitySave, UsuarioDTO.class);

        return usuarioDTO;
    }
    
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        
        UsuarioEntity usuarioEntity= iUsuarioRepository.findByUserName(userName);

        if(usuarioEntity==null) {
            throw new UsernameNotFoundException(userName);
        }
        
        return new User(usuarioEntity.getUserName(), usuarioEntity.getEncryptedPassword(), new ArrayList<>());
    }

    @Override
    public UsuarioDTO obtenerUsuario(String userName) {

        UsuarioEntity usuarioEntity= iUsuarioRepository.findByUserName(userName);
        
        if(usuarioEntity==null){
            throw new UsernameNotFoundException(userName);
        }

        UsuarioDTO usuarioDTOObtenido= modelmapper.map(usuarioEntity, UsuarioDTO.class);

        return usuarioDTOObtenido;
    }

    @Override
    public List<PartidoDTO> obtenerUsuarioPartidos(String userName) {

        UsuarioEntity usuarioEntity= iUsuarioRepository.findByUserName(userName);
        
        List<PartidoEntity> PartidoEntityList=iPartidoRepository.getByUsuarioEntityIdOrderByCreatedAtDesc(usuarioEntity.getId());

        List<PartidoDTO> partidoDtoList = new ArrayList<PartidoDTO>();

        for(PartidoEntity partidoEntity : PartidoEntityList){
            PartidoDTO partidoDTO = modelmapper.map(partidoEntity, PartidoDTO.class);
            partidoDtoList.add(partidoDTO);
        }

        return partidoDtoList;
    }

}
