package com.student.www.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.student.www.entity.Course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchDTO 
{
	@JsonProperty("batchid")
	private int batchid;
	
	@JsonProperty("batchname")
	private String batchname;
	
	@JsonProperty("course")
	private Course course;
	
	@JsonProperty("startdate")
	private String startdate;

	public BatchDTO(int batchid, String batchname, Course course, String startdate) {
		this.batchid = batchid;
		this.batchname = batchname;
		this.course = course;
		this.startdate = startdate;
	}

	
	
}
