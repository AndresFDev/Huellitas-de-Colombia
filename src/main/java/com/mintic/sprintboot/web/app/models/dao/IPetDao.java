package com.mintic.sprintboot.web.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.mintic.sprintboot.web.app.models.entity.Pet;

public interface IPetDao extends CrudRepository<Pet, Long>{

}
