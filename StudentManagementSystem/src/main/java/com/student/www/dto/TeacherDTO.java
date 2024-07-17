package com.student.www.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeacherDTO 
{
	@JsonProperty("teacherid")
	private int teacherid;
	
	@JsonProperty("teachername")
	private String teachername;
	
	@JsonProperty("address")
	private String address;
	
	@JsonProperty("phone")
	private String phone;

	public TeacherDTO(int teacherid, String teachername, String address, String phone) {
		this.teacherid = teacherid;
		this.teachername = teachername;
		this.address = address;
		this.phone = phone;
	}
	
	
}
