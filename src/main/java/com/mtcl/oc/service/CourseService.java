package com.mtcl.oc.service;

import java.util.List;

import com.mtcl.oc.entity.Course;

public interface CourseService {

	List<Course> findByTeacherId(Integer id);

	List<Course> findAll();

}