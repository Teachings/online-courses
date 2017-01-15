package com.mtcl.oc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtcl.oc.entity.Teacher;
import com.mtcl.oc.repository.TeacherRepository;
import com.mtcl.oc.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	TeacherRepository teacherRepository;

	@Override
	public Teacher findOne(Integer id) {
		return teacherRepository.findOne(id);
	}

	@Override
	public List<Teacher> findAll() {
		return teacherRepository.findAll();
	}
}
