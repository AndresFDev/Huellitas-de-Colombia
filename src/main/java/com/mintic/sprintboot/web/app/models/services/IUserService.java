package com.mintic.sprintboot.web.app.models.services;

import java.util.List;

import com.mintic.sprintboot.web.app.models.entity.Role;
import com.mintic.sprintboot.web.app.models.entity.User;

public interface IUserService {

	public List<User> findAll();
	
	public void save(User user);
	
	public User findOne(Long id);

	public void delete(Long id);
	
	public void saveRole(Role role);

	public User findEmail(String email);
}
