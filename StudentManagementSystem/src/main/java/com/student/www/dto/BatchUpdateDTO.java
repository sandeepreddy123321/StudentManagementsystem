package com.student.www.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchUpdateDTO 
{
	
	private int batchid;
	
	private String batchname;
	
	private int courseid;
	
	private String startdate;

	public int getBatchid() {
		return batchid;
	}

	public String getBatchname() {
		return batchname;
	}

	public int getCourseid() {
		return courseid;
	}

	public String getStartdate() {
		return startdate;
	}
}
