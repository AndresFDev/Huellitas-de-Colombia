package com.mintic.sprintboot.web.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.mintic.sprintboot.web.app.models.entity.User;

public interface IUserDao extends CrudRepository<User, Long>{
	
	public User findByEmail(String email);
}