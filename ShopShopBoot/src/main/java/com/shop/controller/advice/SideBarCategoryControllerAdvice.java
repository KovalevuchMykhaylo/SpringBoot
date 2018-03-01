package com.shop.controller.advice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.shop.entity.Category;
import com.shop.service.CategoryService;

@ControllerAdvice
public class SideBarCategoryControllerAdvice {
	
	@Autowired
	private CategoryService categoryService;
	
	@ModelAttribute("sideBarCategotyChildFalse")
	public List<Category> getSideCategory(){
		return categoryService.findAllWhereHaveChildsFalse();		
	}
	
	@ModelAttribute("sideBarCategotyParentNotNullAndHaveChildsTrue")
	public List<Category> findAllByParentNotNullAndHaveChildsTrue(){
		return categoryService.findAllByParentNotNullAndHaveChildsTrue();		
	}
	
	@ModelAttribute("sideBarCategotyParentNull")
	public List<Category> getSideCategoryParentNull(){
		return categoryService.findAllWhereParentNull();		
	}
	
	@ModelAttribute("allCategorySide")
	public List<Category> getAllSideCategory(){
		return categoryService.findAll();		
	}

}
