package com.shop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.Category;
import com.shop.repository.CategoryRepository;
import com.shop.service.CategoryService;

@Service
public class CategoryServiceImplmpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	@Transactional
	public List<Category> findAll() {
		List<Category> parents = categoryRepository.findByParentIsNull();
		initChild(parents);
		return parents;
	}
	
	private void initChild(List<Category> parents){
		for (Category category : parents) {
			Hibernate.initialize(category.getChilds());
			initChild(category.getChilds());
		}
	}

	@Override
	public void delete(int id) {
		categoryRepository.delete(id);
	}

	@Override
	public void save(Category category) {
		categoryRepository.save(category);
		categoryRepository.validHaveChilds();
	}

	@Override
	public Category findOne(int id) {
		return categoryRepository.findOne(id);
	}

	@Override
	public Category findOne(String name) {
		return categoryRepository.findByName(name);
	}

}
