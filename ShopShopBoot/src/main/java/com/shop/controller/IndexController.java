package com.shop.controller;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shop.entity.Item;
import com.shop.service.ItemsService;
import com.shop.service.UserService;

@Controller
public class IndexController {
	
	@Autowired
	private ItemsService itemservice;
	
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String showHome(Model model, @CookieValue(defaultValue="0", name="userId") int id, HttpServletResponse response, @PageableDefault Pageable pageable) {
		if(id==0){
			id = userService.createNewUser();
			response.addCookie(new Cookie("userId", String.valueOf(id)));
		}
		model.addAttribute("page", itemservice.findAll(pageable));
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
	
	@GetMapping("/shopping")
	public String shopping(Model model, @CookieValue(defaultValue = "0", name = "userId") int userId) {
		BigDecimal totalPrice = new BigDecimal(0); 
		List<Item> items = itemservice.findAllByUserId(userId);
		for (Item item : items) { 
			totalPrice = totalPrice.add(item.getPrice()); 
		}
		model.addAttribute("totalPrice", totalPrice);
		model.addAttribute("items", items);
		System.out.println(totalPrice);
		return "user/shopping";
	}
	
	@GetMapping("/buy/{itemId}")
	public String buy(@CookieValue(defaultValue="0", name="userId") int userId, @PathVariable int itemId){
		userService.addToShoppingCart(userId, itemId);
		return "redirect:/";
	}
	
	@GetMapping("/del/{itemId}")
	public String remove(@CookieValue(defaultValue = "0", name = "userId") int userId, @PathVariable int itemId) {
		userService.removeToShoppingCart(userId, itemId);
		return "redirect:/shopping";
	}
	
	@GetMapping("/iNeedIt")
	public String iNeedIt(@CookieValue(defaultValue = "0", name = "userId") int userId, Principal principal) {
		userService.sendMail("ModelServo", principal.getName(), "You buy shit!!!");
		userService.removeAllToShoppingCart(userId);
		return "user/success";
	}
	
}

