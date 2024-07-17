package com.student.www.services.IMPL;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.www.dto.StudentDTO;
import com.student.www.dto.TeacherDTO;
import com.student.www.dto.TeacherSaveDTO;
import com.student.www.dto.TeacherUpdateDTO;
import com.student.www.entity.Student;
import com.student.www.entity.Teacher;
import com.student.www.repo.TeacherRepo;
import com.student.www.services.TeacherService;

@Service
public class TeacherServiceIMPL implements TeacherService {

	
	@Autowired
	private TeacherRepo teacherRepo;
	
	@Override
	public String addTeacher(TeacherSaveDTO teacherSaveDTO) {
		// TODO Auto-generated method stub
		Teacher teacher=new Teacher(
				teacherSaveDTO.getTeachername(),
				teacherSaveDTO.getAddress(),
				teacherSaveDTO.getPhone()
				);
		teacherRepo.save(teacher);
		
		return teacher.getTeachername();
	}

	@Override
	public String updateTeacher(TeacherUpdateDTO teacherUpdateDTO) {
		// TODO Auto-generated method stub
		if(teacherRepo.existsById(teacherUpdateDTO.getTeacherid()))
		{
			Teacher teacher=teacherRepo.getById(teacherUpdateDTO.getTeacherid());
			teacher.setTeachername(teacherUpdateDTO.getTeachername());
			teacher.setAddress(teacherUpdateDTO.getAddress());
			teacher.setPhone(teacherUpdateDTO.getPhone());
			teacherRepo.save(teacher);
			return teacher.getTeachername();
		}
		else 
		{
			System.out.println("student Id is not found");
		}
		return null;
	}

	@Override
	public boolean deleteTeacher(int id) {
		// TODO Auto-generated method stub
		if(teacherRepo.existsById(id))
		{
			teacherRepo.deleteById(id);
		}
		else 
		{
			System.out.println("Student id not found!");
		}
		return false;
	}

	@Override
	public List<TeacherDTO> getAllTeachers() 
	{
		List<Teacher>getTeachers=teacherRepo.findAll();
		List<TeacherDTO>teacherDTOList=new ArrayList<>();
		
		for(Teacher teacher:getTeachers)
		{
			TeacherDTO teacherDTO =new TeacherDTO(
					teacher.getTeacherid(),
					teacher.getTeachername(),
					teacher.getAddress(),
					teacher.getPhone()
					);
			teacherDTOList.add(teacherDTO);
		}
		return teacherDTOList;
	}

}
