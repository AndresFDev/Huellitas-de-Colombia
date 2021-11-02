package com.mintic.sprintboot.web.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mintic.sprintboot.web.app.models.dao.IPetsSizeDao;
import com.mintic.sprintboot.web.app.models.entity.PetsSize;

@Service
public class PetsSizeServiceImpl implements IPetsSizeService{

	@Autowired
	private IPetsSizeDao petsSizeDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<PetsSize> findAll() {
		return (List<PetsSize>) petsSizeDao.findAll();
	}

	@Override
	@Transactional
	public void save(PetsSize petsType) {
		petsSizeDao.save(petsType);
	}

	@Override
	@Transactional(readOnly = true)
	public PetsSize findOne(Long id) {
		return petsSizeDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		petsSizeDao.deleteById(id);
	}

	@Override
	public PetsSize findByName(String name) {
		return petsSizeDao.findByName(name);
	}
}
