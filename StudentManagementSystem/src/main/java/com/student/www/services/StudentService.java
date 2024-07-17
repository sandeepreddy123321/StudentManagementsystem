package com.student.www.services;
import java.util.List;

import com.student.www.dto.StudentDTO;
import com.student.www.dto.StudentSaveDTO;
import com.student.www.dto.StudentUpdateDTO;
public interface StudentService 
{
	String addStudent(StudentSaveDTO studentSaveDTO);

	List<StudentDTO> getAllStudents();

	String updateStudent(StudentUpdateDTO studentUpdateDTO);

	boolean deleteStudent(int id);
}
