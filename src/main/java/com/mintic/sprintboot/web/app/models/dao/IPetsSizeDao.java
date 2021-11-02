package com.mintic.sprintboot.web.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.mintic.sprintboot.web.app.models.entity.PetsSize;

public interface IPetsSizeDao extends CrudRepository<PetsSize, Long>{

	public PetsSize findByName(String name);
}
