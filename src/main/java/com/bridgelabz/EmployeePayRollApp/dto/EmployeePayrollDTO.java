package com.bridgelabz.EmployeePayRollApp.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.ToString;

public @ToString class EmployeePayrollDTO {
	
	@Pattern(regexp = "^[A-Z]{1}[a-z]{2,}$",message = "employee name Invalid")
	public String name;
	@Min(value = 500,message = "Min wage should be more than 50")
	public long salary;
	
	public String gender;
	
	@JsonFormat(pattern="dd MMM YYYY")
	public LocalDate startDate;
	
	public String note;
	
	public String profilepic;
	
	public List<String>department;
 
	
	}
