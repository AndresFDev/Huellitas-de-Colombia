package com.mintic.sprintboot.web.app.constrollers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mintic.sprintboot.web.app.models.entity.Pet;
import com.mintic.sprintboot.web.app.models.entity.PetsBreed;
import com.mintic.sprintboot.web.app.models.entity.PetsSize;
import com.mintic.sprintboot.web.app.models.entity.PetsStatus;
import com.mintic.sprintboot.web.app.models.entity.PetsType;
import com.mintic.sprintboot.web.app.models.entity.Post;
import com.mintic.sprintboot.web.app.models.entity.User;
import com.mintic.sprintboot.web.app.models.services.IPetsBreedService;
import com.mintic.sprintboot.web.app.models.services.IPetsSizeService;
import com.mintic.sprintboot.web.app.models.services.IPetsStatusService;
import com.mintic.sprintboot.web.app.models.services.IPetsTypeService;
import com.mintic.sprintboot.web.app.models.services.IPostService;
import com.mintic.sprintboot.web.app.models.services.IUserService;

@Controller
@RequestMapping("/post")
public class PostController {

	protected final Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private IPostService postService;

	@Autowired
	private IPetsTypeService petsTypeService;

	@Autowired
	private IPetsBreedService petsBreedService;

	@Autowired
	private IPetsSizeService petsSizeService;

	@Autowired
	private IPetsStatusService petsStatusService;

	@Autowired
	private IUserService userService;

	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(value = "/new")
	public String create(Map<String, Object> model) {

		Post post = new Post();

		model.put("post", post);
		model.put("petsType", petsTypeService.findAll());
		model.put("petsBreed", petsBreedService.findAll());
		model.put("petsSize", petsSizeService.findAll());
		model.put("petsStatus", petsStatusService.findAll());

		model.put("titulo", "Registro de nueva mascota");
		model.put("titleBanner", "Me conoces?");

		return "new-post";
	}

	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		Post post = null;
		if(id > 0) {
			post = postService.findOne(id);
			if(post == null) {
				flash.addFlashAttribute("danger", "Post no existe!");
				return "redirect:/index";
			}
		}
		else {
			flash.addFlashAttribute("danger", "Id del post no puede ser 0!");
			return "redirect:/index";
		}
		
		model.put("post", post);
		model.put("petsType", petsTypeService.findAll());
		model.put("petsBreed", petsBreedService.findAll());
		model.put("petsSize", petsSizeService.findAll());
		model.put("petsStatus", petsStatusService.findAll());
		
		logger.info("El getPetType vale "+post.getPet().getPetType().getId());
		model.put("petsTypeID", post.getPet().getPetType().getId());
		model.put("petsBreedID", post.getPet().getPetBreed().getId());
		model.put("petsSizeID", post.getPet().getPetSize().getId());
		model.put("petsStatusID", post.getPet().getPetStatus().getId());

		model.put("titulo", "Registro de nueva mascota");
		model.put("titleBanner", "Me conoces?");

