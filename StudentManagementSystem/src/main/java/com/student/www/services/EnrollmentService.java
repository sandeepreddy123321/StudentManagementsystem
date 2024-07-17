package com.student.www.services;

import java.util.List;

import com.student.www.dto.EnrollmentDTO;
import com.student.www.dto.EnrollmentSaveDTO;
import com.student.www.dto.EnrollmentUpdateDTO;

public interface EnrollmentService {

	String addEnrollment(EnrollmentSaveDTO entrollmentSaveDTO);

	List<EnrollmentDTO> getAllEnrollments();

	String updateEnrollment(EnrollmentUpdateDTO enrollmentUpdateDTO);

	boolean deleteEnrollment(int id);

}
