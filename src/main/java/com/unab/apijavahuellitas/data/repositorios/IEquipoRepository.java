package com.unab.apijavahuellitas.data.repositorios;

import com.unab.apijavahuellitas.data.entidades.EquipoEntity;

import org.springframework.data.repository.CrudRepository;

public interface IEquipoRepository extends CrudRepository<EquipoEntity, Long>{
    
    EquipoEntity findById(long id);
}
