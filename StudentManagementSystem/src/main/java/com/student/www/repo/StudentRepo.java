package com.student.www.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.www.entity.Student;

public interface StudentRepo extends JpaRepository<Student,Integer>
{
	
}
