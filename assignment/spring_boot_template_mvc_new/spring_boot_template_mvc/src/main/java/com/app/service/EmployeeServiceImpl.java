package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.EmployeeDao;
import com.app.pojos.Employee;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao ed;
	@Override
	public String addEmp(Employee newemp) {
		 ed.save(newemp);
		 return "Employee Added successfully!!!";
	}

	@Override
	public List<Employee> getAllEmployee() {
		return ed.findAll();
		
	}

	@Override
	public List<Employee> getAllEmployeeByCmp(String cmpName) {
		
		return ed.findAllByCompanyName(cmpName);
	}

}
