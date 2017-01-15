package com.mtcl.oc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mtcl.oc.entity.Course;
import com.mtcl.oc.entity.Student;
import com.mtcl.oc.entity.Teacher;
import com.mtcl.oc.service.CourseService;
import com.mtcl.oc.service.StudentService;
import com.mtcl.oc.service.TeacherService;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

	@Autowired
	TeacherService tService;

	@Autowired
	StudentService sService;

	@Autowired
	CourseService cService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(Model model) {
		Map<Integer, String> teachersMap = new HashMap<Integer, String>();

		List<Teacher> teacherList = tService.findAll();
		System.out.println("Number of teachers found is :: " + teacherList.size());
		for (Teacher teacher : teacherList) {
			//System.out.println(teacher.getTId() + " , " + teacher.getName());
			teachersMap.put(teacher.getTId(), teacher.getName());
		}

		model.addAttribute("teachersMap", teachersMap);
		return "teachers";
	}

	@RequestMapping(value = "/{id}/students", method = RequestMethod.GET)
	public String getStudents(@PathVariable("id") int id, Model model) {
		Map<Integer, String> studentsMap = new HashMap<Integer, String>();

		// add teacher name to model
		model.addAttribute("teacherName", tService.findOne(id).getName());

		List<Student> studentList = sService.findByTeacherId(id);
		for (Student s : studentList) {
			studentsMap.put(s.getSId(), s.getName());
		}

		// add student details to model
		model.addAttribute("studentsMap", studentsMap);

		return "students";
	}

	@RequestMapping(value = "/{id}/courses", method = RequestMethod.GET)
	public String getCourses(@PathVariable("id") int id, Model model) {
		Map<Integer, String> coursesMap = new HashMap<Integer, String>();

		// add teacher name to model
		model.addAttribute("teacherName", tService.findOne(id).getName());

		List<Course> courseList = cService.findByTeacherId(id);
		for (Course s : courseList) {
			coursesMap.put(s.getCId(), s.getName());
		}

		// add student details to model
		model.addAttribute("coursesMap", coursesMap);

		return "courses";
	}
}
