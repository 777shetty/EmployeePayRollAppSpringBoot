package com.bridgelabz.EmployeePayRollApp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.EmployeePayRollApp.Exception.EmployeePayrollException;
import com.bridgelabz.EmployeePayRollApp.Repository.EmployeePayrollRepository;
import com.bridgelabz.EmployeePayRollApp.dto.EmployeePayrollDTO;
import com.bridgelabz.EmployeePayRollApp.model.EmployeePayrollData;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollServices {
	@Autowired
	private EmployeePayrollRepository employeeRepository;
	private List<EmployeePayrollData> employeePayrollList= new ArrayList<>(); 


	public List<EmployeePayrollData> getEmployeePayrollData() {
		return employeePayrollList;
	}


	public EmployeePayrollData getEmployeePayrollDataById(int empid) {
		return employeePayrollList.stream()
				.filter(empData->empData.getEmployeeId()==empid)
				.findFirst()
				.orElseThrow(()-> new EmployeePayrollException("Employee not found"));
	}


	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData=null;
		empData = new EmployeePayrollData(empPayrollDTO);
		employeePayrollList.add(empData);
		log.debug("EmpData:"+empData.toString());
		return employeeRepository.save(empData);
	}


	public EmployeePayrollData updateEmployeePayrollData(int empid, EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData empData=this.getEmployeePayrollDataById(empid);
		empData.setName(employeePayrollDTO.name);
		empData.setSalary(employeePayrollDTO.salary);
		employeePayrollList.set(empid-1,empData);
		return empData;
	}


	public void deleteEmployeePayrollData(int empid) {
		employeePayrollList.remove(empid-1);
		
	}

}
