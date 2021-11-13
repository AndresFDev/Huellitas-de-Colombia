package com.devappron.backendjava.data.repositorios;

import com.devappron.backendjava.data.entidades.CiudadEntity;

import org.springframework.data.repository.CrudRepository;

public interface ICiudadRepository extends CrudRepository<CiudadEntity, Long>{
    
    CiudadEntity findById(long id);
}
