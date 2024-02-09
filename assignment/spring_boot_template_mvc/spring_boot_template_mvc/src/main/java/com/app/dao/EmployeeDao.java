package com.app.dao;

import java.util.List;

import com.app.pojos.Employee;




public interface EmployeeDao {

	String addEmployee(Employee newEmployee);
	List<Employee> getAllEmployee();
	List<Employee> getAllEmployeeByCompany(String company);
}
