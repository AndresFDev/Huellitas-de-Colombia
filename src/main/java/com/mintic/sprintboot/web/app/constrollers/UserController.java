package com.mintic.sprintboot.web.app.constrollers;

import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mintic.sprintboot.web.app.models.entity.Role;
import com.mintic.sprintboot.web.app.models.entity.User;
import com.mintic.sprintboot.web.app.models.services.IUserService;

@Controller
@RequestMapping("/profile")
public class UserController {

	protected final Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Secured("ROLE_ADMIN")
	@GetMapping(value="/list")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de usuarios");
		model.addAttribute("users", userService.findAll());
		return "list";
	}
	
	@GetMapping(value = "/register")
	public String create(Map<String, Object> model) {
		User user = new User();
		model.put("titulo", "Registro de nuevo usuario");
		model.put("titleBanner", "Registro");
		model.put("user", user);
		model.put("edit", "0");
				
		return "register-user";
	}

	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(value="/edit/{id}")
	public String edit(@PathVariable(value="id") Long id, Map <String, Object> model, RedirectAttributes flash) {
		User user = null;
		if(id > 0) {
			user = userService.findOne(id);
			if(user == null) {
				flash.addFlashAttribute("danger", "Usuario no existe!");
				return "redirect:/index";
			}
		}
		else {
			flash.addFlashAttribute("danger", "Id del usuario no puede ser 0!");
			return "redirect:/index";
		}
		model.put("user", user);
		model.put("titulo", "Editar usuario");
		model.put("titleBanner", "Editar");
		model.put("edit", "1");
		return "register-user";
	}
	

	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(value="/view")
	public String view(Map <String, Object> model, RedirectAttributes flash) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findEmail(auth.getName());
		
		model.put("user", user);
		model.put("titulo", "Bienvenido "+user.getName());
		model.put("titleBanner", "Bienvenido "+user.getName());
		return "view-user";
	}
	
	@PostMapping(value="/register")
	public String save(@Valid User user, BindingResult result, Model model, RedirectAttributes flash) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Registro de nuevo usuario");
			return "register-user";
		}
		
		String mensajeFlash = (user.getId() != null)? "Usuario editado con exito!" : "Usuario registrado con éxito!";
		
		String bcryptPasword = passwordEncoder.encode(user.getPassword());
		user.setPassword(bcryptPasword);
		user.setEnable(true);
		userService.save(user);	

		Role role = new Role();
		role.setUser(user);
		role.setRole("ROLE_USER");		
		userService.saveRole(role);
						
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:/profile/view";
	}
	
}
