package com.mtcl.oc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mtcl.oc.entity.Student;
import com.mtcl.oc.service.StudentService;


@Controller
public class StudentController {
	
	@Autowired
	StudentService sService;

	@RequestMapping("/students")
	public String index(Model model) {
		Map<Integer, String> studentsMap = new HashMap<Integer, String>();

		List<Student> studentList = sService.findAll();
		for (Student s : studentList) {
			studentsMap.put(s.getSId(), s.getName());
		}

		// add student details to model
		model.addAttribute("studentsMap", studentsMap);
		return "students";
	}
}
