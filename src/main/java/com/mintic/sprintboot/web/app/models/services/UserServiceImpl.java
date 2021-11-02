package com.mintic.sprintboot.web.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mintic.sprintboot.web.app.models.dao.IRoleDao;
import com.mintic.sprintboot.web.app.models.dao.IUserDao;
import com.mintic.sprintboot.web.app.models.entity.Role;
import com.mintic.sprintboot.web.app.models.entity.User;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private  IRoleDao roleDao;

	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		return (List<User>) userDao.findAll();
	}

	@Override
	@Transactional
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	@Transactional(readOnly = true)
	public User findOne(Long id) {
		return userDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		userDao.deleteById(id);
	}

	@Override
	@Transactional
	public void saveRole(Role role) {
		roleDao.save(role);
	}

	@Override
	@Transactional(readOnly = true)
	public User findEmail(String email) {
		return userDao.findByEmail(email);
	}

}
