package com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.shop.entity.Item;

public interface ItemsService {
	
	void save(Item item);
	
	Item findOne(Integer id);
	
	List<Item> findAll();
	
	Page<Item> findAll(Pageable pageable);

	void delete(Integer id);

	int findCount(int userId);

	List<Item> findByUserId(int userId);
}
