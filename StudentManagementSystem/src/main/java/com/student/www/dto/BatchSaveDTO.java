package com.student.www.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchSaveDTO 
{
	private String batchname;
	
	private int courseid;
	
	private String startdate;

	public String getBatchname() {
		// TODO Auto-generated method stub
		return batchname;
	}

	public String getStartdate() {
		// TODO Auto-generated method stub
		return startdate;
	}

	public Integer getCourseid() {
		// TODO Auto-generated method stub
		return courseid;
	}

}
