package com.shop.service;

import com.shop.entity.User;

public interface UserService {

	void save(User user);

	User findById(int id);
	
	void saveAndEncode(User user);
	
	User findByLogin(String login);
	
	void addToShoppingCart(int userId, int itemId);

	void removeToShoppingCart(int userId, int itemId);
	
	void removeAllToShoppingCart(int userId);

	int createNewUser();
	
	void sendMail(String content, String email, String mailBody);

}
