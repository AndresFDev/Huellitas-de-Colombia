package com.mintic.sprintboot.web.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mintic.sprintboot.web.app.models.entity.Post;

public interface IPostDao extends CrudRepository<Post, Long> {
	
	@Query(value = "SELECT po.* FROM posts po INNER JOIN pets pe on po.id = pe.id WHERE PE.pet_status_id = :idStatus",
			nativeQuery = true)
	List<Post> postfilterByStatus(@Param("idStatus") String idStatus);
	
	@Query(value = "SELECT po.* FROM posts po INNER JOIN pets pe on po.id = pe.id WHERE PE.pet_type_id = :idType",
			nativeQuery = true)
	List<Post> postfilterByType(@Param("idType") String idType);
	
	@Query(value = "SELECT po.* FROM posts po INNER JOIN pets pe on po.id = pe.id WHERE PE.pet_breed_id = :idBreed",
			nativeQuery = true)
	List<Post> postfilterByBreed(@Param("idBreed") String idBreed);
	
	@Query(value = "SELECT po.* FROM posts po INNER JOIN pets pe on po.id = pe.id WHERE PE.pet_size_id = :idSize",
			nativeQuery = true)
	List<Post> postfilterBySize(@Param("idSize") String idSize);
	
	
	@Query(value = "SELECT po.* FROM posts po INNER JOIN pets pe on po.id = pe.id WHERE PE.pet_type_id = :idType AND PE.pet_status_id = :idStatus",
			nativeQuery = true)
	List<Post> postfilterByTypeANDStatus(@Param("idType") String idType, @Param("idStatus") String idStatus);
		
	@Query(value = "SELECT po.* FROM posts po INNER JOIN pets pe on po.id = pe.id WHERE PE.pet_breed_id = :idBreed AND PE.pet_status_id = :idStatus",
			nativeQuery = true)
	List<Post> postfilterByBreedANDStatus(@Param("idBreed") String idBreed, @Param("idStatus") String idStatus);
	
	@Query(value = "SELECT po.* FROM posts po INNER JOIN pets pe on po.id = pe.id WHERE PE.pet_size_id = :idSize AND PE.pet_status_id = :idStatus",
			nativeQuery = true)
	List<Post> postfilterBySizeANDStatus(@Param("idSize") String idSize, @Param("idStatus") String idStatus);	
	
	@Query(value = "SELECT po.* FROM posts po INNER JOIN pets pe on po.id = pe.id WHERE PE.pet_breed_id = :idBreed AND PE.pet_type_id = :idType",
			nativeQuery = true)
	List<Post> postfilterByBreedANDType(@Param("idBreed") String idBreed, @Param("idType") String idType);
	
	@Query(value = "SELECT po.* FROM posts po INNER JOIN pets pe on po.id = pe.id WHERE PE.pet_size_id = :idSize AND PE.pet_type_id = :idType",
			nativeQuery = true)
	List<Post> postfilterBySizeANDType(@Param("idSize") String idSize, @Param("idType") String idType);
	
	@Query(value = "SELECT po.* FROM posts po INNER JOIN pets pe on po.id = pe.id WHERE PE.pet_size_id = :idSize AND PE.pet_breed_id = :idBreed",
			nativeQuery = true)
	List<Post> postfilterBySizeANDBreed(@Param("idBreed") String idSize, @Param("idBreed") String idType);
	
	
	@Query(value = "SELECT po.* FROM posts po INNER JOIN pets pe on po.id = pe.id WHERE PE.pet_status_id = :idStatus AND PE.pet_type_id = :idType AND PE.pet_size_id = :idSize",
			nativeQuery = true)
	List<Post> postfilterByStatusANDTypeANDSize(@Param("idStatus") String idStatus, @Param("idType") String idType, @Param("idSize") String idSize);	
	
	@Query(value = "SELECT po.* FROM posts po INNER JOIN pets pe on po.id = pe.id WHERE PE.pet_status_id = :idStatus AND PE.pet_type_id = :idType AND PE.pet_breed_id = :idBreed",
			nativeQuery = true)
	List<Post> postfilterByStatusANDTypeANDBreed(@Param("idStatus") String idStatus, @Param("idType") String idType, @Param("idBreed") String idBreed);	
	
	@Query(value = "SELECT po.* FROM posts po INNER JOIN pets pe on po.id = pe.id WHERE PE.pet_status_id = :idStatus AND PE.pet_size_id = :idSize AND PE.pet_breed_id = :idBreed",
			nativeQuery = true)
	List<Post> postfilterByStatusANDSizeANDBreed(@Param("idStatus") String idStatus, @Param("idSize") String idSize, @Param("idBreed") String idBreed);
	
	@Query(value = "SELECT po.* FROM posts po INNER JOIN pets pe on po.id = pe.id WHERE PE.pet_type_id = :idType AND PE.pet_size_id = :idSize AND PE.pet_breed_id = :idBreed",
			nativeQuery = true)
	List<Post> postfilterByTypeANDSizeANDBreed(@Param("idBreed") String idType, @Param("idSize") String idSize, @Param("idBreed") String idBreed);
	
	
	@Query(value = "SELECT po.* FROM posts po INNER JOIN pets pe on po.id = pe.id WHERE PE.pet_status_id = :idStatus AND PE.pet_type_id = :idType AND PE.pet_size_id = :idSize AND PE.pet_breed_id = :idBreed",
			nativeQuery = true)
	List<Post> postfilterByStatusANDTypeANDSizeANDBreed(@Param("idStatus") String idStatus, @Param("idBreed") String idBreed, @Param("idSize") String idSize, @Param("idType") String idType);
}
