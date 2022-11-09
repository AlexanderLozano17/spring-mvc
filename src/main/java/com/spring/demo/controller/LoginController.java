package com.spring.demo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.demo.model.CredencialesModel;

@Controller
@RequestMapping("login")
public class LoginController {
	
	private static Log log = LogFactory.getLog(LoginController.class);
	
	@GetMapping("/")
	public String redirectLogin() {
		return "redirect:/login/singIn";
	}
	
	@GetMapping("singIn")
	public String login(Model model, @RequestParam(name = "error", required = false) String error) {
		
		model.addAttribute("error", error);
		model.addAttribute("credenciales", new CredencialesModel());
		return "login";
	}
	
	@PostMapping("checkLogin")
	public String checkLogin(@ModelAttribute(name = "credenciales") CredencialesModel credenciales) {	
		
		if (credenciales.getUsuario().equals("paco") && credenciales.getPassword().equals("123456")) {
			return "redirect:/users/";
		}
		return "redirect:/login/singIn?error";
	}
}
