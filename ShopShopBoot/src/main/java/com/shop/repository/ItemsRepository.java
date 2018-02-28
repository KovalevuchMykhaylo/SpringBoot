package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shop.entity.Item;

public interface ItemsRepository extends JpaRepository<Item, Integer> {
	
	@Query("SELECT sc.count FROM User u JOIN u.shopingCart sc WHERE u.id=?1")
	Integer findCount(int id);
	
	@Query("SELECT i FROM Item i JOIN i.shopingCarts sc JOIN sc.users u WHERE u.id=?1")
	List<Item> findAllByUserId(int userId);

}
