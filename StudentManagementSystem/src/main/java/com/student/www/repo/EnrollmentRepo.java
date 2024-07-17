package com.student.www.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.www.entity.Enrollment;

public interface EnrollmentRepo extends JpaRepository<Enrollment,Integer> {

}
