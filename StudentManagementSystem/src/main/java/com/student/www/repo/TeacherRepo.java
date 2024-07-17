package com.student.www.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.www.entity.Teacher;

public interface TeacherRepo extends JpaRepository<Teacher,Integer>
{

}
