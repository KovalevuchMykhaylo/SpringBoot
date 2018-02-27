package com.shop.controller.adminControllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.shop.entity.Item;
import com.shop.service.CategoryService;
import com.shop.service.ItemsService;

@Controller
@RequestMapping("/admin/itemForm")
@SessionAttributes("item")
public class ItemController {
	
	@Autowired
	private ItemsService itemsService;
	
	@Autowired
	private CategoryService categoryService; 
	
	@ModelAttribute("item")
	public Item getForm() {
		return new Item();
	}
	
	@GetMapping
	public String show(Model model) {
		model.addAttribute("categories", categoryService.findAll());
		return "admin/itemForm";
	}
	
	@GetMapping("/update/{id}")
	public String update(Model model, @PathVariable Integer id) {
		model.addAttribute("item", itemsService.findOne(id));
		return show(model);
	}
	
	@PostMapping
	public String save(@ModelAttribute("item")Item item, SessionStatus status) {
		if(item.getCreatedAt() == null) {
			item.setCreatedAt(new Date());
		}
		itemsService.save(item);
		status.setComplete();
		return"redirect:/user/itemView";
	}
	
	@GetMapping("/delete/{itemId}")
	public String delete(@PathVariable("itemId") Integer id) {
		itemsService.delete(id);
		return "redirect:/user/itemView";
	}
	

}
