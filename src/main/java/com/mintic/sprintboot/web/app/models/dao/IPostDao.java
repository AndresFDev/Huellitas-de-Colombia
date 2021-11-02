package com.mintic.sprintboot.web.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.mintic.sprintboot.web.app.models.entity.Post;

public interface IPostDao  extends CrudRepository<Post, Long>{

}
