package com.student.www.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeacherSaveDTO 
{
	private String teachername;
	
	private String address;
	
	private String phone;

	public String getAddress() {
		// TODO Auto-generated method stub
		return address;
	}

	public String getPhone() {
		// TODO Auto-generated method stub
		return phone;
	}

	public String getTeachername() {
		// TODO Auto-generated method stub
		return teachername;
	}
}
