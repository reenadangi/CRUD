package com.reena.projects.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reena.projects.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
	
//	Get all student 
	List<Student> findAll();

}
