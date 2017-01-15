package com.mtcl.oc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mtcl.oc.service.CourseService;
import com.mtcl.oc.service.StudentService;
import com.mtcl.oc.service.TeacherService;

@Controller
public class IndexController {

	@Autowired
	TeacherService tService;
	
	@Autowired
	StudentService sService;
	
	@Autowired
	CourseService cService;

	@RequestMapping(value = { "/", "/index" })
	public String index(Model model) {

		//add counts of teachers, students and courses to the model 
		model.addAttribute("tCount", tService.findAll().size());
		model.addAttribute("sCount", sService.findAll().size());
		model.addAttribute("cCount", cService.findAll().size());
		
		return "index";
	}
}
