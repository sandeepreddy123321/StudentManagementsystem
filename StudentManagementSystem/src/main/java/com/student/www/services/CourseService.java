package com.student.www.services;

import java.util.List;

import com.student.www.dto.CourseDTO;
import com.student.www.dto.CourseSaveDTO;
import com.student.www.dto.CourseUpdateDTO;

public interface CourseService {

	String addCourse(CourseSaveDTO courseSaveDTO);

	List<CourseDTO> getAllCourses();

	String updateCourse(CourseUpdateDTO courseUpdateDTO);

	boolean deleteCourse(int id);

}
