package com.mintic.sprintboot.web.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mintic.sprintboot.web.app.models.dao.IPetsBreedDao;
import com.mintic.sprintboot.web.app.models.entity.PetsBreed;

@Service
public class PetsBreedServiceImpl implements IPetsBreedService{

	@Autowired
	private IPetsBreedDao petsBreedDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<PetsBreed> findAll() {
		return (List<PetsBreed>) petsBreedDao.findAll();
	}

	@Override
	@Transactional
	public void save(PetsBreed petsType) {
		petsBreedDao.save(petsType);
	}

	@Override
	@Transactional(readOnly = true)
	public PetsBreed findOne(Long id) {
		return petsBreedDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		petsBreedDao.deleteById(id);
	}

	@Override
	public PetsBreed findByName(String name) {
		return petsBreedDao.findByName(name);
	}
}
