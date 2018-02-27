package com.shop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shop.entity.Item;

@Controller
public class BaseController {

	@GetMapping("/")
	public String showHome(Model model) {
		
		return "base/home";
	}

	@GetMapping("/info")
	public String userInfo(Model model) {
		List<Item> item = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			Item fuck = new Item();
			fuck.setTitle("Bui" + i);
			item.add(fuck);
		}
		model.addAttribute("be", item);
		return "base/info";
	}
	
//	@GetMapping("/login")
	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login() {
		return "base/login";
	}
	
}

