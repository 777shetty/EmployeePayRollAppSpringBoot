package com.bridgelabz.EmployeePayRollApp.services;

import java.util.List;

import com.bridgelabz.EmployeePayRollApp.dto.EmployeePayrollDTO;
import com.bridgelabz.EmployeePayRollApp.model.EmployeePayrollData;

public interface IEmployeePayrollServices {
	List<EmployeePayrollData>getEmployeePayrollData();
	
	EmployeePayrollData getEmployeePayrollDataById(int empid);
	EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);
	EmployeePayrollData updateEmployeePayrollData(int empid, EmployeePayrollDTO employeePayrollDTO);
	void deleteEmployeePayrollData(int empid);
	

}
