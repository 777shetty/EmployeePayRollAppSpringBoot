package com.bridgelabz.EmployeePayRollApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.EmployeePayRollApp.model.EmployeePayrollData;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData,Integer> {

}
