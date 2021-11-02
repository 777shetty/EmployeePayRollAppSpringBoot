package com.bridgelabz.EmployeePayRollApp.model;

import com.bridgelabz.EmployeePayRollApp.dto.EmployeePayrollDTO;

public class EmployeePayrollData {
private int employeeId;
private String name;
private long salary;

public EmployeePayrollData() {
}
	
	public EmployeePayrollData(int empid,EmployeePayrollDTO empPayrollDTO) {
		this.setEmployeeId(empid);
		this.setName(empPayrollDTO.name);
		this.setSalary(empPayrollDTO.salary);
		
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}
}

