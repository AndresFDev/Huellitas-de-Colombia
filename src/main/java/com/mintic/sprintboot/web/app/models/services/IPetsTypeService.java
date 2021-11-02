package com.mintic.sprintboot.web.app.models.services;

import java.util.List;

import com.mintic.sprintboot.web.app.models.entity.PetsType;

public interface IPetsTypeService {

	public List<PetsType> findAll();
	
	public void save(PetsType petsType);
	
	public PetsType findOne(Long id);

	public void delete(Long id);

	public PetsType findByName(String name);
}
