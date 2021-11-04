package com.bridgelabz.EmployeePayRollApp.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class EmployeePayrollDTO {
	
	@Pattern(regexp = "^[A-Z]{1}[a-z]{2,}$",message = "employee name Invalid")
	public String name;
	@Min(value = 500,message = "Min wage should be more than 50")
	public long salary;
	
	public EmployeePayrollDTO(String name, long salary){
	}
	@Override 
	public String toString() {
		return "name="+name+":salary="+salary;
	}
		
	}
