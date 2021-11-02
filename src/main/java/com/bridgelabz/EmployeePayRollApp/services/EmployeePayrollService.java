package com.bridgelabz.EmployeePayRollApp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.EmployeePayRollApp.dto.EmployeePayrollDTO;
import com.bridgelabz.EmployeePayRollApp.model.EmployeePayrollData;

@Service
public class EmployeePayrollService implements IEmployeePayrollServices {

	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		List<EmployeePayrollData> employeePayrollList=new ArrayList<>();
		employeePayrollList.add(new EmployeePayrollData(1, new EmployeePayrollDTO("Chethan", 30000)));
		return employeePayrollList;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empid) {
		EmployeePayrollData employeePayrollData=null;
		employeePayrollData=new EmployeePayrollData(empid, new EmployeePayrollDTO("Chethan", 30000));
		return employeePayrollData;
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData employeePayrollData=null;
		employeePayrollData = new EmployeePayrollData(1,employeePayrollDTO);
		return employeePayrollData;
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empid, EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData employeePayrollData=null;
		employeePayrollData= new EmployeePayrollData(empid, employeePayrollDTO);
		return employeePayrollData;
	}

	@Override
	public void deleteEmployeePayrollData(int empid) {
		// TODO Auto-generated method stub
		
	}

}
