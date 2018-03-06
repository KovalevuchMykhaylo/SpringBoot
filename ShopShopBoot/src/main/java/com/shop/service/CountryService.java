package com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.shop.dto.filters.SimpleFilter;
import com.shop.entity.Country;

public interface CountryService {

	void save(Country country);
	
	Country findOne(Integer id);
	
	List<Country> findAll();
	
	void delete(Integer id);
	
	Page<Country> findPage(SimpleFilter filter, Pageable pageable);

	Country findByName(String name);

	Country findByShortName(String shortName);
}
