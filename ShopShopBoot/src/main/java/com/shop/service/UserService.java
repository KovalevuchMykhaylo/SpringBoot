package com.shop.service;

import com.shop.entity.User;

public interface UserService {

	void save(User user);

	User findById(int id);
	
	void saveAndEncode(User user);
	
	User findByLogin(String login);

}
