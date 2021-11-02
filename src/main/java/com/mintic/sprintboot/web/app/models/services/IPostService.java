package com.mintic.sprintboot.web.app.models.services;

import java.util.List;

import com.mintic.sprintboot.web.app.models.entity.Pet;
import com.mintic.sprintboot.web.app.models.entity.Post;

public interface IPostService {

	public List<Post> findAll();
	
	public void save(Post post);
	
	public Post findOne(Long id);

	public void delete(Long id);
	
	public void savePet(Pet pet);

	public Pet findOnePet(Long id);
	
	public List<Post> findByFilter(String type, String status, String size, String breed);
	
}
