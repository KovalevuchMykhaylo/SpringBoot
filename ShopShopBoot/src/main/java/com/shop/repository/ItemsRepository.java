package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Items;

public interface ItemsRepository extends JpaRepository<Items, Integer> {

}
