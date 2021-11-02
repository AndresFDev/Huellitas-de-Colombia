package com.mintic.sprintboot.web.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.mintic.sprintboot.web.app.models.entity.PetsBreed;

public interface IPetsBreedDao extends CrudRepository<PetsBreed, Long>{

	public PetsBreed findByName(String name);

}