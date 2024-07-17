package com.student.www.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
	
	@JsonProperty("studentid")
    private int studentid;
	
	@JsonProperty("studentname")
    private String studentname;
	
	@JsonProperty("address")
    private String address;
	
	@JsonProperty("phone")
    private String phone;

    // Custom constructor with parameters
    public StudentDTO(int studentid, String studentname, String address, String phone) {
        this.studentid = studentid;
        this.studentname = studentname;
        this.address = address;
        this.phone = phone;
    }
}
