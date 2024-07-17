package com.student.www.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentUpdateDTO 
{
	private int studentid;
	
	private String studentname;
	
	private String address;
	
	private String phone;

	public Integer getStudentid() {
		// TODO Auto-generated method stub
		return studentid;
	}

	public String getStudentname() {
		// TODO Auto-generated method stub
		return studentname;
	}

	public String getAddress() {
		// TODO Auto-generated method stub
		return address;
	}

	public String getPhone() {
		// TODO Auto-generated method stub
		return phone;
	}
}
