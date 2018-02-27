package com.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.Student;
import com.shop.repository.StudentRepository;
import com.shop.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentRepository studentRepository;
	
	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository=studentRepository;
	}

	@Override
	public void saveStudent(Student student) {
		studentRepository.save(student);
		
	}

	@Override
	public List<Student> findAllStudents() {
		return studentRepository.findAll();
	}
	
	

}
