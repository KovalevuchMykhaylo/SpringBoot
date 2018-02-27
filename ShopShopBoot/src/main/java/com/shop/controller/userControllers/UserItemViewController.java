package com.shop.controller.userControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.service.ItemsService;

@Controller
@RequestMapping("/user/itemView")
public class UserItemViewController {
	
	@Autowired
	private ItemsService itemsService;
	
	@GetMapping
	public String show(Model model) {
		model.addAttribute("items", itemsService.findAll());
		return "user/itemView";
	}

}
