package com.mtcl.oc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtcl.oc.entity.Student;
import com.mtcl.oc.repository.StudentRepository;
import com.mtcl.oc.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> findByTeacherId(Integer id) {
		return studentRepository.findByTeacherId(id);
	}

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

}
