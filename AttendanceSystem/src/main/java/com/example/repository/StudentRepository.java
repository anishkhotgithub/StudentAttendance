package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.example.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long>
{

	Student findById(long id);
	List findByBatch(String batch);	
}
