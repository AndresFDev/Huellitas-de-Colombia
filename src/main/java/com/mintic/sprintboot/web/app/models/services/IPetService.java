package com.mintic.sprintboot.web.app.models.services;

import java.util.List;

import com.mintic.sprintboot.web.app.models.entity.Pet;

public interface IPetService {

	public List<Pet> findAll();
	
	public void save(Pet pet);
	
	public Pet findOne(Long id);

	public void delete(Long id);
}
