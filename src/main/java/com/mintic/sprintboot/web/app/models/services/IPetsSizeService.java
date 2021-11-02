package com.mintic.sprintboot.web.app.models.services;

import java.util.List;

import com.mintic.sprintboot.web.app.models.entity.PetsSize;

public interface IPetsSizeService {

	public List<PetsSize> findAll();
	
	public void save(PetsSize post);
	
	public PetsSize findOne(Long id);

	public void delete(Long id);

	public PetsSize findByName(String name);
}
