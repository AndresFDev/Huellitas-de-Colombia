package com.mintic.sprintboot.web.app.models.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mintic.sprintboot.web.app.models.dao.IPetDao;
import com.mintic.sprintboot.web.app.models.dao.IPostDao;
import com.mintic.sprintboot.web.app.models.entity.Pet;
import com.mintic.sprintboot.web.app.models.entity.Post;

@Service
public class PostServiceImpl implements IPostService{

	@Autowired
	private IPostDao postDao;

	@Autowired
	private IPetDao petDao;
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public List<Post> findAll() {
		return (List<Post>) postDao.findAll();
	}

	@Override
	@Transactional
	public void save(Post post) {
		postDao.save(post);
	}

	@Override
	@Transactional(readOnly = true)
	public Post findOne(Long id) {
		return postDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		postDao.deleteById(id);
	}

	@Override
	@Transactional
	public void savePet(Pet pet) {
		petDao.save(pet);
	}

	@Override
	@Transactional
	public Pet findOnePet(Long id) {
		Post post = postDao.findById(id).orElse(null);
		if(post == null){
			return null;
		}
		return post.getPet();
	}

	@Override
	public List<Post> findByFilter(String type, String status, String size, String breed) {
		String combination = "";
		
		List<Post> filterPost = null;
		
		// Combination Status : 1
		if(!status.equals("0")) {
			combination += "1";
		}
		
		// Combination Type : 2
		if(!type.equals("0")) {
			combination += "2";
		}
		
		// Combination Size : 3	
		if(!size.equals("0")) {
			combination += "3";
		}
		
		// Combination Breed : 4
		if(!breed.equals("0")) {
			combination += "4";
		}
		
		// Status : 1
		if(combination.equals("1"))
			filterPost = postDao.postfilterByStatus(status);
		
		//Type : 2
		if(combination.equals("2"))
			filterPost = postDao.postfilterByType(type);
		
		//Size : 3
		if(combination.equals("3"))
			filterPost = postDao.postfilterBySize(size);
		
		//Breed : 4
		if(combination.equals("4"))
			filterPost = postDao.postfilterByBreed(breed);
		
		// Status : 1 AND Type : 2
		if(combination.equals("12"))
			filterPost = postDao.postfilterByTypeANDStatus(type, status);
		
		// Status : 1 AND Size : 3	
		if(combination.equals("13"))
			filterPost = postDao.postfilterBySizeANDStatus(size, status);
		
		// Status : 1 AND Breed	:4
		if(combination.equals("14"))
			filterPost = postDao.postfilterByBreedANDStatus(breed, status);		
		
		// Type : 2 AND Breed : 4
		if(combination.equals("12"))
			filterPost = postDao.postfilterByTypeANDStatus(type, status);
		
		// Type : 2 AND Size : 3
		if(combination.equals("13"))
			filterPost = postDao.postfilterBySizeANDStatus(size, status);
		
		// Size : 3 AND Breed : 4
		if(combination.equals("14"))
			filterPost = postDao.postfilterBySizeANDBreed(size, type);

		
		// Status : 1 AND Type : 2 AND Size : 3
		if(combination.equals("123"))
			filterPost = postDao.postfilterByStatusANDTypeANDSize(status, type, size);		
		
		// Type : 2 AND Size : 3 AND Breed : 4
		if(combination.equals("234"))
			filterPost = postDao.postfilterByTypeANDSizeANDBreed(type, size, breed);
		
		// Status : 1 AND Size : 3 AND Breed : 4
		if(combination.equals("134"))
			filterPost = postDao.postfilterByStatusANDSizeANDBreed(status, size, breed);
		
		// Status : 1 AND Type : 2 AND Breed : 4
		if(combination.equals("124"))
			filterPost = postDao.postfilterByStatusANDTypeANDBreed(status, type, breed);
		
		/*@SuppressWarnings("unchecked")
		List<Post> query
	      = em.createNativeQuery(
	          "SELECT PO.* "
	          + "FROM posts AS PO "
	          + "INNER JOIN pets PE ON PO.id = PE.id "
	          + "WHERE PE.pet_breed_id = 13 AND PE.pet_size_id = 3 AND PE.pet_status_id = 2 AND PE.pet_type_id = 5 "
	          + "ORDER BY PO.create_at").getResultList();*/
		
	    return filterPost;
	}
	
}
