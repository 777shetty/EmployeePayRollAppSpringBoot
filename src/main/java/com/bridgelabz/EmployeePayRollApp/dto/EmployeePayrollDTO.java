package com.bridgelabz.EmployeePayRollApp.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.ToString;

public @ToString class EmployeePayrollDTO {
	
	@Pattern(regexp = "^[A-Z]{1}[a-z]{2,}$",message = "employee name Invalid")
	public String name;
	@Min(value = 500,message = "Min wage should be more than 50")
	public long salary;
	
	@Pattern(regexp="male|female",message="Gender need to be male or female")
	public String gender;
	
	@JsonFormat(pattern="dd MMM YYYY")
	@NotNull(message="startDate should not be empty")
	@PastOrPresent(message="Start date should be past or todays date")
	public LocalDate startDate;
	
	@NotBlank(message="Not should not be balmck")
	public String note;
	
	@NotBlank(message="ProfilePic should not be empty")
	public String profilepic;
	
	@NotNull(message="Department should not be empty")
	public List<String>department;
 
	
	}
