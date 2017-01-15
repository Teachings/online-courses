package com.mtcl.oc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mtcl.oc.entity.Course;
import com.mtcl.oc.service.CourseService;


@Controller
public class CourseController {
	
	@Autowired
	CourseService cService;

	@RequestMapping("/courses")
	public String index(Model model) {
		Map<Integer, String> coursesMap = new HashMap<Integer, String>();


		List<Course> courseList = cService.findAll();
		for (Course s : courseList) {
			coursesMap.put(s.getCId(), s.getName());
		}

		// add student details to model
		model.addAttribute("coursesMap", coursesMap);		
		
		return "courses";
	}
}
