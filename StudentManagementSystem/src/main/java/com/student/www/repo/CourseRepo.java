package com.student.www.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.www.entity.Course;

public interface CourseRepo extends JpaRepository<Course,Integer> {

}
