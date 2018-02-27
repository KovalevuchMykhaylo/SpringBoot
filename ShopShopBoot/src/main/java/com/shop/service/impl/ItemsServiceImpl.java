package com.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.Item;
import com.shop.repository.ItemsRepository;
import com.shop.service.ItemsService;

@Service
public class ItemsServiceImpl implements ItemsService{

	@Autowired
	private ItemsRepository repository;
	
	@Override
	public void save(Item item) {
		repository.save(item);
	}

	@Override
	public Item findOne(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public List<Item> findAll() {
		return repository.findAll();
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

}
