package com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.shop.dto.filters.SimpleFilter;
import com.shop.entity.Category;

public interface CategoryService {
	
	List<Category> findAll();
	
	void delete(int id);

	void save(Category category);

	Category findOne(int id);
	
	Category findOne(String name);
	
	List<Category> findAllWhereParentNull();
	
	List<Category> findAllByParentNotNullAndHaveChildsTrue();
	
	List<Category> findAllWhereHaveChildsFalse();
	
	Page<Category> findPage(SimpleFilter filter, Pageable pageable);

}
