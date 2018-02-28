package com.shop.controller.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.shop.dto.Quantity;
import com.shop.service.ItemsService;

@ControllerAdvice
public class ShoppingController {
	
	@Autowired
	private ItemsService itemsService;
	
	@ModelAttribute("quantity")
	public Quantity getQuantity(@CookieValue(defaultValue="0", name="userId") int userId){
		int count = itemsService.findCount(userId);
		return new Quantity(count);
	}
}
