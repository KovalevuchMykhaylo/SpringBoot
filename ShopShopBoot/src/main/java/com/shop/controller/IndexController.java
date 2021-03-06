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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.entity.Item;
import com.shop.entity.User;
import com.shop.service.ItemsService;
import com.shop.service.UserService;
import com.shop.util.UserUtil;

@Controller
public class IndexController {
	
	@Autowired
	private ItemsService itemservice;
	
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String index(Model model, @CookieValue(defaultValue="0", name="userId") int id, HttpServletResponse response, @PageableDefault Pageable pageable) {
		User user = UserUtil.getSignedUpUser();
		if(user!=null) {
			id = user.getId();
		}
		response.addCookie(new Cookie("userId", String.valueOf(id)));
//		if(id==0){
//			id = userService.createNewUser();
//			response.addCookie(new Cookie("userId", String.valueOf(id)));
//		}
		model.addAttribute("page", itemservice.findAll(pageable));
		return "base/index";
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
	
	@RequestMapping("/login")
	public String login() {
		return "base/login";
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/shopping")
	public String shopping(Model model, @CookieValue(defaultValue = "0", name = "userId") int userId) {
		BigDecimal totalPrice = new BigDecimal(0); 
		List<Item> items = itemservice.findAllByUserId(userId);
		for (Item item : items) { 
			totalPrice = totalPrice.add(item.getPrice()); 
		}
		model.addAttribute("totalPrice", totalPrice);
		model.addAttribute("items", items);
		return "user/shopping";
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/buy/{itemId}")
	public String buy(@CookieValue(defaultValue="0", name="userId") int userId, @PathVariable int itemId){
		userService.addToShoppingCart(userId, itemId);
		return "redirect:/";
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/del/{itemId}")
	public String remove(@CookieValue(defaultValue = "0", name = "userId") int userId, @PathVariable int itemId) {
		userService.removeToShoppingCart(userId, itemId);
		return "redirect:/shopping";
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/iNeedIt")
	public String iNeedIt(@CookieValue(defaultValue = "0", name = "userId") int userId, Principal principal) {
		userService.sendMail("ModelServo", principal.getName(), "You buy shit!!!");
		userService.removeAllToShoppingCart(userId);
		return "user/success";
	}
	
	@GetMapping("/about")
	public String about() {
		return "base/about";
	}
	
}

