package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer> 
{
	Faculty findByUserid(int userid);
	Faculty findByUsername(String username);
}
