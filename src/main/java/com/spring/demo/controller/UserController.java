package com.spring.demo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.demo.entity.UserEntity;
import com.spring.demo.impl.UserServiceImpl;

@Controller
@RequestMapping("users")
public class UserController {
	
	private static final Log log = LogFactory.getLog(UserController.class);
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping("/")
	public ModelAndView usuarios() {
			
		userServiceImpl.findAll().forEach((e)-> {
			log.info("AAAAAAAAAAAAAAAAAAAAAAAA ->" + e.getNombre());
		});
		
		ModelAndView andView = new ModelAndView("listUsers");
		andView.addObject("listUsers", userServiceImpl.findAll());		
		return andView;
	}

	@GetMapping("userform")
	public ModelAndView formUser() {
		
		ModelAndView andView = new ModelAndView("userform");
		andView.addObject("user", new UserEntity());	
		return andView;
		
	}
	
	@PostMapping("adduser")
	public String addUser(@ModelAttribute(name = "user") UserEntity userEntity) {
		
		userServiceImpl.save(userEntity);	
		return "redirect:/users/";
	}
	
	@GetMapping("edit/{id}")
	public ModelAndView editUser(@PathVariable(name = "id") int id) {
		
		ModelAndView andView = new ModelAndView("useredit");
		andView.addObject("user", userServiceImpl.findById(id));
		return andView;
	}
	
	@PostMapping("update")
	public String update(@ModelAttribute(name = "user") UserEntity userEntity) {
		
		log.info("AAAAAAAAAA " + userEntity.getEdad() );

		userServiceImpl.save(userEntity);
		return "redirect:/users/";
		
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable(name = "id") int id, Model model) {
		
		userServiceImpl.deleteById(id);
		return "redirect:/users/";
	}
}
