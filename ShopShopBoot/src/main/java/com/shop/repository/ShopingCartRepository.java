package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.ShopingCart;

public interface ShopingCartRepository extends JpaRepository<ShopingCart, Integer>{

}
