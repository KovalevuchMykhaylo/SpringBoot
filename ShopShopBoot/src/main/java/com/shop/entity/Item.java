package com.shop.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.shop.entity.User;

@Entity
@Table(name = "Items")
public class Item extends BaseEntity {
	
	@Column(name = "title", length = 100, unique = true)
	private String title;

	@Column(name = "description", length = 500)
	private String description;

	@Column(name = "price", columnDefinition = "DECIMAL(5,2)")
	private BigDecimal price;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	private Category category;
	
	@ManyToOne
	private Country countryProducer;
	
	@ManyToOne
	private Brand brand;
	
	@ManyToMany(mappedBy="items")
	private List<ShopingCart> shopingCarts = new ArrayList<>();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Country getCountryProducer() {
		return countryProducer;
	}

	public void setCountryProducer(Country countryProducer) {
		this.countryProducer = countryProducer;
	}

	public List<ShopingCart> getShopingCarts() {
		return shopingCarts;
	}

	public void setShopingCarts(List<ShopingCart> shopingCarts) {
		this.shopingCarts = shopingCarts;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Items [title=" + title + ", description=" + description + ", price=" + price + "]";
	}

}
