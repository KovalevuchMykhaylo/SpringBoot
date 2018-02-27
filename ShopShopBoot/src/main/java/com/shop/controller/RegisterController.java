package com.shop.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.shop.entity.User;
import com.shop.service.UserService;
import com.shop.validators.UserValidator;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	private UserService userService;
	
	@InitBinder("user")
	protected void bind(WebDataBinder binder) {
		binder.setValidator(new UserValidator(userService));
	}
	
	@ModelAttribute("user")
	public User getForm() {
		return new User();
	}
	
	@GetMapping
	public String register(Model model) {
//		model.addAttribute("user", new User());
		return "base/register";
	}
	
	@PostMapping
	public String save(@ModelAttribute("user") @Valid User user, BindingResult br, Model model, SessionStatus status) {
		if(br.hasErrors()) {
			return register(model);
		}
		userService.saveAndEncode(user);
		return cancel(status);
	}
	
	@RequestMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/register";
	}

}
