package com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.shop.dto.filters.SimpleFilter;
import com.shop.entity.Brand;

public interface BrandService {

	void save(Brand brand);
	
	Brand findOne(Integer id);
	
	List<Brand> findAll();
	
	Page<Brand> findPage(SimpleFilter filter, Pageable pageable);
	
	Brand findByName(String name);
	
	void delete(Integer id);
}
