package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Employee;
import java.lang.String;




public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	@Override
	Employee save(Employee entity);
	 
	@Override
	 java.util.List<Employee> findAll();
	
	
	List<Employee> findAllByCompanyName(String companyname);
}
