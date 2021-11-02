package com.mintic.sprintboot.web.app.models.services;

import java.util.List;

import com.mintic.sprintboot.web.app.models.entity.PetsStatus;

public interface IPetsStatusService {

	public List<PetsStatus> findAll();
	
	public void save(PetsStatus petsStatus);
	
	public PetsStatus findOne(Long id);

	public void delete(Long id);

	public PetsStatus findByName(String name);
}
