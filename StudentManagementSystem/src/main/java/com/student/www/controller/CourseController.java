package com.student.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.www.dto.CourseDTO;
import com.student.www.dto.CourseSaveDTO;
import com.student.www.dto.CourseUpdateDTO;
import com.student.www.services.CourseService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/course")
public class CourseController 
{
	@Autowired
	private CourseService courseService;
	
	@PostMapping(path="/save")
	public String saveCourse(@RequestBody CourseSaveDTO courseSaveDTO)
	{
		String course=courseService.addCourse(courseSaveDTO);
		return course;
		
	}
	
	@GetMapping("/getAllCourses")
	public List<CourseDTO>getAllCourses()
	{
		List<CourseDTO>allCourses=courseService.getAllCourses();
		return allCourses;
		
	}
	
	@PutMapping(path="/update")
	public String updateCourse(@RequestBody CourseUpdateDTO courseUpdateDTO)
	{
		String course=courseService.updateCourse(courseUpdateDTO);
		return course;
		
	}
	
	@DeleteMapping(path="/delete/{id}")
	public String deleteCourse(@PathVariable(value="id")int id)
	{
		boolean deleteCourse=courseService.deleteCourse(id);
		return "record deleted!!";
	}
}
