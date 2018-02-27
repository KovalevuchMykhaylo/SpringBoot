package com.shop.service;

import java.util.List;

import com.shop.entity.Student;

public interface StudentService {
	
void saveStudent (Student student);
	
	List<Student> findAllStudents();
	

}
