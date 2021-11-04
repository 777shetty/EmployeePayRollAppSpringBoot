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

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
	@Autowired
	private IEmployeePayrollServices employeePayrollService;
	
	@RequestMapping(value= {"","/","/get"})
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(){
		List<EmployeePayrollData> employeePayrollList=null;
		employeePayrollList = employeePayrollService.getEmployeePayrollData();
		ResponseDTO respDTO= new ResponseDTO("Get call success", employeePayrollList);
		respDTO.getData();
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	@GetMapping("/get/{empid}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empid")int empid){
		EmployeePayrollData employeePayrollData= employeePayrollService.getEmployeePayrollDataById(empid);
		ResponseDTO respDTO= new ResponseDTO("Get call for id successful", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO empPayrollDTO){
		EmployeePayrollData employeePayrollData=employeePayrollService.createEmployeePayrollData(empPayrollDTO);
			ResponseDTO respDTO= new ResponseDTO("Crated Employee PayrollData is successful", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	@PutMapping("/update/{empid}")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empid")int empid,@Valid @RequestBody EmployeePayrollDTO empPayrollDTO){
		EmployeePayrollData employeePayrollData=employeePayrollService.updateEmployeePayrollData(empid, empPayrollDTO);
		ResponseDTO respDTO= new ResponseDTO("Updated Employee PayrollData is successful", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	@DeleteMapping("/delete{empid}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empid")int empid){
		employeePayrollService.deleteEmployeePayrollData(empid);
		ResponseDTO respDTO= new ResponseDTO("Deleted successfully","DeletedId: "+empid);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

}
