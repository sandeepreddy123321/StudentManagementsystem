package com.student.www.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnrollmentUpdateDTO {
    private int enrollid;
    
    private int student_id;
    
    private int batch_id;
    
    private String joindate;
    
    private int fee;

	public Integer getEnrollid() {
		// TODO Auto-generated method stub
		return enrollid;
	}

	public Integer getStudent_id() {
		// TODO Auto-generated method stub
		return student_id;
	}

	public Integer getBatch_id() {
		// TODO Auto-generated method stub
		return batch_id;
	}

	public String getJoindate() {
		// TODO Auto-generated method stub
		return joindate;
	}

	public int getFee() {
		// TODO Auto-generated method stub
		return fee;
	}
}