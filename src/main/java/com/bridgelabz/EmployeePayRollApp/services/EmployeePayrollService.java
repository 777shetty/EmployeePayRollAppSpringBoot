package com.bridgelabz.EmployeePayRollApp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.EmployeePayRollApp.dto.EmployeePayrollDTO;
import com.bridgelabz.EmployeePayRollApp.model.EmployeePayrollData;

@Service
public class EmployeePayrollService implements IEmployeePayrollServices {
	private List<EmployeePayrollData> employeePayrollList= new ArrayList<EmployeePayrollData>(); 

	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return employeePayrollList;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empid) {
		return employeePayrollList.get(empid-1);
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData employeePayrollData=null;
		employeePayrollData = new EmployeePayrollData(1,employeePayrollDTO);
		employeePayrollList.add(employeePayrollData);
		return employeePayrollData;
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empid, EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData empData=this.getEmployeePayrollDataById(empid);
		empData.setName(employeePayrollDTO.name);
		empData.setSalary(employeePayrollDTO.salary);
		employeePayrollList.set(empid-1,empData);
		return empData;
	}

	@Override
	public void deleteEmployeePayrollData(int empid) {
		employeePayrollList.remove(empid-1);
		
	}

}
