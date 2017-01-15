package com.mtcl.oc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mtcl.oc.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Query(value = "SELECT * from student s join s_tc_xref stc on s.s_id = stc.s_id join t_c_xref tc on stc.tc_id = tc.tc_id where tc.t_id = ?1", nativeQuery = true)
	List<Student> findByTeacherId(Integer id);

}
