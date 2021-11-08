package com.bridgelabz.EmployeePayRollApp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.EmployeePayRollApp.dto.EmployeePayrollDTO;
import com.bridgelabz.EmployeePayRollApp.dto.ResponseDTO;
import com.bridgelabz.EmployeePayRollApp.model.EmployeePayrollData;
import com.bridgelabz.EmployeePayRollApp.services.EmployeePayrollService;
import com.bridgelabz.EmployeePayRollApp.services.IEmployeePayrollServices;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/employeepayrollservice")
@Slf4j
public class EmployeePayrollController {
	    @Autowired
	    private IEmployeePayrollServices employeePayrollService;

	    @RequestMapping(value = {"","/","/get"})
	    public ResponseEntity<ResponseDTO> getEmployeePayrollData()
	    {
	        List<EmployeePayrollData> empDataList=null;
	        empDataList=employeePayrollService.getEmployeePayrollData();
	        ResponseDTO respDTO = new ResponseDTO("Get call Succesfull", empDataList);
	        return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	    }

	    @GetMapping("/get/{empId}")
	    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId)
	    {
	    	EmployeePayrollData empData=null;
	        empData=employeePayrollService.getEmployeePayrollDataById(empId);
	        ResponseDTO respDTO = new ResponseDTO("Get call For ID Succesfull", empData);
	        return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	    }
	    
	    @GetMapping("/department/{department}")
	    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("department") String department)
	    {
	    	List<EmployeePayrollData> empDataList=null;
	        empDataList=employeePayrollService.getEmployeesByDepartment(department);
	        ResponseDTO respDTO = new ResponseDTO("Get call For ID Succesfull", empDataList);
	        return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	    }
	    
	    @PostMapping("/create")
	    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO)
	    {
	    	EmployeePayrollData empData=null;
	        empData= employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
	        ResponseDTO respDTO = new ResponseDTO("Created payroll data successfully", empData);
	        return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	    }
		
	    @PutMapping("/update/{empId}")
	    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId,@RequestBody EmployeePayrollDTO employeePayrollDTO)
	    {

	    	EmployeePayrollData empData=null;
	        empData= employeePayrollService.updateEmployeePayrollData(empId,employeePayrollDTO);
	        ResponseDTO respDTO = new ResponseDTO("Created payroll data successfully", empData);
	        return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	    }
	    @DeleteMapping("/delete/{empId}")
	    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId)
	    {
	        employeePayrollService.deleteEmployeePayrollData(empId);
	        ResponseDTO respDTO = new ResponseDTO("Deleted successfuly","Deleted id: "+empId);
	        return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	    }
	}
