package com.shop.service.impl;

import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shop.entity.User;
import com.shop.entity.Item;
import com.shop.entity.Role;
import com.shop.entity.ShopingCart;
import com.shop.repository.ItemsRepository;
import com.shop.repository.ShopingCartRepository;
import com.shop.repository.UserRepository;
import com.shop.service.UserService;

@Service("userDetailsService")
public class UserServicelmpl implements UserService, UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ShopingCartRepository shopingCartRepository; 
	
	@Autowired
	private ItemsRepository itemRepository;
	
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
	
	@Override
	@Transactional
	public void addToShoppingCart(int userId, int itemId) {
		User user = userRepository.findOne(userId);
		ShopingCart cart = user.getShopingCart();
		if(cart==null){
			cart = shopingCartRepository.save(new ShopingCart());
			user.setShopingCart(cart);
		}
		Item item = itemRepository.findOne(itemId);
		cart.add(item);
	}
	
	@Override
	@Transactional
	public void removeToShoppingCart(int userId, int itemId) {
		User user = userRepository.findOne(userId);
		ShopingCart cart = user.getShopingCart();
		Item item = itemRepository.findOne(itemId);
		cart.remove(item);
	}
	
	@Override
	@Transactional
	public void removeAllToShoppingCart(int userId) {
		User user = userRepository.findOne(userId);
		ShopingCart cart = user.getShopingCart();
		List<Item> modelServo = itemRepository.findAll();
		cart.removeAll(modelServo);
	}

	@Override
	public int createNewUser() {
		return userRepository.saveAndFlush(new User()).getId();
	}
	
	@Override
	public void sendMail(String content, String email, String mailBody) {
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.port", "465");
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.setProperty("mail.smtp.socketFactory.port", "465");
		properties.setProperty("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		Session session = Session.getDefaultInstance(properties,
				new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								"USEREMAIL", "PASSWORD");
					}
				});
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("USEREMAIL"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					email));
			message.setSubject(content, "UTF-8");
			message.setText(mailBody);
			Transport.send(message);
		} catch (MessagingException е) {
			е.printStackTrace();
		}
	}

}
