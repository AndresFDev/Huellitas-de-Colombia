package com.mintic.sprintboot.web.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.mintic.sprintboot.web.app.models.dao.IPetDao;
import com.mintic.sprintboot.web.app.models.entity.Pet;


public class PetServiceImpl implements IPetService{

	@Autowired
	private IPetDao petsDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Pet> findAll() {
		return (List<Pet>) petsDao.findAll();
	}

	@Override
	@Transactional
	public void save(Pet petDao) {
		petsDao.save(petDao);
	}

	@Override
	@Transactional(readOnly = true)
	public Pet findOne(Long id) {
		return petsDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		petsDao.deleteById(id);
	}

}
