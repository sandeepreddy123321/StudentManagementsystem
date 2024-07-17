package com.student.www.services.IMPL;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.www.dto.EnrollmentDTO;
import com.student.www.dto.EnrollmentSaveDTO;
import com.student.www.dto.EnrollmentUpdateDTO;
import com.student.www.entity.Batch;
import com.student.www.entity.Enrollment;
import com.student.www.entity.Student;
import com.student.www.repo.BatchRepo;
import com.student.www.repo.EnrollmentRepo;
import com.student.www.repo.StudentRepo;
import com.student.www.services.EnrollmentService;

@Service
public class EnrollmentServiceIMPL implements EnrollmentService {

    @Autowired
    private EnrollmentRepo enrollmentRepo;
    
    @Autowired
    private StudentRepo studentRepo;
    
    @Autowired
    private BatchRepo batchRepo;
    
    @Override
    @Transactional
    public String addEnrollment(EnrollmentSaveDTO enrollmentSaveDTO) {
    	Optional<Student> studentOpt = studentRepo.findById(enrollmentSaveDTO.getStudent_id());
        if (!studentOpt.isPresent()) {
            throw new IllegalArgumentException("Student ID not found: " + enrollmentSaveDTO.getStudent_id());
        }
        Student student = studentOpt.get();

        // Fetch the batch entity from the repository
        Optional<Batch> batchOpt = batchRepo.findById(enrollmentSaveDTO.getBatch_id());
        if (!batchOpt.isPresent()) {
            throw new IllegalArgumentException("Batch ID not found: " + enrollmentSaveDTO.getBatch_id());
        }
        Batch batch = batchOpt.get();

        // Create and save the enrollment entity
        Enrollment enrollment = new Enrollment(student, batch, enrollmentSaveDTO.getJoindate(), enrollmentSaveDTO.getFee());
        enrollmentRepo.save(enrollment);

        return "Enrollment added successfully";
    }

    @Override
    public List<EnrollmentDTO> getAllEnrollments() {
        List<Enrollment> getEnrollments = enrollmentRepo.findAll();
        List<EnrollmentDTO> enrollmentDTOList = new ArrayList<>();
        for (Enrollment enrollment : getEnrollments) {
            EnrollmentDTO enrollmentDTO = new EnrollmentDTO(
                    enrollment.getEnrollid(),
                    enrollment.getStudent(),
                    enrollment.getBatch(),
                    enrollment.getJoindate(),
                    enrollment.getFee()
            );
            enrollmentDTOList.add(enrollmentDTO);
        }
        return enrollmentDTOList;
    }

    @Override
    @Transactional
    public String updateEnrollment(EnrollmentUpdateDTO enrollmentUpdateDTO) {
        if (!enrollmentRepo.existsById(enrollmentUpdateDTO.getEnrollid())) {
            throw new IllegalArgumentException("Enrollment ID not found: " + enrollmentUpdateDTO.getEnrollid());
        }

        if (!studentRepo.existsById(enrollmentUpdateDTO.getStudent_id())) {
            throw new IllegalArgumentException("Student ID not found: " + enrollmentUpdateDTO.getStudent_id());
        }
        
        if (!batchRepo.existsById(enrollmentUpdateDTO.getBatch_id())) {
            throw new IllegalArgumentException("Batch ID not found: " + enrollmentUpdateDTO.getBatch_id());
        }
        
        Enrollment enrollment = enrollmentRepo.getById(enrollmentUpdateDTO.getEnrollid());
        enrollment.setStudent(studentRepo.getById(enrollmentUpdateDTO.getStudent_id()));
        enrollment.setBatch(batchRepo.getReferenceById(enrollmentUpdateDTO.getBatch_id()));
        enrollment.setJoindate(enrollmentUpdateDTO.getJoindate());
        enrollment.setFee(enrollmentUpdateDTO.getFee());
        enrollmentRepo.save(enrollment);
        return enrollment.getJoindate();
    }

    @Override
    @Transactional
    public boolean deleteEnrollment(int id) {
        if (!enrollmentRepo.existsById(id)) {
            throw new IllegalArgumentException("Enrollment ID not found: " + id);
        }
        enrollmentRepo.deleteById(id);
        return true;
    }
}
