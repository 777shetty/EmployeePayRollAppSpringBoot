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

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
	
	@RequestMapping(value= {"","/","/get"})
	public ResponseEntity<String>getEmployeePayrollData(){
		return new ResponseEntity<String>("Get call success",HttpStatus.OK);
	}
	@GetMapping("/get/{empId}")
	public ResponseEntity<String>getEmployeePayrollData(@PathVariable("empid")int empid){
		return new ResponseEntity<String>("Get call success  for id"+empid,HttpStatus.OK);
	}
	@PostMapping("/create")
	public ResponseEntity<String>addEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO){
		return new ResponseEntity<String>("Created Employee PayRoll data for"+empPayrollDTO,HttpStatus.OK);
	}
	@PutMapping("/update")
	public ResponseEntity<String>updateEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO){
		return new ResponseEntity<String>("Created Employee PayRoll data for"+empPayrollDTO,HttpStatus.OK);
	}
	@DeleteMapping("/delete{empid}")
	public ResponseEntity<String>deleteEmployeePayrollData(@PathVariable("empid")int empid){
		return new ResponseEntity<String>("Delete call success for id:"+empid,HttpStatus.OK);
	}

}
