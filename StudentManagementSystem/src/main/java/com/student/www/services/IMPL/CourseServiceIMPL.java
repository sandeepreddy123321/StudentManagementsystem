package com.student.www.services.IMPL;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.www.dto.CourseDTO;
import com.student.www.dto.CourseSaveDTO;
import com.student.www.dto.CourseUpdateDTO;
import com.student.www.entity.Course;
import com.student.www.repo.CourseRepo;
import com.student.www.services.CourseService;

@Service
public class CourseServiceIMPL implements CourseService {

	
	@Autowired
	private CourseRepo courseRepo;
	
	@Override
	public String addCourse(CourseSaveDTO courseSaveDTO) {
		// TODO Auto-generated method stub
		Course course=new Course(
				courseSaveDTO.getCoursename(),
				courseSaveDTO.getSyllabus(),
				courseSaveDTO.getDuration()
				);
		courseRepo.save(course);
		
		return course.getCoursename();
	}
	
	@Override
	public List<CourseDTO> getAllCourses() {
		// TODO Auto-generated method stub
		List<Course>getCourses=courseRepo.findAll();
		List<CourseDTO>courseDTOList=new ArrayList<>();
		
		for(Course course:getCourses)
		{
			CourseDTO courseDTO =new CourseDTO(
					course.getCourseid(),
					course.getCoursename(),
					course.getSyllabus(),
					course.getDuration()
					);
			courseDTOList.add(courseDTO);
		}
		return courseDTOList;
	}

	@Override
	public String updateCourse(CourseUpdateDTO courseUpdateDTO) {
		// TODO Auto-generated method stub
		if(courseRepo.existsById(courseUpdateDTO.getCourseid()))
		{
			Course course=courseRepo.getById(courseUpdateDTO.getCourseid());
			course.setCoursename(courseUpdateDTO.getCoursename());
			course.setSyllabus(courseUpdateDTO.getSyllabus());
			course.setDuration(courseUpdateDTO.getDuration());
			courseRepo.save(course);
			return course.getCoursename();
		}
		else 
		{
			System.out.println("course Id is not found");
		}
		
		return null;
	}

	@Override
	public boolean deleteCourse(int id) {
		// TODO Auto-generated method stub
		if(courseRepo.existsById(id))
		{
			courseRepo.deleteById(id);
		}
		else 
		{
			System.out.println("Student id not found!");
		}
		return false;
	}

}
