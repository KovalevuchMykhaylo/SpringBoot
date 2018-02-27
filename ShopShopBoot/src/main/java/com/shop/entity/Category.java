package com.shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Category extends BaseEntity{
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Category parent;
	
	@OneToMany(mappedBy="parent")
	private List<Category> childs = new ArrayList<>();
	
	@Column(name = "have_childs")
	private boolean haveChilds;
	
	@Column
	private int level;
	
	@Column
	private String name;
	
	@OneToMany(mappedBy="category")
	private List<Item> items = new ArrayList<>();

	public boolean isHaveChilds() {
		return haveChilds;
	}

	public void setHaveChilds(boolean haveChilds) {
		this.haveChilds = haveChilds;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		if(parent!=null){
			setLevel(parent.level+1);
		}
		this.parent = parent;
	}

	public List<Category> getChilds() {
		return childs;
	}

	public void setChilds(List<Category> childs) {
		this.childs = childs;
	}
	
	
}
