package com.unab.apijavahuellitas.data.repositorios;

import com.unab.apijavahuellitas.data.entidades.UsuarioEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends CrudRepository<UsuarioEntity, Long>{

    public UsuarioEntity findByEmail(String email);
    public UsuarioEntity findByUserName(String userName);
        
}