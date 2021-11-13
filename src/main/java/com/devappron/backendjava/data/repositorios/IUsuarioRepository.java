package com.devappron.backendjava.data.repositorios;

import com.devappron.backendjava.data.entidades.UsuarioEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends CrudRepository<UsuarioEntity, Long>{
    
    public UsuarioEntity findByEmail(String email);
    public UsuarioEntity findByUserName(String userName);
    public UsuarioEntity findByUserId(String userId);

}

