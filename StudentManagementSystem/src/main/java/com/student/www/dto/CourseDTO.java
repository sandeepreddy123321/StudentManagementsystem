package com.student.www.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO 
{
	@JsonProperty("courseid")
	private int courseid;
	
	@JsonProperty("coursename")
	private String coursename;
	
	@JsonProperty("syllabus")
	private String syllabus;
	
	@JsonProperty("duration")
	private String duration;

	public CourseDTO(int courseid, String coursename, String syllabus, String duration) {
		this.courseid = courseid;
		this.coursename = coursename;
		this.syllabus = syllabus;
		this.duration = duration;
	}
	
	
}
