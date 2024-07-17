package com.student.www.services;

import java.util.List;

import com.student.www.dto.TeacherDTO;
import com.student.www.dto.TeacherSaveDTO;
import com.student.www.dto.TeacherUpdateDTO;

public interface TeacherService {

	String addTeacher(TeacherSaveDTO teacherSaveDTO);

	String updateTeacher(TeacherUpdateDTO teacherUpdateDTO);

	boolean deleteTeacher(int id);

	List<TeacherDTO> getAllTeachers();

}
