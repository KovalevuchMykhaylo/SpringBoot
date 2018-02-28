package com.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	@Override
	public int findCount(int id) {
		Integer count = repository.findCount(id);
		if(count==null)return 0;
		return count;
	}

	@Override
	public Page<Item> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public List<Item> findAllByUserId(int userId) {
		return repository.findAllByUserId(userId);
	}

}
