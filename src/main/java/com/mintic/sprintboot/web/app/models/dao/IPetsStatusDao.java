package com.mintic.sprintboot.web.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.mintic.sprintboot.web.app.models.entity.PetsStatus;


public interface IPetsStatusDao extends CrudRepository<PetsStatus, Long>{

	public PetsStatus findByName(String name);
}