		return "new-post";
	}

	@PostMapping(value = "/save")
	public String save(@Valid Post post, BindingResult result, Model model,
			HttpServletRequest allParams,
			@RequestParam("file") MultipartFile foto, RedirectAttributes flash) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Registro de nueva mascota");
			return "new-post";
		}

		Pet pet = null;
		if(post.getId() == null) {
			pet = post.getPet();
		}
		else {
			pet = postService.findOnePet(post.getId());			
		}
		
		if (!foto.isEmpty()) {
			Path directoryRequest = Paths.get("src//main//resources//static/uploads");
			String rootPath = directoryRequest.toFile().getAbsolutePath();
			try {
				byte[] bytes = foto.getBytes();
				Path routeFull = Paths.get(rootPath + "//" + foto.getOriginalFilename());
				Files.write(routeFull, bytes);
				flash.addFlashAttribute("info", "Foto subida correctamente");
				pet.setPhoto(foto.getOriginalFilename());
			} catch (IOException e) {
				flash.addFlashAttribute("danger", "Fallo la subida de foto");
				e.printStackTrace();
			}
		}
		String mensajeFlash = (post.getId() != null) ? "Mascota editada con exito!" : "Mascota registrada con éxito!";
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findEmail(auth.getName());
		post.setUser(user);

		//pet.setPost(post);
		boolean band = false;

		String getPetType = allParams.getParameter("petType");
		if(getPetType == null) {
			flash.addFlashAttribute("danger", "El tipo de la mascota no existe!");
			band = true;
		}
		else {
			PetsType petsType = petsTypeService.findOne(Long.valueOf(getPetType.trim()));
			pet.setPetType(petsType);
		}				
		
		String getPetStatus = allParams.getParameter("petStatus");
		if(getPetStatus == null) {
			flash.addFlashAttribute("danger", "El Status de la mascota no existe!");
			band = true;
		}
		else {
			PetsStatus petsStatus = petsStatusService.findOne(Long.valueOf(getPetStatus.trim()));
			pet.setPetStatus(petsStatus);
		}

		String getPetSize = allParams.getParameter("petSize");
		if(getPetSize == null) {
			flash.addFlashAttribute("danger", "El Tamano de la mascota no existe!");
			band = true;
		}
		else {
			PetsSize petsSize = petsSizeService.findOne(Long.valueOf(getPetSize.trim()));
			pet.setPetSize(petsSize);
		}

		String getPetBreed = allParams.getParameter("petBreed");
		if(getPetBreed == null) {
			flash.addFlashAttribute("danger", "La raza de la mascota no existe!");
			band = true;
		}
		else {
			PetsBreed petsBreed = petsBreedService.findOne(Long.valueOf(getPetBreed.trim()));
			pet.setPetBreed(petsBreed);
		}
		
		if(band) {
			model.addAttribute("post", post);
			model.addAttribute("petsType", petsTypeService.findAll());
			model.addAttribute("petsBreed", petsBreedService.findAll());
			model.addAttribute("petsSize", petsSizeService.findAll());
			model.addAttribute("petsStatus", petsStatusService.findAll());
			return "new-post";
		}
		post.setPet(pet);
		postService.save(post);
		postService.savePet(pet);

		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:/";
	}

	@GetMapping(value = "list")
	public String list(Model model, HttpServletRequest allParams) {
		
		PetsStatus petsStatus = null;
		PetsType petsType = null;
		PetsSize petsSize = null;
		PetsBreed petsBreed = null;
		Boolean band = false;
		List<Post> postList;
		
		String getPetType = allParams.getParameter("type");		
		if(getPetType != null) {
			petsType = petsTypeService.findOne(Long.valueOf(getPetType.trim()));
			band = true;
		}				
		
		String getPetStatus = allParams.getParameter("status");
		logger.info("El getPetStatus vale "+getPetStatus);
		if(getPetStatus != null) {
			petsStatus = petsStatusService.findByName(getPetStatus);
			band = true;
			//logger.info("El getPetStatus tiene id "+petsStatus.getId());
		}

		String getPetSize = allParams.getParameter("size");
		if(getPetSize != null) {
			petsSize = petsSizeService.findOne(Long.valueOf(getPetSize.trim()));
			band = true;
		}

		String getPetBreed = allParams.getParameter("breed");
		if(getPetBreed != null) {
			petsBreed = petsBreedService.findOne(Long.valueOf(getPetBreed.trim()));
			band = true;
		}
		if(!band)
			postList = postService.findAll();
		else {
			postList = postService.findByFilter((getPetType != null)?getPetType:"0", (getPetStatus != null)?getPetStatus:"0", (getPetSize != null)?getPetSize:"0", (getPetBreed != null)?getPetSize:"0");
			
		}
		
		if(postList.isEmpty())
			model.addAttribute("warning", "No hay anuncios disponibles");
		
		model.addAttribute("posts", postList);
		model.addAttribute("titulo", "Registro de nueva mascota");
		model.addAttribute("titleBanner", "Me conoces?");

		model.addAttribute("petsType", petsTypeService.findAll());
		model.addAttribute("petsBreed", petsBreedService.findAll());
		model.addAttribute("petsSize", petsSizeService.findAll());
		model.addAttribute("petsStatus", petsStatusService.findAll());
		return "list";
	}
	

	@PostMapping(value = "/filter")
	public String filter(@Valid Post post, BindingResult result, Model model,
			HttpServletRequest allParams, RedirectAttributes flash) {

		String base = "?";

		String getPetType = allParams.getParameter("petType");
		if(getPetType != null && !getPetType.equals("0")) {
			PetsType petsType = petsTypeService.findOne(Long.valueOf(getPetType.trim()));
			base += "type="+petsType.getName();
		}			
		
		String getPetStatus = allParams.getParameter("petStatus");
		if(getPetStatus != null && !getPetStatus.equals("0")) {
			if(base != "?")
				base += "&";
			PetsStatus petsStatus = petsStatusService.findOne(Long.valueOf(getPetStatus.trim()));
			base += "status="+petsStatus.getName();
		}

		String getPetSize = allParams.getParameter("petSize");
		if(getPetSize != null && !getPetSize.equals("0")) {
			if(base != "?")
				base += "&";
			PetsSize petsSize = petsSizeService.findOne(Long.valueOf(getPetSize.trim()));
			base += "size="+petsSize.getName();
		}

		String getPetBreed = allParams.getParameter("petBreed");
		if(getPetBreed != null && !getPetBreed.equals("0")) {
			if(base != "?")
				base += "&";
			PetsBreed petsBreed = petsBreedService.findOne(Long.valueOf(getPetBreed.trim()));
			base += "breed="+petsBreed.getName();
		}
		if(base != "?")
			return "redirect:/post/list"+base;
		else
			return "redirect:/post/list";
	}
}
