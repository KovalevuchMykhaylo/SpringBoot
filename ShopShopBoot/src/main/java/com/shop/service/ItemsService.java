package com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.shop.dto.filters.SimpleFilter;
import com.shop.entity.Item;

public interface ItemsService {
	
	void save(Item item);
	
	Item findOne(Integer id);
	
	List<Item> findAll();
	
	Page<Item> findPage(SimpleFilter filter, Pageable pageable);

	void delete(Integer id);

	int findCount(int userId);

	List<Item> findAllByUserId(int userId);
	
	Page<Item> findAll(Pageable pageable);
}
