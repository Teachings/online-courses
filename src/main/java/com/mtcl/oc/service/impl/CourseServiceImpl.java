package com.mtcl.oc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtcl.oc.entity.Course;
import com.mtcl.oc.repository.CourseRepository;
import com.mtcl.oc.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository courseRepository;

	@Override
	public List<Course> findByTeacherId(Integer id) {
		return courseRepository.findByTeacherId(id);
	}

	@Override
	public List<Course> findAll() {
		return courseRepository.findAll();
	}

}
