package com.mintic.sprintboot.web.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mintic.sprintboot.web.app.models.dao.IPetsStatusDao;
import com.mintic.sprintboot.web.app.models.entity.PetsStatus;

@Service
public class PetsStatusServiceImpl implements IPetsStatusService {

	@Autowired
	private IPetsStatusDao petsStatusDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<PetsStatus> findAll() {
		return (List<PetsStatus>) petsStatusDao.findAll();
	}

	@Override
	@Transactional
	public void save(PetsStatus petsType) {
		petsStatusDao.save(petsType);
	}

	@Override
	@Transactional(readOnly = true)
	public PetsStatus findOne(Long id) {
		return petsStatusDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		petsStatusDao.deleteById(id);
	}

	@Override
	public PetsStatus findByName(String name) {
		return petsStatusDao.findByName(name);
	}

}
