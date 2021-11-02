package com.mintic.sprintboot.web.app.models.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

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
		String where = "";
		if(!status.equals("0"))
			where += "PE.pet_status_id = "+status;
		
		if(!where.equals(""))
			where += " AND ";
		
		if(!type.equals("0"))
			where += "PE.pet_type_id = "+type;
		
		if(!where.equals(""))
			where += " AND ";
		
		if(!size.equals("0"))
			where += "PE.pet_size_id = "+size;
		
		if(!where.equals(""))
			where += " AND ";
		
		if(!breed.equals("0"))
			where += "PE.pet_breed_id = "+breed;
		
		@SuppressWarnings("unchecked")
		List<Post> query
	      = em.createNativeQuery(
	          "SELECT PO.* "
	          + "FROM posts AS PO "
	          + "INNER JOIN pets PE ON PO.id = PE.id "
	          + "WHERE PE.pet_breed_id = 13 AND PE.pet_size_id = 3 AND PE.pet_status_id = 2 AND PE.pet_type_id = 5 "
	          + "ORDER BY PO.create_at").getResultList();
		
	    return query;
	}
	
}
