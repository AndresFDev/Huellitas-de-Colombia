package com.mintic.sprintboot.web.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.mintic.sprintboot.web.app.models.entity.PetsType;

public interface IPetsTypeDao extends CrudRepository<PetsType, Long>{

	public PetsType findByName(String name);
}
