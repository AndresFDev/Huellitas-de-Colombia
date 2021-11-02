package com.mintic.sprintboot.web.app.constrollers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	protected final Log logger = LogFactory.getLog(this.getClass());

	@GetMapping({"/index", "/", "", "/home", "index"})
	public String index(Model model, Authentication authentication) {		
		if(authentication != null) {
			logger.info("Hola usuario "+authentication.getName());
		}
		model.addAttribute("titulo", "Inicio");		
		return "index";
	}
}
