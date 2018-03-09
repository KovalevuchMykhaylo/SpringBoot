package com.shop.controller.adminControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.service.ItemsService;

@Controller
@RequestMapping("/admin/itemView")
public class AdminItemViewController {
	
	@Autowired
	private ItemsService itemsService;
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable) {
		model.addAttribute("page", itemsService.findAll(pageable));
		return "admin/itemView";
	}

}
