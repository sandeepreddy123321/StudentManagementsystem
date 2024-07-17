package com.student.www.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.student.www.entity.Batch;
import com.student.www.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnrollmentDTO {
	
	@JsonProperty("enrollid")
	private int enrollid;
	
	@JsonProperty("student")
    private Student student;
	
	@JsonProperty("batch")
    private Batch batch;
	
	@JsonProperty("joindate")
    private String joindate;
	
	@JsonProperty("fee")
    private int fee;

	public EnrollmentDTO(int enrollid, Student student, Batch batch, String joindate, int fee) {
		super();
		this.enrollid = enrollid;
		this.student = student;
		this.batch = batch;
		this.joindate = joindate;
		this.fee = fee;
	}
	
	
}
