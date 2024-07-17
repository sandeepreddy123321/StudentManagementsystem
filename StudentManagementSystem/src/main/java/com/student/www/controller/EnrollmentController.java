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

import com.student.www.dto.EnrollmentDTO;
import com.student.www.dto.EnrollmentSaveDTO;
import com.student.www.dto.EnrollmentUpdateDTO;
import com.student.www.services.EnrollmentService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/enrollment")
public class EnrollmentController 
{
	@Autowired
    private EnrollmentService enrollmentService;
    @PostMapping(path = "/save")
    public String saveEnrollment(@RequestBody EnrollmentSaveDTO entrollmentSaveDTO)
    {
        String enrollment = enrollmentService.addEnrollment(entrollmentSaveDTO);
        return "enrollment addedd";
    }
    @GetMapping("/getAllEnrollments")
    public List<EnrollmentDTO> getAllEnrollments()
    {
        List<EnrollmentDTO> allEnrollments = enrollmentService.getAllEnrollments();
        return allEnrollments;
    }
    @PutMapping(path = "/update")
    public String updateEnrollment(@RequestBody EnrollmentUpdateDTO enrollmentUpdateDTO)
    {
        String enrollment = enrollmentService.updateEnrollment(enrollmentUpdateDTO);
        return enrollment;
    }
    @DeleteMapping(path = "/delete/{id}")
    public String deleteEnrollment(@PathVariable(value = "id")int id)
    {
        boolean deleteCourse = enrollmentService.deleteEnrollment(id);
        return "deletedddddd!!!!";
    }
}
