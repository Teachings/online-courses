package com.mtcl.oc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mtcl.oc.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{
	
	@Query(value = "SELECT * from course c join t_c_xref tc on c.c_id = tc.c_id where tc.t_id = ?1", nativeQuery = true)
	List<Course> findByTeacherId(Integer id);

}
