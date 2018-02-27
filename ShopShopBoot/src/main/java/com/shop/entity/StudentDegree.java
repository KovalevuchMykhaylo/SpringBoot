package com.shop.entity;

public enum StudentDegree {
	
	BACHELOR("BACHELOR"), MASTER("MASTER"), ASPIRANT("ASPIRANT");
	
	private String degree;

	public String getDegree() {
		return degree;
	}

	private StudentDegree(String degree) {
		this.degree = degree;
	}


}
