package com.mtcl.oc.service;

import java.util.List;

import com.mtcl.oc.entity.Student;

public interface StudentService {

	List<Student> findByTeacherId(Integer id);

	List<Student> findAll();

}