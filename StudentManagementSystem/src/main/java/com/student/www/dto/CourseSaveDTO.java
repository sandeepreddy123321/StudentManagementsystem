package com.student.www.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseSaveDTO 
{
	private String coursename;
	
	private String syllabus;
	
	private String duration;

	public String getCoursename() {
		// TODO Auto-generated method stub
		return coursename;
	}

	public String getSyllabus() {
		// TODO Auto-generated method stub
		return syllabus;
	}

	public String getDuration() {
		// TODO Auto-generated method stub
		return duration;
	}
}
