package com.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name="Student")
public class Student extends BaseEntity {
	
	@Column
	private String fullName;
	
	@Column
	private String country;
	
	@Column
	private int age;
	
	@Enumerated
	private StudentGender gender; 
	
	@Column
	private String email;
	
	@Enumerated
	private StudentDegree degree;
	
	@Column
	private String [] socialNetworks;
	
	@Column
	private String favouriteLanguage;
	
	@Column
	private String [] operationSystem;
	
	@Column
	private String workExp;
	
	@Enumerated
	private WorkQualification workQualification;
	
	@Column
	private String [] skills;
	
	@Column
	private String howUFoundUs;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public StudentGender getGender() {
		return gender;
	}

	public void setGender(StudentGender gender) {
		this.gender = gender;
	}

	public String getEamil() {
		return email;
	}

	public void setEamil(String eamil) {
		this.email = eamil;
	}

	public StudentDegree getDegree() {
		return degree;
	}

	public void setDegree(StudentDegree degree) {
		this.degree = degree;
	}

	public String[] getSocialNetworks() {
		return socialNetworks;
	}

	public void setSocialNetworks(String[] socialNetworks) {
		this.socialNetworks = socialNetworks;
	}

	public String getFavouriteLanguage() {
		return favouriteLanguage;
	}

	public void setFavouriteLanguage(String favouriteLanguage) {
		this.favouriteLanguage = favouriteLanguage;
	}

	public String[] getOperationSystem() {
		return operationSystem;
	}

	public void setOperationSystem(String[] operationSystem) {
		this.operationSystem = operationSystem;
	}

	public String getWorkExp() {
		return workExp;
	}

	public void setWorkExp(String workExp) {
		this.workExp = workExp;
	}

	public WorkQualification getWorkQualification() {
		return workQualification;
	}

	public void setWorkQualification(WorkQualification workQualification) {
		this.workQualification = workQualification;
	}

	public String[] getSkills() {
		return skills;
	}

	public void setSkills(String[] skills) {
		this.skills = skills;
	}

	public String getHowUFoundUs() {
		return howUFoundUs;
	}

	public void setHowUFoundUs(String howUFoundUs) {
		this.howUFoundUs = howUFoundUs;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	} 
	
}
