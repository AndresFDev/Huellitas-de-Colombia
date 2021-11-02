package com.mintic.sprintboot.web.app.models.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "pets")
public class Pet implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	

	@Column(length = 100, nullable = false)
	@NotBlank
	private String name;
	
	@Column(length = 1000, nullable = false)
	@NotBlank
	private String description;
	
	@Column(length = 45, nullable = false)
	@NotBlank
	private String years;
	
	@Column(length = 45, nullable = false)
	@NotBlank
	private String color;
	
	@Column(length = 200)
	@NotBlank
	private String photo;

	//@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//private Post post;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private PetsSize petSize;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private PetsBreed petBreed;
	

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private PetsType petType;
	

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private PetsStatus petStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/*public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}*/

	public PetsSize getPetSize() {
		return petSize;
	}

	public void setPetSize(PetsSize petSize) {
		this.petSize = petSize;
	}

	public PetsBreed getPetBreed() {
		return petBreed;
	}

	public void setPetBreed(PetsBreed petBreed) {
		this.petBreed = petBreed;
	}

	public PetsType getPetType() {
		return petType;
	}

	public void setPetType(PetsType petType) {
		this.petType = petType;
	}

	public PetsStatus getPetStatus() {
		return petStatus;
	}

	public void setPetStatus(PetsStatus petStatus) {
		this.petStatus = petStatus;
	}
}
