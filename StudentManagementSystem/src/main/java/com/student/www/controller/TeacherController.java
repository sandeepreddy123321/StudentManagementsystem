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

import com.student.www.dto.TeacherDTO;
import com.student.www.dto.TeacherSaveDTO;
import com.student.www.dto.TeacherUpdateDTO;
import com.student.www.services.TeacherService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/teacher")
public class TeacherController 
{
	@Autowired
	private TeacherService teacherService;
	
	@PostMapping(path="/save")
	public String saveTeacher(@RequestBody TeacherSaveDTO teacherSaveDTO)
	{
		String teachername=teacherService.addTeacher(teacherSaveDTO);
		return teachername;
		
	}
	
	@GetMapping("/getAllTeachers")
	public List<TeacherDTO>getAllTeachers()
	{
		List<TeacherDTO>allTeachers=teacherService.getAllTeachers();
		return allTeachers;
		
	}
	
	@PutMapping(path="/update")
	public String updateTeacher(@RequestBody TeacherUpdateDTO teacherUpdateDTO)
	{
		String teachername=teacherService.updateTeacher(teacherUpdateDTO);
		return teachername;
		
	}
	
	@DeleteMapping(path="/delete/{id}")
	public String deleteTeacher(@PathVariable(value="id")int id)
	{
		boolean deleteTeacher=teacherService.deleteTeacher(id);
		return "record deleted!!";
	}
}
