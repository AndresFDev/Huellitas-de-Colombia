package com.mintic.sprintboot.web.app.models.services;

import java.util.List;

import com.mintic.sprintboot.web.app.models.entity.PetsBreed;

public interface IPetsBreedService {

	public List<PetsBreed> findAll();
	
	public void save(PetsBreed petsBreed);
	
	public PetsBreed findOne(Long id);

	public void delete(Long id);

	public PetsBreed findByName(String name);

}
