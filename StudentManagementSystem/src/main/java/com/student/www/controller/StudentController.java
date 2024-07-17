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

import com.student.www.dto.StudentDTO;
import com.student.www.dto.StudentSaveDTO;
import com.student.www.dto.StudentUpdateDTO;
import com.student.www.services.StudentService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/student")
public class StudentController 
{
	@Autowired
	private StudentService studentService;
	
	@PostMapping(path="/save")
	public String saveStudent(@RequestBody StudentSaveDTO studentSaveDTO)
	{
		String stname=studentService.addStudent(studentSaveDTO);
		return stname;
		
	}
	
	@GetMapping("/getAllStudents")
	public List<StudentDTO>getAllStudents()
	{
		List<StudentDTO>allStudents=studentService.getAllStudents();
		return allStudents;
		
	}
	
	@PutMapping(path="/update")
	public String updateStudent(@RequestBody StudentUpdateDTO studentUpdateDTO)
	{
		String stname=studentService.updateStudent(studentUpdateDTO);
		return stname;
		
	}
	
	@DeleteMapping(path="/delete/{id}")
	public String deleteStudent(@PathVariable(value="id")int id)
	{
		boolean deleteStudent=studentService.deleteStudent(id);
		return "record deleted!!";
	}
	
}
