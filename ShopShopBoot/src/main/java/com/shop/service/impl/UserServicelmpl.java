package com.shop.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shop.entity.User;
import com.shop.entity.Role;
import com.shop.repository.UserRepository;
import com.shop.service.UserService;


@Service("userDetailsService")
public class UserServicelmpl implements UserService, UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public void save(User user) {
		userRepository.save(user);
		
	}

	@Override
	public User findById(int id) {
		return userRepository.findOne(id);
	}

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		UserDetails user = userRepository.findByLogin(arg0);
		if (user == null) {
            throw new UsernameNotFoundException(String.format("Username '%s' not found", arg0));
        }
		return user;
	}

	@Override
	public void saveAndEncode(User user) {
		user.setRole(Role.ROLE_USER);
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
	}
	
	@PostConstruct
	public void createAmin() {
		System.out.println("PostConstruct");
		if(userRepository.findByLogin("admin")==null) {
			User user = new User();
			user.setLogin("admin");
			user.setPassword(encoder.encode("admin"));
			user.setRole(Role.ROLE_ADMIN);
			userRepository.save(user);
		}
	}

	@Override
	public User findByLogin(String login) {
		return userRepository.findByLogin(login);
	}

}
