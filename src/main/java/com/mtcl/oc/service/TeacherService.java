package com.mtcl.oc.service;

import java.util.List;

import com.mtcl.oc.entity.Teacher;

public interface TeacherService {

	Teacher findOne(Integer id);

	List<Teacher> findAll();

}