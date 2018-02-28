package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shop.entity.Item;

public interface ItemsRepository extends JpaRepository<Item, Integer> {
	
	@Query("SELECT sc.count FROM User u JOIN u.shopingCart sc WHERE u.id=?1")
	Integer findCount(int id);

	List<Item> findByUserId(int userId);

}
