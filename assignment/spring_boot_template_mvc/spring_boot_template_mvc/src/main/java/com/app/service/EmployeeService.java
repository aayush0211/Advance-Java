package com.app.service;

import java.util.List;

import com.app.pojos.Employee;

public interface EmployeeService {
	String addEmp(Employee newemp);
	List<Employee> getAllEmployee();
	List<Employee> getAllEmployeeByCmp(String cmpName);
}
