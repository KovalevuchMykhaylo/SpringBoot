package com.shop.service;

import java.util.List;

import com.shop.entity.Item;

public interface ItemsService {
	
	void save(Item item);
	
	Item findOne(Integer id);
	
	List<Item> findAll();

	void delete(Integer id);
}
