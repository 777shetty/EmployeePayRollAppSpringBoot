package com.bridgelabz.EmployeePayRollApp.services;

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
	


	public List<EmployeePayrollData> getEmployeePayrollData() {
		return employeeRepository.findAll();
	}


	public EmployeePayrollData getEmployeePayrollDataById(int empid) {
		return employeeRepository
				.findById(empid)
				.orElseThrow(()-> new EmployeePayrollException("Employee with employeeId"+empid+"does not exists...."));
	}

	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData=null;
		empData = new EmployeePayrollData(empPayrollDTO);
		log.debug("EmpData:"+empData.toString());
		return employeeRepository.save(empData);
	}


	public EmployeePayrollData updateEmployeePayrollData(int empid, EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData=this.getEmployeePayrollDataById(empid);
		empData.updateEmployeePayrollData(empPayrollDTO);
		return employeeRepository.save(empData);
	}


	public void deleteEmployeePayrollData(int empid) {
		EmployeePayrollData empData=this.getEmployeePayrollDataById(empid);
		employeeRepository.delete(empData);
		
	}

}
