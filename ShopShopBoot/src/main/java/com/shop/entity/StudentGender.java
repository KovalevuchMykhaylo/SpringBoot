package com.shop.entity;

public enum StudentGender {
	
	MALE("MALE"), FEMALE("FEMALE"), X("X");
	
	private String gender;

	public String getGender() {
		return gender;
	}

	private StudentGender(String gender) {
		this.gender = gender;
	}
	
}
