package com.bridgelabz.EmployeePayRollApp.controller;

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

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
	
	@RequestMapping(value= {"","/","/get"})
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(){
		EmployeePayrollData employeePayrollData=null;
		employeePayrollData=new EmployeePayrollData(1,new EmployeePayrollDTO("Pankaj", 3000));
		ResponseDTO respDTO= new ResponseDTO("Get call success", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	@GetMapping("/get/{empid}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empid")int empid){
		EmployeePayrollData employeePayrollData=null;
		employeePayrollData=new EmployeePayrollData(1,new EmployeePayrollDTO("Pankaj", 3000));
		ResponseDTO respDTO= new ResponseDTO("Get call for id successful", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO){
		EmployeePayrollData employeePayrollData=null;
		employeePayrollData=new EmployeePayrollData(1,empPayrollDTO);
		ResponseDTO respDTO= new ResponseDTO("Crated Employee PayrollData is successful", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	@PutMapping("/update/{empid}")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empid")int empid, @RequestBody EmployeePayrollDTO empPayrollDTO){
		EmployeePayrollData employeePayrollData=null;
		employeePayrollData=new EmployeePayrollData(empid,empPayrollDTO);
		ResponseDTO respDTO= new ResponseDTO("Updated Employee PayrollData is successful", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	@DeleteMapping("/delete{empid}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empid")int empid){
		ResponseDTO respDTO= new ResponseDTO("Deleted successfully","DeletedId: "+empid);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

}
