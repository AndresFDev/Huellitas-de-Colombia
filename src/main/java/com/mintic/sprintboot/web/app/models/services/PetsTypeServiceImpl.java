package com.mintic.sprintboot.web.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mintic.sprintboot.web.app.models.dao.IPetsTypeDao;
import com.mintic.sprintboot.web.app.models.entity.PetsType;

@Service
public class PetsTypeServiceImpl implements IPetsTypeService{

	@Autowired
	private IPetsTypeDao petsTypeDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<PetsType> findAll() {
		return (List<PetsType>) petsTypeDao.findAll();
	}

	@Override
	@Transactional
	public void save(PetsType petsType) {
		petsTypeDao.save(petsType);
	}

	@Override
	@Transactional(readOnly = true)
	public PetsType findOne(Long id) {
		return petsTypeDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		petsTypeDao.deleteById(id);
	}

	@Override
	public PetsType findByName(String name) {
		return petsTypeDao.findByName(name);
	}

}
