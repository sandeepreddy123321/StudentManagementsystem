package com.student.www.services.IMPL;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.www.dto.StudentDTO;
import com.student.www.dto.StudentSaveDTO;
import com.student.www.dto.StudentUpdateDTO;
import com.student.www.entity.Student;
import com.student.www.repo.StudentRepo;
import com.student.www.services.StudentService;

@Service
public class StudentServiceIMPL implements StudentService
{
	
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public String addStudent(StudentSaveDTO studentSaveDTO) {
		// TODO Auto-generated method stub
		Student student=new Student(
				studentSaveDTO.getStudentname(),
				studentSaveDTO.getAddress(),
				studentSaveDTO.getPhone()
				);
		studentRepo.save(student);
		
		return student.getStudentname();
	}

	@Override
	public List<StudentDTO> getAllStudents() {
		// TODO Auto-generated method stub
		List<Student>getStudents=studentRepo.findAll();
		List<StudentDTO>studentDTOList=new ArrayList<>();
		
		for(Student student:getStudents)
		{
			StudentDTO studentDTO =new StudentDTO(
					student.getStudentid(),
					student.getStudentname(),
					student.getAddress(),
					student.getPhone()
					);
			studentDTOList.add(studentDTO);
		}
		return studentDTOList;
	}

	@Override
	public String updateStudent(StudentUpdateDTO studentUpdateDTO) 
	{
		// TODO Auto-generated method stub
		if(studentRepo.existsById(studentUpdateDTO.getStudentid()))
		{
			Student student=studentRepo.getById(studentUpdateDTO.getStudentid());
			student.setStudentname(studentUpdateDTO.getStudentname());
			student.setAddress(studentUpdateDTO.getAddress());
			student.setPhone(studentUpdateDTO.getPhone());
			studentRepo.save(student);
			return student.getStudentname();
		}
		else 
		{
			System.out.println("student Id is not found");
		}
		
		return null;
	}

	@Override
	public boolean deleteStudent(int id) {
		// TODO Auto-generated method stub
		if(studentRepo.existsById(id))
		{
			studentRepo.deleteById(id);
		}
		else 
		{
			System.out.println("Student id not found!");
		}
		return false;
	}
	
}
